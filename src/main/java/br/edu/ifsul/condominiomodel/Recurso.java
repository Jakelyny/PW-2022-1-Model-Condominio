package br.edu.ifsul.condominiomodel;

import java.util.List;
import java.util.Objects;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jakelyny Sousa
 */

@Entity
@Table(name="recurso")
public class Recurso implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O descricao precisa ser preenchido")
    @Length(max=40, message = "O descricao não pode ter mais que {max} caracteres")
    @Column(name="descricao", nullable = false, length = 40)
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "recurso_condominio",
            joinColumns = 
                    @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name= "condominio", referencedColumnName = "id", nullable = false)
            )
    private List<Condominio> condominios = new ArrayList<>();

    public Recurso() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Condominio> getCondominios() {
        return condominios;
    }

    public void setCondominios(List<Condominio> condominios) {
        this.condominios = condominios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
        return Objects.equals(this.id, other.id);
    }   
}
