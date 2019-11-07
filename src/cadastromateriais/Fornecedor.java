package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fornecedor {
    private int codFornecedor;
    private String nomeFornecedor;
    private String telefoneFornecedor;

    public Fornecedor(int codFornecedor, String nomeFornecedor, String telefoneFornecedor) {
        this.codFornecedor = codFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.telefoneFornecedor = telefoneFornecedor;
    }
    public Fornecedor() throws IOException {
        this.buscaRegistro(1);
    }

    public String getTelefoneFornecedor() {
        return telefoneFornecedor;
    }

    public void setTelefoneFornecedor(String telefoneFornecedor) {
        this.telefoneFornecedor = telefoneFornecedor;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public void buscaRegistro(int busca) throws FileNotFoundException, IOException{
        int indice,indice2;
        this.nomeFornecedor="Item nãoo encontrado";
        this.telefoneFornecedor="Item nãoo encontrado";
        boolean achei=false;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\fornecedores.txt")) {
            BufferedReader lerArq = new BufferedReader(arq2);
            
            String linha = lerArq.readLine(); // lÃª a primeira linha
            
            while (linha != null && !achei) {
                
                indice=linha.indexOf(";", 0);
                this.codFornecedor=Integer.parseInt(linha.substring(0, indice));
                if (this.codFornecedor==busca){
                    achei=true;
                    indice2=linha.indexOf(";", indice+1);
                    this.nomeFornecedor=linha.substring(indice+1,indice2);
                    this.telefoneFornecedor=linha.substring(indice2+1);
                }
                linha = lerArq.readLine();
            }
        }
        if (!achei){
            this.codFornecedor=0;
        }
    }
    public int UltimoCodigo() throws FileNotFoundException, IOException
    {      
        int maior, codigo, indice;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\fornecedores.txt"))
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
        System.out.println("Digite o nome do fornecedor que deseja incluir:");
        this.setNomeFornecedor(input.nextLine());
        System.out.println("Digite o telefone do fornecedor que deseja incluir:");
        this.setTelefoneFornecedor(input.nextLine());
        this.setCodFornecedor(this.UltimoCodigo());
        try (FileWriter arq = new FileWriter("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\fornecedores.txt", novo)) {
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(this.getCodFornecedor()+";"+this.getNomeFornecedor()+";"+this.getTelefoneFornecedor()+"\n");
        }
        
    }
    public String listaFonecedores() throws FileNotFoundException, IOException{
        String[] array=new String[10];
        String retorno="---------------------------\ncodigo -  Nome Fornecedor\n";
        int tamanho=0;
        try (FileReader arq2 = new FileReader("D:\\Eric\\Documentos\\Unesc\\4 Semestre\\POO\\CadastroMateriais\\fornecedores.txt"))
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
    public String mostraRegistro(){
         String retorno;
         if (this.getCodFornecedor()==0){
             retorno="fornecedor não foi encontrado encontrado.\n";
         }
         else{
            retorno=("O fornecedor foi encontrado!\n");
            retorno+="---------------------------\nCODIGO  - NOME FORNECEDOR                   - TELEFONE FORNECEDOR\n";
            retorno+=CadastroMateriais.entraEspacos(Integer.toString(this.getCodFornecedor()), 7)+" - ";
            retorno+=CadastroMateriais.entraEspacos(this.getNomeFornecedor(), 33)+" - ";
            retorno+=CadastroMateriais.entraEspacos(this.getTelefoneFornecedor(), 20)+"\n";
         }
         return retorno;
     }

}
