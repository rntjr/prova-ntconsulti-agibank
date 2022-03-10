public class Cliente {
    private String cnpj;
    private String nome;
    private String areaNegocio;

    @Override
    public String toString() {
        return "Cliente: {" +
                "cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", areaNegocio='" + areaNegocio + '\'' +
                '}';
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaNegocio() {
        return areaNegocio;
    }

    public void setAreaNegocio(String areaNegocio) {
        this.areaNegocio = areaNegocio;
    }
}
