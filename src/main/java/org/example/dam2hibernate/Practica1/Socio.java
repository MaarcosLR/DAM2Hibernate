package org.example.dam2hibernate.Practica1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "Socio") // Mapea la clase con la tabla Socio
public class Socio {

    @Id
    @Column(name = "numero_socio") // Mapea el campo con la columna numero_socio
    private int numeroSocio;

    @Column(name = "nombre_socio", nullable = false, length = 100) // Mapea el campo con la columna nombre_socio y establece restricciones
    private String nombreSocio;

    @Column(name = "fecha_alta", nullable = false) // Mapea el campo con la columna fecha_alta
    private LocalDate fechaAlta; // Cambiamos a LocalDate para trabajar mejor con fechas

    // Getters y Setters

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
