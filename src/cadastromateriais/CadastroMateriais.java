package cadastromateriais;

import java.io.IOException;

public class CadastroMateriais {

    public static void main(String[] args) throws IOException {
        Categorias c1=new Categorias(1,"teste");
        c1.buscaRegistro(2);
        System.out.println(c1.getCod_categoria()+c1.getNome_categoria());

    }

}
