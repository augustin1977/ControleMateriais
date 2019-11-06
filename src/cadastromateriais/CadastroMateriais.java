package cadastromateriais;

import java.io.IOException;

public class CadastroMateriais {

    public static void main(String[] args) throws IOException {
        Categorias c1=new Categorias();
        c1.buscaRegistro(3);
        System.out.println(c1.getCod_categoria()+c1.getNome_categoria());
        Fornecedor f1=new Fornecedor();
        f1.buscaRegistro(1);
        System.out.println(f1.getCodFornecedor()+f1.getNomeFornecedor()+f1.getTelefoneFornecedor());

    }

}
