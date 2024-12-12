package org.example.dam2hibernate.Practica2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    private static SessionFactory factory;

    public static void main(String[] args) {
        factory = new Configuration().configure().buildSessionFactory();

        try {
            // CREATE
            Producto producto = new Producto();
            producto.setNombre("Laptop");
            producto.setPrecio(1500.00);
            producto.setCantidad(10);
            createProducto(producto);

            // READ
            List<Producto> productos = getProductos();
            productos.forEach(System.out::println);

            // UPDATE
            updateProducto(1, 1800.00);

            // DELETE
            deleteProducto(1);

        } finally {
            factory.close();
        }
    }

    public static void createProducto(Producto producto) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(producto);
        session.getTransaction().commit();
        session.close();
        System.out.println("Producto creado: " + producto);
    }

    public static List<Producto> getProductos() {
        Session session = factory.openSession();
        List<Producto> productos = session.createQuery("from Producto", Producto.class).list();
        session.close();
        return productos;
    }

    public static void updateProducto(int id, double nuevoPrecio) {
        Session session = factory.openSession();
        session.beginTransaction();
        Producto producto = session.get(Producto.class, id);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            session.update(producto);
            System.out.println("Producto actualizado: " + producto);
        }
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteProducto(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Producto producto = session.get(Producto.class, id);
        if (producto != null) {
            session.delete(producto);
            System.out.println("Producto eliminado: " + producto);
        }
        session.getTransaction().commit();
        session.close();
    }
}
