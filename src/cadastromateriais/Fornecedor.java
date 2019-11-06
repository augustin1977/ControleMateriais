package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    }
    

}
