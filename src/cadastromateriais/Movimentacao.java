package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Movimentacao {
    private int codigoMovimentacao;
    private int tipoMovimentacao;
    private int quantidadeMovimentacao;
    private int codProduto;

    public Movimentacao(int codigoMovimentacao, int tipoMovimentacao, int quantidadeMovimentacao, int codProduto) {
        this.codigoMovimentacao = codigoMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidadeMovimentacao = quantidadeMovimentacao;
        this.codProduto = codProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodigoMovimentacao() {
        return codigoMovimentacao;
    }

    public void setCodigoMovimentacao(int codigoMovimentacao) {
        this.codigoMovimentacao = codigoMovimentacao;
    }

    public int getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(int tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public int getQuantidadeMovimentacao() {
        return quantidadeMovimentacao;
    }

    public void setQuantidadeMovimentacao(int quantidadeMovimentacao) {
        this.quantidadeMovimentacao = quantidadeMovimentacao;
    }
       public void buscaRegistro(int busca) throws FileNotFoundException, IOException{
        String[] array=new String[10];
        this.codigoMovimentacao=0;
        this.tipoMovimentacao=0;
        this.quantidadeMovimentacao=0;
        this.codProduto=0;
        boolean achei=false;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt")) {
            BufferedReader lerArq = new BufferedReader(arq2);
            
            String linha = lerArq.readLine(); // lê a primeira linha
            while (linha != null && !achei) {
                array = linha.split(";");
                this.codigoMovimentacao=Integer.parseInt(array[0]);
                if (this.codigoMovimentacao==busca){
                    achei=true;
                    this.tipoMovimentacao=Integer.parseInt(array[1]);
                    this.tipoMovimentacao=Integer.parseInt(array[2]);
                    this.quantidadeMovimentacao=Integer.parseInt(array[3]);
                    this.codProduto=Integer.parseInt(array[4]);
                    
                }
                linha = lerArq.readLine();
            }
        }
    }
    
}
