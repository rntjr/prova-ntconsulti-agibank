import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Long id;
    private Vendedor vendedor;
    private List<Produto> produto;
    private BigDecimal valorTotalVenda = BigDecimal.ZERO;

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valorTotalVenda=" + valorTotalVenda +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(String entrada) {
        List<Produto> produtos = new ArrayList<>();

        StringBuilder texto = new StringBuilder(entrada);

        texto.deleteCharAt(entrada.length() - 1);
        texto.deleteCharAt(0);

        String[] produtoLista = texto.toString().split(",");

        for (String produtoItem: produtoLista){
            String[] atributo = produtoItem.split("-");

            Produto produto = new Produto();
            produto.setId(Long.parseLong(atributo[0]));
            produto.setQuantidade(Integer.parseInt(atributo[1]));
            produto.setValor(new BigDecimal(atributo[2]));

            produtos.add(produto);
        }

        this.produto = produtos;
    }

    public BigDecimal getValorTotalVenda() {
        return this.valorTotalVenda = this.produto.stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
