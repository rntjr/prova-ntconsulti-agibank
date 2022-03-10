import java.math.BigDecimal;

public class Vendedor {
    private String cpf;
    private String nome;
    private BigDecimal salario;
    private Double valorTotalVendas = Double.valueOf(0);

    @Override
    public String toString() {
        return "Vendedor: {" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", valorTotalVendas=" + valorTotalVendas +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Double getValorTotalVendas() {
        return valorTotalVendas;
    }

    public void setValorTotalVendas(BigDecimal valorTotalVendas) {
        this.valorTotalVendas += valorTotalVendas.doubleValue();
    }
}
