package app;

import static org.junit.jupiter.api.Assertions.*;
import model.Usuario;

import javax.persistence.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

// import entidad.Usuario;   // ajusta al paquete real de tu entidad

class LoginServiceTest {

    static EntityManagerFactory emf;
    static LoginService service;

    static final String USR = "test_login@gmail.com";
    static final String CLA = "1234";

    @BeforeAll
    static void iniciar() {
        emf = Persistence.createEntityManagerFactory("mysqlconex");
        service = new LoginService(emf);

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Borra restos de ejecuciones anteriores
            em.createQuery("delete from Usuario u where u.usr_usua = :usr")
                    .setParameter("usr", USR)
                    .executeUpdate();

            Usuario u = new Usuario();
            u.setUsr_usua(USR);
            u.setCla_usua(CLA);
            u.setNom_usua("Test");
            u.setApe_usua("Login");
            u.setEst_usua(1);
            u.setFna_usua(LocalDate.of(2000, 5, 15));
            u.setIdtipo(2);

            em.persist(u);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @AfterAll
    static void limpiar() {
        if (emf == null) return;

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Usuario u where u.usr_usua = :usr")
                    .setParameter("usr", USR)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

    @Test
    void loginCorrecto() {
        assertNotNull(service.login(USR, CLA));
    }

    @Test
    void claveIncorrecta() {
        assertNull(service.login(USR, "9999"));
    }

    @Test
    void usuarioInexistente() {
        assertNull(service.login("noexiste@gmail.com", CLA));
    }

    @Test
    void camposVacios() {
        assertNull(service.login("", ""));
        assertNull(service.login(null, null));
    }
}