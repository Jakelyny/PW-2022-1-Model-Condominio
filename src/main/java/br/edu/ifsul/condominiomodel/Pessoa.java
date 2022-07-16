package br.edu.ifsul.condominiomodel;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jakelyny Sousa
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="pessoa")
public class Pessoa implements Serializable{
    @Id
    @NotBlank(message = "O cpf precisa ser preenchido")
    @Length(max=11, message = "O cpf não pode ter mais que {max} caracteres")
    @Column(name="cpf", nullable = false, length = 11)
    private String cpf;
    
    @NotBlank(message = "O nome precisa ser preenchido")
    @Length(max=40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name="nome", nullable = false, length = 40)
    private String nome;
    
    @NotBlank(message = "O telefone precisa ser preenchido")
    @Length(max=13, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name="telefone", nullable = false, length = 13)
    private String telefone;
    
    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")    
    @Column(name = "senha", length = 20, nullable = false)    
    private String senha;
    
    @NotBlank(message = "O email precisa ser preenchido")
    @Length(max=40, message = "O email não pode ter mais que {max} caracteres")
    @Column(name="email", nullable = false, length = 40)
    @Email
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permissoes", 
            joinColumns = 
                    @JoinColumn(name = "cpf", referencedColumnName = "cpf", 
                            nullable = false), 
            inverseJoinColumns = 
                    @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false))
    private Set<Permissao> permissoes = new HashSet<>();

    public Pessoa() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.cpf);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    } 
}
