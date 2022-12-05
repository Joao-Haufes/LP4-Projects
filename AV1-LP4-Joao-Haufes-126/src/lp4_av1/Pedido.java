package lp4_av1;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Pedidos")
@SequenceGenerator(name = "seqp", sequenceName = "Pedidosequencia", allocationSize = 1, initialValue = 1)
public class Pedido {

    @Id
    @GeneratedValue(generator = "seqp")
    private Long sequenceid;

    @Column
    private Date data;
    @Column
    private String status;
    @Column
    private double valor;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public Pedido() {
        super();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getSequenceId() {
        return sequenceid;
    }

    public void setSequenceId(Long sequenceid) {
        this.sequenceid = sequenceid;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
