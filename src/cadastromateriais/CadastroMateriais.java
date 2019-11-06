package cadastromateriais;

import java.io.IOException;

public class CadastroMateriais {
    public static String entraEspacos(String s,int n){
        while(s.length()< n){
            s+=" ";
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        Categorias c1=new Categorias();
        Fornecedor f1=new Fornecedor();
        Produtos p1=new Produtos();
        Movimentacao m1= new Movimentacao();
        f1.buscaRegistro(p1.getCodFornecedor());
        c1.buscaRegistro(3);
        System.out.println(c1.getcodCategoria()+" - "+c1.getnomeCategoria());
        f1.buscaRegistro(1);
        System.out.println(f1.getCodFornecedor()+" - "+f1.getNomeFornecedor()+" - "+f1.getTelefoneFornecedor());
        p1.buscaRegistro(5);
        System.out.println(p1.getCodProduto()+" - "+p1.getdescricao()+" - "+p1.getPreco()+" - "+p1.getCodCategoria()+" - "+p1.getCodFornecedor()+" - "+f1.getNomeFornecedor());
        m1.buscaRegistro(10);
        p1.buscaRegistro(m1.getCodProduto());
        c1.buscaRegistro(p1.getCodCategoria());
        f1.buscaRegistro(p1.getCodFornecedor());
        System.out.println(m1.getCodigoMovimentacao()+" - "+m1.getTipoMovimentacao()+" - "+m1.getQuantidadeMovimentacao()+" - "+m1.getCodProduto()+" - "+p1.getdescricao()+ " - R$"+ p1.getPreco()*m1.getQuantidadeMovimentacao()+" - Fornecido por: "+ f1.getNomeFornecedor()+" - categoria:"+ c1.getnomeCategoria());
        System.out.println(c1.UltimoCodigo());
        System.out.println(f1.UltimoCodigo());
        System.out.println(p1.UltimoCodigo());
        System.out.println(m1.UltimoCodigo());
        //c1.incluiRegistro(true);
        //f1.incluiRegistro(true);
        //p1.incluiRegistro(true);
        //m1.incluiRegistro(true);
        System.out.println(c1.listaCategorias());
        System.out.println(f1.listaFonecedores());
        System.out.println(p1.listaProdutos());
        System.out.println(m1.listaMovimentos());
    }

}
