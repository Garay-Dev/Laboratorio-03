package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

    public static void main(String[] args) {

        // 1. Crear la fábrica de EntityManager
        EntityManagerFactory fabrica =
                Persistence.createEntityManagerFactory("mysqlconex");

        // 2. Crear el manejador de entidades
        EntityManager manager =
                fabrica.createEntityManager();

        // 3. Crear un objeto Usuario
        Usuario u = new Usuario();

        // No colocamos cod_usua porque MySQL lo genera con AUTO_INCREMENT
        u.setNom_usua("Juan");
        u.setApe_usua("Gonzales");
        u.setUsr_usua("correo@gmail.com");
        u.setCla_usua("ushrjso13");
        u.setFna_usua(LocalDate.of(2000, 5, 15));
        u.setIdtipo(2);
        u.setEst_usua(1);

        try {

            // 4. Iniciar transacción
            manager.getTransaction().begin();

            // 5. Hacer persistente el nuevo objeto
            manager.persist(u);

            // 6. Confirmar la transacción
            manager.getTransaction().commit();

            System.out.println("Registro Ok");
            System.out.println("Código generado: " + u.getCod_usua());
            System.out.println(u);

        } catch (Exception e) {

            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }

            System.err.println("No se pudo realizar el registro");
            System.err.println("Error: " + e.getMessage());

            e.printStackTrace();

        } finally {

            if (manager.isOpen()) {
                manager.close();
            }

            if (fabrica.isOpen()) {
                fabrica.close();
            }
        }
    }
}