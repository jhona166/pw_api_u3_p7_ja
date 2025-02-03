package uce.edu.web.api.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
    @Id  
    @GeneratedValue(generator = "seq_estudiante",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq_estudiante",sequenceName ="seq_estudiante", allocationSize = 1)
    @Column(name="est_id")
    private Integer id;
    @Column(name="est_nombre")
    private String nombre;
    @Column(name="est_apellido")
    private String apellido;
    @Column(name="est_fechaNacimiento")
    private LocalDateTime fechaNacimiento;
    @Column(name="est_genero")
    private String genero;
    

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, String apellido, LocalDateTime fechaNacimiento, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }



    //SET AND GET
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    


}
