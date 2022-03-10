import java.math.BigDecimal;

public class Produto {
    private Long id;
    private int quantidade;
    private BigDecimal valor;

    @Override
    public String toString() {
        return "Produto: {" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
