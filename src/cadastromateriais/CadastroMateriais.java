package cadastromateriais;

import java.awt.SystemColor;
import java.io.IOException;
import java.util.Scanner;

public class CadastroMateriais {
    public static String entraEspacos(String s,int n){
        while(s.length()< n){
            s+=" ";
        }
        return s;
    }
    
    private static void Menu() throws IOException
    {
        //DECLARAÇÕES DOS OBJETOS 
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        Produtos produto =new Produtos();
        Movimentacao movimentacao = new Movimentacao(); 
        Scanner input = new Scanner(System.in);
        System.out.println("CADASTRO DE MATERIAIS!");
        System.out.print("1. Cadastrar Categoria\n2.Cadastrar Fornecedor\n3.Cadastrar Produto\n4.Cadastrar Movimentação\n");
        System.out.print("Opção: ");
        int op = input.nextInt();
        if(op == 1)
        {
            categoria.incluiRegistro(true); //PASSANDO TRUE PARA INDICAR A INSERÇÃO EM UM ARQUIVO EXISTENTE            
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
        
        System.out.println("\nDeseja voltar ao menu? (1. Sim / 2.Não): ");
        int voltar = input.nextInt();
        
        if(voltar == 1)
        {
            Menu();
        }
    }

    public static void main(String[] args) throws IOException {
        Menu();
    }

}
