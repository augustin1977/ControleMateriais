package cadastromateriais;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Categorias {
    private int cod_categoria;
    private String nome_categoria;
    

    public Categorias(int cod_categoria, String nome_categoria) {
        this.cod_categoria = cod_categoria;
        this.nome_categoria = nome_categoria;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }
    
    public String buscaRegistro(int busca) throws FileNotFoundException, IOException{
        int indice,codigo;
        String retorno="Codigo não encontrado";
        boolean achei=false;
        FileReader arq2 = new FileReader("categoria.txt");

        BufferedReader lerArq = new BufferedReader(arq2);

        String linha = lerArq.readLine(); // lê a primeira linha

        while (linha != null && !achei) {

            indice=linha.indexOf(";", 0);
            this.cod_categoria=Integer.parseInt(linha.substring(0, indice));
                if (this.cod_categoria==busca){
                    achei=true;
                    retorno=linha.substring(indice+1);
                }
            linha = lerArq.readLine();
        }
        arq2.close();
        return (retorno);
    }

}
