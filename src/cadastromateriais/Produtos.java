package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Produtos {
    private int codProduto;
    private String descricao;
    private float preco;
    private int codCategoria;
    private int codFornecedor;

    public Produtos() {
        
    }
    
    public Produtos(int codProduto, String descricao, float preco, int codCategoria, int codFornecedor) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.codCategoria = codCategoria;
        this.codFornecedor = codFornecedor;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }
    

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public void buscaRegistro(int busca) throws FileNotFoundException, IOException{
        String[] array=new String[10];
        this.descricao="Item não encontrado";
        this.preco=0.0f;
        this.codCategoria=0;
        boolean achei=false;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt")) {
            BufferedReader lerArq = new BufferedReader(arq2);
            
            String linha = lerArq.readLine(); // lê a primeira linha
            while (linha != null && !achei) {
                array = linha.split(";");
                this.codProduto=Integer.parseInt(array[0]);
                if (this.codProduto==busca){
                    achei=true;
                    this.descricao=array[1];
                    this.preco=Float.parseFloat(array[2]);
                    this.codCategoria=Integer.parseInt(array[3]);
                    this.codFornecedor=Integer.parseInt(array[4]);
                    
                }
                linha = lerArq.readLine();
            }
        }
    }
    public int UltimoCodigo() throws FileNotFoundException, IOException
    {      
        int maior, codigo, indice;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt"))
        {
            BufferedReader lerArq = new BufferedReader(arq2);            
            String linha = lerArq.readLine(); 
            indice = linha.indexOf(";", 0);
            maior = Integer.parseInt(linha.substring(0,indice)); //DECLARA COMO O MAIOR, O PRIMEIRO CÓDIGO LIDO
            while (linha != null) {    
                indice = linha.indexOf(";", 0);
                codigo = Integer.parseInt(linha.substring(0,indice));
                System.out.println("Percorrendo Codigo: "+codigo+" "+maior);
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
        System.out.println("Digite a descrição do produto que deseja incluir que deseja incluir:");
        this.setdescricao(input.nextLine());
        System.out.println("Digite o preço produto que deseja incluir:");
        leitura=input.nextLine();
        this.setPreco(Float.parseFloat(leitura));
        System.out.println("Digite a categoria do produto que deseja incluir:");
        //seria interessante listar todas as categorias para facilitar o usuário;
        leitura=input.nextLine();
        this.setPreco(Integer.parseInt(leitura));
        System.out.println("Digite codigo do fornecedor do produto que deseja incluir:");
        //seria interessante listar todas os fornecedores para facilitar o usuário;
        leitura=input.nextLine();
        this.setCodFornecedor(Integer.parseInt(leitura));
        
        this.setCodProduto(this.UltimoCodigo());
        try (FileWriter arq = new FileWriter("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt", novo)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(this.getCodProduto()+";"+this.getdescricao()+";"+this.getPreco()+";"+this.getCodCategoria()+";"+this.getCodFornecedor()+"\n");
        }
     }

}
