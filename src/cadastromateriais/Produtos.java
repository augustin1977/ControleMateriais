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
                    this.preco=Float.parseFloat(array[2].replaceAll(",", "."));
                    this.codCategoria=Integer.parseInt(array[3]);
                    this.codFornecedor=Integer.parseInt(array[4]);
                    
                }
                linha = lerArq.readLine();
            }
        }
        if (!achei){
            this.codProduto=0;
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
        Categorias c1=new Categorias();
        Fornecedor f1=new Fornecedor();
        Scanner input = new Scanner(System.in);
        System.out.println("CADASTRO DE PRODUTOS!\nDigite a descrição do produto que deseja incluir:");
        this.setdescricao(input.nextLine());
        System.out.println("Digite o preço produto que deseja incluir:");
        leitura=input.nextLine();
        this.setPreco(Float.parseFloat(leitura));
         System.out.println(this.getPreco());
        System.out.println("Digite a categoria do produto que deseja incluir:");
         System.out.println(c1.listaCategorias());
         System.out.print(":");
        //seria interessante listar todas as categorias para facilitar o usuário;
        leitura=input.nextLine();
        this.setCodCategoria(Integer.parseInt(leitura));
        System.out.println("Digite codigo do fornecedor do produto que deseja incluir:");
        //seria interessante listar todas os fornecedores para facilitar o usuário;
        System.out.println(f1.listaFonecedores());
        System.out.print(":");
        leitura=input.nextLine();
        this.setCodFornecedor(Integer.parseInt(leitura));
        this.setCodProduto(this.UltimoCodigo());
        try (FileWriter arq = new FileWriter("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt", novo)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf("%d;%s;%.2f;%d;%d\n",this.getCodProduto(),this.getdescricao(),this.getPreco(),this.getCodCategoria(),this.getCodFornecedor());
        }
     }
     public String listaProdutos() throws FileNotFoundException, IOException{
        String[] array=new String[10];
        String retorno="---------------------------\nCODIGO -  DESCRIÇÃO PRODUTO\n";
        int tamanho=0;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt"))
        {
            BufferedReader lerArq = new BufferedReader(arq2);            
            String linha = lerArq.readLine(); 
            while (linha != null) { 
                tamanho++;
                array = linha.split(";");
                if (tamanho<10){
                    retorno+=array[0]+"      -  "+array[1]+"\n";
                }
                else if (tamanho<100){
                    retorno+=array[0]+"     -  "+array[1]+"\n";
                }
                else if (tamanho<1000){
                    retorno+=array[0]+"    -  "+array[1]+"\n";
                }
                else if (tamanho<10000){
                    retorno+=array[0]+"    -  "+array[1]+"\n";
                }
                linha = lerArq.readLine();
            }
        }
        retorno+="------------------------------------------------------------\n";
        return retorno;
    }
     public String relatorioMateriais() throws IOException{
        String[] array=new String[10];
        int codFornecedor,codCategoria;
        String retorno="---------------------------\nCODIGO  - DESCRIÇÃO PRODUTO                   - PREÇO     - CATEGORIA MATERIAL         - NOME FORNECEDOR\n";
        Categorias categoria=new Categorias();
        Fornecedor fornecedor=new Fornecedor();
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\Produtos.txt"))
        {
            BufferedReader lerArq = new BufferedReader(arq2);            
            String linha = lerArq.readLine(); 
            while (linha != null) { 
                array = linha.split(";");
                codFornecedor=Integer.parseInt(array[4]);
                codCategoria= Integer.parseInt(array[3]);
                fornecedor.buscaRegistro(codFornecedor);
                categoria.buscaRegistro(codCategoria);
                array[3]=categoria.getnomeCategoria();
                array[4]=fornecedor.getNomeFornecedor();
                retorno+=CadastroMateriais.entraEspacos(array[0], 7)+" - ";
                retorno+=CadastroMateriais.entraEspacos(array[1], 35)+" - ";
                retorno+=CadastroMateriais.entraEspacos("R$"+array[2], 9)+" - ";
                retorno+=CadastroMateriais.entraEspacos(array[3], 26)+" - ";
                retorno+=CadastroMateriais.entraEspacos(array[4], 20)+"\n";
                linha = lerArq.readLine();
            }
        }
        retorno+="------------------------------------------------------------\n";
        return retorno;
     }
     public String mostraRegistro(){
         String retorno;
         if (this.codProduto==0){
             retorno="Produto não foi encontrado encontrado.\n";
         }
         else{
            retorno=("O produto foi encontrado!\n");
            retorno+="---------------------------\nCODIGO  - DESCRIÇÃO PRODUTO                   - PREÇO     - CODIGO CATEGORIA    - CODIGO FORNECEDOR\n";
            retorno+=CadastroMateriais.entraEspacos(Integer.toString(this.getCodProduto()), 7)+" - ";
            retorno+=CadastroMateriais.entraEspacos(this.getdescricao(), 35)+" - ";
            retorno+=CadastroMateriais.entraEspacos(String.format("R$%.2f",this.getPreco()), 9)+" - ";
            retorno+=CadastroMateriais.entraEspacos(Integer.toString(this.getCodCategoria()), 19)+" - ";
            retorno+=CadastroMateriais.entraEspacos(Integer.toString(this.getCodFornecedor()), 10)+"\n";
         }
         return retorno;
     }
   

}
