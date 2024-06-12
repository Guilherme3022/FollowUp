package br.com.megacomex;

import java.sql.SQLException;
import java.util.Scanner;
import br.com.megacomex.Domain.entities.*;
import br.com.megacomex.Domain.services.*;
import br.com.megacomex.infra.repository.FuncionarioRepository;

public class Main {
    private FuncionarioService funcionarioService;
    private FollowUpService followUpService;
    private Funcionario funcionarioLogado;

    public Main(FuncionarioService funcionarioService, FollowUpService followUpService) {
        this.funcionarioService = funcionarioService;
        this.followUpService = followUpService;
    }

    public void exibirMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Login");
            System.out.println("2. Registrar Funcionário");
            System.out.println("3. Listar Usuarios Ativos");
            System.out.println("4. Recuperar Senha");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    funcionarioLogado = funcionarioService.fazerLogin();
                    if (funcionarioLogado != null ) {
                        if (funcionarioLogado.getCargo().equals("Programador")) {
                            exibirMenuProgramador();
                        } else {
                            exibirMenuOutrosCargos();
                        }
                    }
                    break;
                case 2:
                    funcionarioService.registrar();
                    break;
                case 3:
                    funcionarioService.listarFuncionariosAtivos();
                    break;
                case 4:
                    funcionarioService.recuperarSenha();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 5);
    }

    public void exibirMenuProgramador() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PROGRAMADOR ===");
            System.out.println("1. Desativar ou Ativar Funcionário");
            System.out.println("2. Listar Funcionários Inativos");
            System.out.println("3. Ver informações completas de um FollowUP criado");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    funcionarioService.desativarOuAtivarfun();
                    break;
                case 2:
                    funcionarioService.listarFuncionariosInativos();
                    break;
                case 3:
                    followUpService.showAllFollowUPsProgramador();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);
    }

    public void exibirMenuOutrosCargos() throws SQLException {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Criar Follow UP");
            System.out.println("2. Ver todos os Follows Ativos");
            System.out.println("3. Ver todos os Follows inativos");
            System.out.println("4. Pesquisa avançada de Follows");
            System.out.println("5. Atualizar Follow");
            System.out.println("6. Reativar ou desativar Follow");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    followUpService.registrarFollowUP(funcionarioLogado);
                    break;
                case 2:
                    followUpService.showAllFollowUPs();
                    break;
                case 3:
                    followUpService.showAllFollowUPsInactives();
                    break;
                case 4:
                    followUpService.pesquisaAvancadaFollowUPs();
                    break;
                case 5:
                    followUpService.updateFollowUP(funcionarioLogado);
                    break;
                case 6:
                    followUpService.menuReativarDesativarFollowUP(funcionarioLogado);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 3);
    }
    public static void main(String[] args) throws SQLException {
        FuncionarioService funcionarioService = new FuncionarioService(new FuncionarioRepository());
        FollowUpService followUpService = new FollowUpService();
        Main main = new Main(funcionarioService, followUpService);
        main.exibirMenu();
    }


}