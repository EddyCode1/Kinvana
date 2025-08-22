package org.jrae.kinvana.peristence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Clientes")
//lombok
@Data // genera los setters y getters
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode //codigo de autenticacion de ña entidad


public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCliente; // permite usar null en vez de 0 el Integer
    @Column
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String genero;
    private Integer edad;


}
