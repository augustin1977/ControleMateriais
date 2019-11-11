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
            robot.setAutoDelay(5);
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
        int op, subOp=1;
        Produtos produto = new Produtos();
        Movimentacao movimentos = new Movimentacao();
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        while(subOp==1){
            op=1;
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
                System.out.print("1.Menu Pesquisas\n9.Menu Principal\nOpção: ");
                leitura = input.nextLine();
                subOp=Integer.parseInt(leitura);
                op=9;         
                }
            
        }
    }

    private static void MenuRelatorios() throws IOException {
        limparSaida();
        float valor;
        Scanner input = new Scanner(System.in);
        String leitura;
        int op = 1, subOp=1, estoque=0;
        Produtos produto = new Produtos();
        Movimentacao movimentos = new Movimentacao();
        Categorias categoria = new Categorias();
        Fornecedor fornecedor = new Fornecedor();
        while (subOp==1){
            op=1;
            while (op != 9) {
                System.out.println("IMPRESSÃO DE RELATORIOS:\n-------------------------");
                System.out.print("1.Lista de Produtos\n2.Lista de Movimentos de Materiais \n3.Lista de Categorias\n4.Lista de Fornecedores\n5.Relatório de Materiais\n6.Relatório de Estoque\n9.Voltar\n");
                System.out.print("Opção: ");
                leitura = input.nextLine();
                op = Integer.parseInt(leitura);
                limparSaida();
                if (op == 1) {
                    System.out.println("RELATÓRIO DE PRODUTOS\n" + produto.listaProdutos());
                } else if (op == 2) {

                    System.out.println("RELATÓRIO DE MOVIMENTOS\n" + movimentos.listaMovimentos());
                } else if (op == 3) {

                    System.out.println("RELATÓRIO DE CATEGORIAS\n" + categoria.listaCategorias());
                } else if (op == 4) {

                    System.out.println("RELATÓRIO DE FORNECEDORES\n" + fornecedor.listaFonecedores());
                } else if (op == 5) {
                    System.out.println("RELATÓRIO DE MATERIAIS\n" + produto.relatorioMateriais());
                } else if (op == 6) {
                    System.out.println("RELATÓRIO DE ESTOQUE\n----------------------------------------------");
                    System.out.println("CODIGO - DESCRIÇÃO DO ITEM                        - QUANTIDADE  - PREÇO      - VALOR ESTOQUE");
                    for (int i=0;i<produto.UltimoCodigo();i++){
                        produto.buscaRegistro(i);
                        if (produto.getCodProduto()!=0){
                            estoque=movimentos.estoque(produto.getCodProduto());
                            System.out.println(entraEspacos(Integer.toString(produto.getCodProduto()),6)+
                                    " - "+entraEspacos(produto.getdescricao(),40) +" - "+ 
                                    entraEspacos(Integer.toString(estoque),11) + " - "+ 
                                    entraEspacos((String.format("%.2f",produto.getPreco())),10) +
                                    " - "+ String.format("%.2f",produto.getPreco()*estoque));
                        }
                    }
                    System.out.println("----------------------------------------------");
                }else if (op == 9) {
                    System.out.println("Retorno!");               
                } else {
                    System.out.println("Opção invalida!");
                }
                System.out.print("1.Menu Relatório\n9.Menu Principal\nOpção: ");
                leitura = input.nextLine();
                op=9;
                subOp = Integer.parseInt(leitura);
                System.out.println(subOp);
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
            System.out.println("MENU DE CADASTROS!\n-------------------------");
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
            if (leitura=="")
            {
                op=0;
            }else{
                op = Integer.parseInt(leitura);
            }
            
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
