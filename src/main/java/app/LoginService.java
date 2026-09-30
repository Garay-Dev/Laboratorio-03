package app;

import javax.persistence.*;
import model.Usuario;

public class LoginService {

    private final EntityManagerFactory emf;

    public LoginService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Usuario login(String usr, String cla) {
        if (usr == null || cla == null || usr.isBlank() || cla.isBlank()) {
            return null;
        }
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "select u from Usuario u where u.usr_usua = :usr and u.cla_usua = :cla",
                            Usuario.class)
                    .setParameter("usr", usr)
                    .setParameter("cla", cla)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }
}