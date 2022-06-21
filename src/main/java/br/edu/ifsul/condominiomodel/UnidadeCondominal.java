package br.edu.ifsul.condominiomodel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Jakelyny Sousa
 */
@Entity
@Table(name="unidade_condominal")
public class UnidadeCondominal implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_unidade_condominal", sequenceName = "seq_unidade_condominal_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidade_condominal", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O numero precisa ser preenchido")
    @Length(max=10, message = "O numero não pode ter mais que {max} caracteres")
    @Column(name="numero", nullable = false, length = 10)
    private String numero;
    
    @NotBlank(message = "A descricao precisa ser preenchida")
    @Column(name="descricao",columnDefinition = "TEXT")
    private String descricao;
    
    @NotNull(message = "A area deve ser informado")
    @Column(name="area", nullable = false)
    private Double area;
    
    @NotNull(message = "O numero do quarto deve ser informado")
    @Column(name="numeroQuarto", nullable = false)
    private Integer numeroQuarto;

    @NotNull(message = "O proprietario deve ser informado")
    @ManyToOne
    @JoinColumn(name="proprietario", referencedColumnName = "id", nullable = false)
    private Pessoa proprietario;
    
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name="condominio", referencedColumnName = "id", nullable = false)
    private Condominio condominio;
    
    public UnidadeCondominal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominal other = (UnidadeCondominal) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
