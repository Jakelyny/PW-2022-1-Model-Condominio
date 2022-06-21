package br.edu.ifsul.condominiomodel;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jakelyny Sousa
 */
@Entity
@Table(name="mensalidades")
public class Mensalidades implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name="valor", nullable = false)
    private Double valor;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de vencimento do contrato deve ser informada")	
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;
    
    @NotNull(message = "O valor de pagamento deve ser informado")
    @Column(name="valorPagamento", nullable = false)
    private Double valorPagamento;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPagamento", nullable = true)
    private Calendar dataPagamento;

    @NotNull(message = "O aluguel deve ser informado")
    @ManyToOne
    @JoinColumn(name="aluguel", referencedColumnName = "id", nullable = false)
    private Aluguel aluguel;

    public Mensalidades() {
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

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Mensalidades other = (Mensalidades) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
