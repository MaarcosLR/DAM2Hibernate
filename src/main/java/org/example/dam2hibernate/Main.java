package org.example.dam2hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Configuración de Hibernate
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();

            // Crear nuevo socio
            Socio nuevoSocio = new Socio();
            nuevoSocio.setNumeroSocio(10);
            nuevoSocio.setNombreSocio("Juan Pérez");

            // Convertir String a LocalDate
            String fechaString = "2024-01-01";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaAlta = LocalDate.parse(fechaString, formatter);

            // Establecer la fecha en el objeto Socio
            nuevoSocio.setFechaAlta(fechaAlta);

            // Guardar en la base de datos
            session.save(nuevoSocio);

            // Confirmar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback(); // Revertir en caso de error
        } finally {
            session.close();
            factory.close();
        }
    }
}