package br.edu.ifsul.condominiomodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jakelyny Sousa
 */
@Entity
@Table(name="aluguel")
public class Aluguel implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name="valor", nullable = false)
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de inicio do contrato deve ser informada")	
    @Column(name = "inicioContrato", nullable = false)
    private Calendar inicioContrato;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de fim do contrato deve ser informada")	
    @Column(name = "fimContrato", nullable = false)
    private Calendar fimContrato;
    
    @NotNull(message = "o dia de vencimento deve ser informado")
    @Column(name="diaVencimento", nullable = false)
    private Integer diaVencimento;
    
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidades> mensalidades = new ArrayList<>();
    
    @NotNull(message = "O locatario deve ser informado")
    @ManyToOne
    @JoinColumn(name="locatario", referencedColumnName = "id", nullable = false)
    private Locatario locatario;
    
    @NotNull(message = "A Unidade Condominal deve ser informado")
    @ManyToOne
    @JoinColumn(name="unidadeCondominal", referencedColumnName = "id", nullable = false)
    private UnidadeCondominal unidadeCondominal;

    public void adicionarMensalidade(Mensalidades mensalidades){
        mensalidades.setAluguel(this);
        this.getMensalidades().add(mensalidades);
    }
    
    public void removerMensalidade(int index){
        this.mensalidades.remove(index);
    }
  
    
    public Aluguel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public List<Mensalidades> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidades> mensalidades) {
        this.mensalidades = mensalidades;
    }
    
    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public UnidadeCondominal getUnidadeCondominal() {
        return unidadeCondominal;
    }

    public void setUnidadeCondominal(UnidadeCondominal unidadeCondominal) {
        this.unidadeCondominal = unidadeCondominal;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        return Objects.equals(this.id, other.id);
    }

}
