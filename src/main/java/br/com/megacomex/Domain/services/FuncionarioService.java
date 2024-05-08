package br.com.megacomex.Domain.services;
import br.com.megacomex.Domain.entities.Funcionario;
import br.com.megacomex.infra.repository.FuncionarioRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    Scanner sc = new Scanner(System.in);
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public boolean registrar() {
        Funcionario funcionario = new Funcionario();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        funcionario.setNome(nome);

        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        funcionario.setSenha(senha);

        System.out.println("Digite seu cargo:");
        String cargo = sc.nextLine();
        funcionario.setCargo(cargo);

        try {
            funcionarioRepository.insertFuncionario(funcionario);
            System.out.println("Registro realizado com sucesso!!!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao registrar: " + e.getMessage());
            return false;
        }
    }
    public Funcionario fazerLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();

        try {
            Funcionario funcionario = funcionarioRepository.findByNomeAndSenha(nome, senha);
            if (funcionario != null) {
                System.out.println("Login bem-sucedido! Bem-vindo, " + funcionario.getNome() + ".");
                return funcionario;
            } else {
                System.out.println("Nome de usuário ou senha incorretos.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
            return null;
        }
    }

    public void listarFuncionariosAtivos() throws SQLException {
        List<Funcionario> funcionarios;
        funcionarios = funcionarioRepository.findAll();
        System.out.println("\n=== FUNCIONÁRIOS ATIVOS ===");
        System.out.println("| ID  |      Nome     |    Cargo   |");
        System.out.println("-----------------------------------");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("| %-4d| %-14s| %-11s|%n", funcionario.getId(), funcionario.getNome(), funcionario.getCargo());
        }
        System.out.println("-----------------------------------");
    }

    public void listarFuncionariosInativos() throws SQLException {
        List<Funcionario> funcionarios;
        funcionarios = funcionarioRepository.findAllInactives();
        System.out.println("\n=== FUNCIONÁRIOS INATIVOS ===");
        System.out.println("| ID  |      Nome     |    Cargo   |");
        System.out.println("-----------------------------------");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("| %-4d| %-14s| %-11s|%n", funcionario.getId(), funcionario.getNome(), funcionario.getCargo());
        }
        System.out.println("-----------------------------------");
    }
    public void recuperarSenha() {
        LocalDate hoje = LocalDate.now();
        String senhaCorreta = Integer.toBinaryString(hoje.getDayOfMonth());

        System.out.print("Digite a senha para recuperar a senha: ");
        String senhaUsuario = sc.next();
        if (senhaCorreta.equals(senhaUsuario)) {
            try {
                System.out.println("Digite seu id:\n");
                int id = sc.nextInt();
                Funcionario funcionarioRecuperado = funcionarioRepository.recoveryPassword(id);

                if (funcionarioRecuperado != null) {
                    System.out.println("Senha recuperada: " + funcionarioRecuperado.getSenha());
                } else {
                    System.out.println("Não foi possível recuperar a senha.");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao recuperar a senha: " + e.getMessage());
            }
        } else {
            System.out.println("Senha incorreta. Tente novamente.");
        }
    }
    public void desativarOuAtivarfun() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do funcionário: ");
        int id = sc.nextInt();

        System.out.println("Escolha a operação:");
        System.out.println("1. Desativar");
        System.out.println("2. Ativar");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();

        boolean sucesso = false;
        try {
            switch (opcao) {
                case 1:
                    sucesso = funcionarioRepository.deleteLogical(id);
                    break;
                case 2:
                    sucesso = funcionarioRepository.turnActive(id);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            if (sucesso) {
                System.out.println("Operação realizada com sucesso.");
            } else {
                System.out.println("Não foi possível realizar a operação.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a operação: " + e.getMessage());
        }
    }

}
