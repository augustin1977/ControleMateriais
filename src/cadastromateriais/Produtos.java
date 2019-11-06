package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    
    

}
