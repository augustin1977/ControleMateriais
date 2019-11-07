package cadastromateriais;

import java.io.IOException;
import java.util.Scanner;

public class CadastroMateriais {
    public static String entraEspacos(String s,int n){
        while(s.length()< n){
            s+=" ";
        }
        return s;
    }
    private static void MenuPesquisa(){
        System.out.println("Em implanta��o");
    }
    private static void MenuRelatorios(){
        System.out.println("Em implanta��o");
        
    }
    
    private static void MenuCadastro() throws IOException
    {
        //DECLARA��ES DOS OBJETOS 
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        Produtos produto =new Produtos();
        Movimentacao movimentacao = new Movimentacao(); 
        Scanner input = new Scanner(System.in);
        int op =1;
        while(op!=5){
            System.out.println("CADASTRO DE MATERIAIS!");
            System.out.print("1.Cadastrar Categoria\n2.Cadastrar Fornecedor\n3.Cadastrar Produto\n4.Cadastrar Movimenta��o\n5.Voltar\n");
            System.out.print("Op��o: ");
            op = input.nextInt();
            if(op == 1)
            {
                categoria.incluiRegistro(true); //PASSANDO TRUE PARA INDICAR A INSER��O EM UM ARQUIVO EXISTENTE            
            }
            else if(op == 2)
            {
                fornecedor.incluiRegistro(true);
            }
            else if(op == 3)
            {
                produto.incluiRegistro(true);
            }
            else if(op == 4)
            {
                movimentacao.incluiRegistro(true);
            }
            else if (op==5){
                System.out.println("Retornando ao menu...");
            }
        }
            
    }
    private static void menuPrincipal() throws IOException{
        Scanner input = new Scanner(System.in);
        String leitura;
        int op=1;
        while(op!=4){
            System.out.println("CADASTRO DE MATERIAIS!");
            System.out.print("1.Cadastrar\n2.Pesquisar\n3.Relat�rios\n4.sair\n");
            System.out.print("Op��o: ");
            leitura = input.nextLine();
            op=Integer.parseInt(leitura);
            if (op==1){
                MenuCadastro();
            }
            else if (op==2){
                MenuPesquisa();
            }
            else if (op==3){
                MenuRelatorios();
            }

            else if (op==4){
                System.out.println("Fechando aplica��o");
            }
            else{
                System.out.println("Op��o invalida!");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        menuPrincipal();
    }

}
