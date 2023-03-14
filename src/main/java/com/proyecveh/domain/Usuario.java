package com.proyecveh.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario; 
    String nombre;
    String primApellido;
    String user;
    String password;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String primApellido, String user, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.primApellido = primApellido;
        this.user = user;
        this.password = password;
    }
    
}
