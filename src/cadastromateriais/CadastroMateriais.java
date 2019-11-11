package cadastromateriais;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class CadastroMateriais {

    public static void limparSaida() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(1);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
        }
    }

    public static String entraEspacos(String s, int n) {
        while (s.length() < n) {
            s += " ";
        }
        s = s.substring(0, n);
        return s;
    }

    private static void MenuPesquisa() throws IOException {
        limparSaida();
        Scanner input = new Scanner(System.in);
        String leitura;
        int op = 1, subOp;
        Produtos produto = new Produtos();
        Movimentacao movimentos = new Movimentacao();
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        while (op != 9) {
            System.out.println("MENU DE PESQUISAS:\n-------------------------");
            System.out.print("1.Pesquisa Produtos\n2.Pesquisa Movimentos de Materiais \n3.Pesquisa de Categorias\n4.Pesquisa de Fornecedores\n9.Sair\n");
            System.out.print("Opção: ");
            leitura = input.nextLine();
            op = Integer.parseInt(leitura);
            limparSaida();
            if (op == 1) {
                System.out.println("PESQUISA DE PRODUTO!\nDigite o codigo do produto a ser pesquisado:");
                leitura = input.nextLine();
                produto.buscaRegistro(Integer.parseInt(leitura));
                System.out.println(produto.mostraRegistro());
            } else if (op == 2) {
                System.out.println("PESQUISA DE MOVIMENTAÇÃO!\nDigite o codigo do movimento a ser pesquisado:");
                leitura = input.nextLine();
                movimentos.buscaRegistro(Integer.parseInt(leitura));
                System.out.println(movimentos.mostraRegistro());
            } else if (op == 3) {
                System.out.println("PESQUISA DE CATEGORIA!\nDigite o codigo da categoria a ser pesquisado:");
                leitura = input.nextLine();
                categoria.buscaRegistro(Integer.parseInt(leitura));
                System.out.println(categoria.mostraRegistro());
            } else if (op == 4) {
                System.out.println("PESQUISA DE FORNECEDOR!\nDigite o codigo do fornecedor a ser pesquisado:");
                leitura = input.nextLine();
                fornecedor.buscaRegistro(Integer.parseInt(leitura));
                System.out.println(fornecedor.mostraRegistro());
            } else if (op == 9) {
                System.out.println("Retorno!");
            } else {
                System.out.println("Opção invalida!");
            }
            System.out.print("1.Menu Pesquisas\n2.Menu Principal\nOpção: ");
            subOp = input.nextInt();
            if (subOp == 1) {
                MenuPesquisa();
            } else {
                menuPrincipal();
            }
        }
    }

    private static void MenuRelatorios() throws IOException {
        limparSaida();
        Scanner input = new Scanner(System.in);
        String leitura;
        int op = 1, subOp;
        Produtos produto = new Produtos();
        Movimentacao movimentos = new Movimentacao();
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        while (op != 9) {
            System.out.println("IMPRESSÃO DE RELATORIOS:\n-------------------------");
            System.out.print("1.Lista de Produtos\n2.Lista de Movimentos de Materiais \n3.Lista de Categorias\n4.Lista de Fornecedores\n5.Relatório de Materiais\n9.Voltar\n");
            System.out.print("Opção: ");
            leitura = input.nextLine();
            op = Integer.parseInt(leitura);
            limparSaida();
            if (op == 1) {
                System.out.println("RELATÓRIO DE PRODUTOS!\n" + produto.listaProdutos());
            } else if (op == 2) {

                System.out.println("RELATÓRIO DE MOVIMENTOS!\n" + movimentos.listaMovimentos());
            } else if (op == 3) {

                System.out.println("RELATÓRIO DE CATEGORIAS!\n" + categoria.listaCategorias());
            } else if (op == 4) {

                System.out.println("RELATÓRIO DE FORNECEDORES!\n" + fornecedor.listaFonecedores());
            } else if (op == 5) {
                System.out.println("RELATÓRIO DE MATERIAIS!\n" + produto.relatorioMateriais());
            } else if (op == 9) {
                System.out.println("Retorno!");               
            } else {
                System.out.println("Opção invalida!");
            }
            System.out.print("1.Menu Relatório\n2.Menu Principal\nOpção: ");
            subOp = input.nextInt();
            if (subOp == 1) {
                MenuRelatorios();
            } else {
                menuPrincipal();
            }
        }     

    }

    private static void MenuCadastro() throws IOException {
        limparSaida();
        //DECLARAÇÕES DOS OBJETOS 
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        Produtos produto = new Produtos();
        Movimentacao movimentacao = new Movimentacao();
        Scanner input = new Scanner(System.in);
        int op = 1;
        while (op != 9) {
            System.out.println("CADASTRO DE MATERIAIS!\n-------------------------");
            System.out.print("1.Cadastrar Categoria\n2.Cadastrar Fornecedor\n3.Cadastrar Produto\n4.Cadastrar Movimentação\n9.Voltar\n");
            System.out.print("Opção: ");
            op = input.nextInt();
            limparSaida();
            if (op == 1) {
                categoria.incluiRegistro(true); //PASSANDO TRUE PARA INDICAR A INSERÇÃO EM UM ARQUIVO EXISTENTE                
            } else if (op == 2) {
                fornecedor.incluiRegistro(true);
            } else if (op == 3) {
                produto.incluiRegistro(true);
            } else if (op == 4) {
                movimentacao.incluiRegistro(true);
            } else if (op == 9) {
                System.out.println("Retornando ao Menu Principal");
            }
        }

    }

    private static void menuPrincipal() throws IOException {
        limparSaida();
        Scanner input = new Scanner(System.in);
        String leitura;
        int op = 1;
        while (op != 9) {
            System.out.println("MENU PRINCIPAL\n---------------");
            System.out.print("1.Cadastrar\n2.Pesquisar\n3.Relatórios\n9.sair\n");
            System.out.print("Opção: ");
            leitura = input.nextLine();
            op = Integer.parseInt(leitura);
            if (op == 1) {
                MenuCadastro();
            } else if (op == 2) {
                MenuPesquisa();
            } else if (op == 3) {
                MenuRelatorios();
            } else if (op == 9) {
                System.out.println("Fechando Aplicação");
            } else {
                System.out.println("Opção invalida!");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        menuPrincipal();
    }

}
