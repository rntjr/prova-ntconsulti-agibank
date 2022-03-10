import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File pastaPadraoIn = new File("C:\\data\\in");
        File pastaPadraoOut = new File("C:\\data\\out");
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();
        Arquivo file = new Arquivo();

        for (String arquivo: pastaPadraoIn.list()){
            if (arquivo.contains(".dat")) {
                file.setCaminhoArquivo(pastaPadraoIn + "\\" + arquivo);
                file.lerArquivo(vendedores,clientes,vendas);
            }
        }

        file.gerarArquivo(pastaPadraoOut.toString(),vendedores,clientes,vendas);
    }
}