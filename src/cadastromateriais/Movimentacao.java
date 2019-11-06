package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
    public Movimentacao() throws IOException {
        this.buscaRegistro(0);
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
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\movimentacao.txt")) {
            BufferedReader lerArq = new BufferedReader(arq2);
            
            String linha = lerArq.readLine(); // lê a primeira linha
            while (linha != null && !achei) {
                array = linha.split(";");
                this.codigoMovimentacao=Integer.parseInt(array[0]);
                if (this.codigoMovimentacao==busca){
                    achei=true;
                    this.tipoMovimentacao=Integer.parseInt(array[1]);
                    this.quantidadeMovimentacao=Integer.parseInt(array[2]);
                    this.codProduto=Integer.parseInt(array[3]);
                    
                }
                linha = lerArq.readLine();
            }
        }
    }
       int UltimoCodigo() throws FileNotFoundException, IOException
    {      
        int maior, codigo, indice;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\movimentacao.txt"))
        {
            BufferedReader lerArq = new BufferedReader(arq2);            
            String linha = lerArq.readLine(); 
            indice = linha.indexOf(";", 0);
            maior = Integer.parseInt(linha.substring(0,indice)); //DECLARA COMO O MAIOR, O PRIMEIRO CÓDIGO LIDO
            while (linha != null) { 
                indice = linha.indexOf(";", 0);
                codigo = Integer.parseInt(linha.substring(0,indice));
                if (codigo > maior){ //TESTA SE O CODIGO LIDO ATUALMENTE É MAIOR QUE O LIDO ANTERIORMENTE
                    maior = codigo;
                }
                linha = lerArq.readLine();
            }
            return (maior+1); //RETORNA O PROXIMO CÓDIGO A SER INSERIDO
        }
    }
    public void incluiRegistro(boolean novo) throws IOException{
        String leitura;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o tipo de movimentação (1=entrada / 2=saida):");
        leitura=input.nextLine();
        this.setTipoMovimentacao(Integer.parseInt(leitura));
        System.out.println("Digite o codigo do Produto produto que deseja incluir:");
        //listar produtos para facilitar para o usário
        leitura=input.nextLine();
        this.setCodProduto(Integer.parseInt(leitura));
        System.out.println("Digite a quantidade movimentada:");
        //se for uma saida, seria interessante informar o stoque disponivel para evitar saidas maiores que o estoque
        leitura=input.nextLine();
        this.setQuantidadeMovimentacao(Integer.parseInt(leitura));
        this.setCodigoMovimentacao(this.UltimoCodigo());
        try (FileWriter arq = new FileWriter("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\movimentacao.txt", novo)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(this.getCodigoMovimentacao()+";"+this.getTipoMovimentacao()+";"+this.quantidadeMovimentacao+";"+this.codProduto+"\n");
        }
     }
}
