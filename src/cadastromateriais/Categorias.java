package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

}
