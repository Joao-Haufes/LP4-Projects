package lp4_av1;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="Clientes")
@SequenceGenerator(name = "seqc", sequenceName = "Clientesequencia", allocationSize = 1, initialValue = 1)
public class Cliente {

    @Id
    @GeneratedValue(generator = "seqc")
    private Long sequenciaid;

    @Column
    private String nome;
    @Column
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;

    public Cliente() {
        super();
    }

    public Long getSequenciaId() {
        return sequenciaid;
    }

    public void setSequenciaId(Long sequenciaid) {
        this.sequenciaid = sequenciaid;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
