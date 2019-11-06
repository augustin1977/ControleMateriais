package cadastromateriais;

import java.io.IOException;

public class CadastroMateriais {

    public static void main(String[] args) throws IOException {
        Categorias c1=new Categorias();
        c1.buscaRegistro(3);
        System.out.println(c1.getcodCategoria()+" - "+c1.getnomeCategoria());
        Fornecedor f1=new Fornecedor();
        f1.buscaRegistro(1);
        System.out.println(f1.getCodFornecedor()+" - "+f1.getNomeFornecedor()+" - "+f1.getTelefoneFornecedor());
        Produtos p1=new Produtos();
        p1.buscaRegistro(5);
        f1.buscaRegistro(p1.getCodFornecedor());
        System.out.println(p1.getCodProduto()+" - "+p1.getdescricao()+" - "+p1.getPreco()+" - "+p1.getCodCategoria()+" - "+p1.getCodFornecedor()+" - "+f1.getNomeFornecedor());
        Movimentacao m1= new Movimentacao();
        m1.buscaRegistro(10);
        p1.buscaRegistro(m1.getCodProduto());
        System.out.println(m1.getCodigoMovimentacao()+" - "+m1.getTipoMovimentacao()+" - "+m1.getQuantidadeMovimentacao()+" - "+m1.getCodProduto()+" - "+p1.getdescricao());
        

    }

}
