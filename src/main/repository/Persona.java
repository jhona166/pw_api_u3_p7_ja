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
@Table(name = "persona")

 
   
public class Persona {
 
    @Id
    @Column(name = "pers_id")
    @SequenceGenerator(name = "persona_seq" , sequenceName = "persona_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    private Integer id;
    @Column(name = "pers_nombre")
    private String nombre;
    @Column(name = "pers_apellido")
    private String apellido;
    @Column(name = "pers_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;
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
 
 
   
}