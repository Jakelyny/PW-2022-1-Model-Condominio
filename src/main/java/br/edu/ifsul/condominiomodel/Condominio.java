package br.edu.ifsul.condominiomodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jakelyny Sousa
 */
@Entity
@Table(name="condominio")
public class Condominio implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome precisa ser preenchido")
    @Length(max=40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name="nome", nullable = false, length = 40)
    private String nome;
    
    @NotBlank(message = "O endereco precisa ser preenchido")
    @Length(max=80, message = "O endereco não pode ter mais que {max} caracteres")
    @Column(name="endereco", nullable = false, length = 80)
    private String endereco;
    
    @NotBlank(message = "O numero precisa ser preenchido")
    @Length(max=6, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name="numero", nullable = false, length = 6)
    private String numero;
    
    @NotBlank(message = "O cep precisa ser preenchido")
    @Length(max=8, message = "O cep não pode ter mais que {max} caracteres")
    @Column(name="cep", nullable = false, length = 8)
    private String cep;
    
    @ManyToMany
    @JoinTable(name = "condominio_recurso",
            joinColumns = 
                    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name= "recurso", referencedColumnName = "id", nullable = false)
            )
    private List<UnidadeCondominal> recursos = new ArrayList<>();
    
    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UnidadeCondominal> unidadeCondominal = new ArrayList<>();

    public Condominio() {
    }

    public void adicionarUnidadeCondominal(UnidadeCondominal obj){
        obj.setCondominio(this);
        this.unidadeCondominal.add(obj);
    }
    
    public void removerUnidadeCondominal(int index){
        this.unidadeCondominal.remove(index);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<UnidadeCondominal> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<UnidadeCondominal> recursos) {
        this.recursos = recursos;
    }

    public List<UnidadeCondominal> getUnidadeCondominal() {
        return unidadeCondominal;
    }

    public void setUnidadeCondominal(List<UnidadeCondominal> unidadeCondominal) {
        this.unidadeCondominal = unidadeCondominal;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Condominio other = (Condominio) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
