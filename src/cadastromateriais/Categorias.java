package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class Categorias {
    private int cod_categoria;
    private String nome_categoria;
    

    public Categorias(int cod_categoria, String nome_categoria) {
        this.cod_categoria = cod_categoria;
        this.nome_categoria = nome_categoria;
    }
    public Categorias() throws IOException{
        this.buscaRegistro(0);
    }

    public String getnomeCategoria() {
        return nome_categoria;
    }

    public void setnomeCategoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public int getcodCategoria() {
        return cod_categoria;
    }

    public void setcodCategoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }
    
    public void buscaRegistro(int busca) throws FileNotFoundException, IOException{
        int indice,codigo;
        this.nome_categoria="Item não encontrado";
        this.cod_categoria=0;
        boolean achei=false;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\categorias.txt")) {
            BufferedReader lerArq = new BufferedReader(arq2);
            
            String linha = lerArq.readLine(); // lê a primeira linha
            
            while (linha != null && !achei) {
                
                indice=linha.indexOf(";", 0);
                this.cod_categoria=Integer.parseInt(linha.substring(0, indice));
                if (this.cod_categoria==busca){
                    achei=true;
                    this.nome_categoria=linha.substring(indice+1);
                }
                linha = lerArq.readLine();
            }
        }
    }
    
    public int UltimoCodigo() throws FileNotFoundException, IOException
    {      
        int maior, codigo, indice;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\categorias.txt"))
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
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome da categoria que deseja incluir:");
        this.setnomeCategoria(input.nextLine());
        this.setcodCategoria(this.UltimoCodigo());
        try (FileWriter arq = new FileWriter("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\categorias.txt", novo)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(this.cod_categoria+";"+this.nome_categoria+"\n");
        }
        
    }
    public String listaCategorias() throws FileNotFoundException, IOException{
        String[] array=new String[10];
        String retorno="---------------------------\ncodigo -  Nome Categoria\n";
        int tamanho=0;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\categorias.txt"))
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
        retorno+="---------------------------\n";
        return retorno;
    }

}
