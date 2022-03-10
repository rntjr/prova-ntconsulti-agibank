import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

public class Arquivo {
    private String caminhoArquivo;

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public void gerarArquivo(String pastaPadraoOut, ArrayList<Vendedor> vendedores, ArrayList<Cliente> clientes, ArrayList<Venda> vendas) throws IOException {

        StringBuilder texto = new StringBuilder();
        texto.append("Quantidade de clientes no arquivo de entrada: ").append(clientes.size()).append("\n");
        texto.append("Quantidade de vendedor no arquivo de entrada: ").append(vendedores.size()).append("\n");
        texto.append("ID da venda mais cara: ").append(vendas.stream().sorted((venda1, venda2) -> venda2.getValorTotalVenda().compareTo(venda1.getValorTotalVenda())).collect(Collectors.toList()).get(0).getId()).append("\n");
        texto.append("O pior vendedor: ").append(vendedores.stream().sorted(Comparator.comparing(Vendedor::getValorTotalVendas)).collect(Collectors.toList()).get(0).getNome()).append("\n");

        System.out.println(texto);

        String nomeArquivo = gerarNomeArquivo(pastaPadraoOut);
        DataOutputStream arquivoOut = new DataOutputStream(new FileOutputStream(nomeArquivo));
        arquivoOut.writeChars(texto.toString());
        arquivoOut.close();
    }

    private static String gerarNomeArquivo(String pastaPadraoOut) {
        String arquivo = "arquivo";
        String extensao = ".done.dat";
        pastaPadraoOut = pastaPadraoOut + "\\";
        String nomeArquivo = arquivo + extensao;
        String caminhoCompletoArquivo = pastaPadraoOut + nomeArquivo;

        File file = new File(pastaPadraoOut);

        String[] listaArquivos = file.list();

        if (listaArquivos != null) {
            for (int i = 0; i < Arrays.asList(listaArquivos).size(); i++) {
                if (!listaArquivos[i].equals(nomeArquivo)) {
                    caminhoCompletoArquivo = pastaPadraoOut + arquivo + i + extensao;
                }
            }
        }

        return caminhoCompletoArquivo;

    }

    public void lerArquivo(ArrayList<Vendedor> vendedores, ArrayList<Cliente> clientes, ArrayList<Venda> vendas) throws IOException {
        BufferedReader arquivoIn = new BufferedReader(new FileReader(caminhoArquivo));
        inserirDados(arquivoIn, vendedores, clientes, vendas);
    }

    protected void inserirDados(BufferedReader arquivoIn, ArrayList<Vendedor> vendedores, ArrayList<Cliente> clientes, ArrayList<Venda> vendas) throws IOException {
        String linhaArquivo = "";

        while (true) {
            linhaArquivo = arquivoIn.readLine();

            if (linhaArquivo == null) break;

            String[] dadosLinha = linhaArquivo.split("ç");

            // Lista vendedores
            if (CodigoLinha.VENDEDOR.getCodigoLinha().equals(dadosLinha[0])) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCpf(dadosLinha[1]);
                vendedor.setNome(dadosLinha[2]);
                vendedor.setSalario(new BigDecimal(dadosLinha[3]));
                vendedores.add(vendedor);
            } else if (CodigoLinha.CLIENTE.getCodigoLinha().equals(dadosLinha[0])) {
                Cliente cliente = new Cliente();
                cliente.setCnpj(dadosLinha[1]);
                cliente.setNome(dadosLinha[2]);
                cliente.setAreaNegocio(dadosLinha[3]);
                clientes.add(cliente);
            } else if (CodigoLinha.VENDA.getCodigoLinha().equals(dadosLinha[0])) {
                Venda venda = new Venda();
                venda.setId(Long.parseLong(dadosLinha[1]));
                venda.setVendedor(vendedores.stream()
                        .filter(vendedor -> dadosLinha[3].equals(vendedor.getNome()))
                        .findAny()
                        .orElse(new Vendedor()));
                venda.setProduto(dadosLinha[2]);
                venda.getVendedor().setValorTotalVendas(venda.getValorTotalVenda());
                vendas.add(venda);
            }
        }
        arquivoIn.close();
    }
}

