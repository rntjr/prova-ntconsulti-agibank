public enum CodigoLinha {
    VENDEDOR("001"), CLIENTE("002"), VENDA("003");

    private String codigoLinha;

    CodigoLinha(String i) {
        codigoLinha = i;
    }

    public String getCodigoLinha() {
        return codigoLinha;
    }
}
