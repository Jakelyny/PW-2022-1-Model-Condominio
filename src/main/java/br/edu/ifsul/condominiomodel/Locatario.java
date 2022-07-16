package br.edu.ifsul.condominiomodel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jakelyny Sousa
 */

@Entity
@Table(name="locatario")
public class Locatario extends Pessoa implements Serializable {
    
    @NotNull(message = "A renda deve ser informado")
    @Column(name = "renda", nullable = false, columnDefinition = "numeric(8,2)")
    private Double renda;
    
    @NotBlank(message = "O local do Trabalho precisa ser preenchido")
    @Length(max=40, message = "O local do Trabalho não pode ter mais que {max} caracteres")
    @Column(name="localTrabalho", nullable = false, length = 40)
    private String localTrabalho;
    
    @NotBlank(message = "O telefone do Trabalho precisa ser preenchido")
    @Length(max=13, message = "O telefone do Trabalho não pode ter mais que {max} caracteres")
    @Column(name="telefoneTrabalho", nullable = false, length = 13)
    private String telefoneTrabalho;

    public Locatario() {
        
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.renda);
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
        final Locatario other = (Locatario) obj;
        return Objects.equals(this.renda, other.renda);
    }  
}
