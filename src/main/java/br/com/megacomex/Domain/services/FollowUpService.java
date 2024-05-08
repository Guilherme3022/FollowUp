package br.com.megacomex.Domain.services;

import br.com.megacomex.Domain.entities.FollowUP;
import br.com.megacomex.Domain.entities.Funcionario;
import br.com.megacomex.infra.repository.FollowUpRepository;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FollowUpService {
    private static FollowUpRepository followUPRepository;
    private Scanner scanner;

    public FollowUpService() {
        this.followUPRepository = new FollowUpRepository();
        this.scanner = new Scanner(System.in);
    }

    public void showAllFollowUPs() {
        try {
            List<FollowUP> followUPs = followUPRepository.findAll();
            if (followUPs.isEmpty()) {
                System.out.println("Não foram encontrados FollowUPs ativos.");
            } else {
                System.out.println("Segue a lista de FollowUPs ativos:");
                for (FollowUP followUP : followUPs) {
                    exibirInformacoesFollowUP(followUP);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar FollowUPs: " + e.getMessage());
        }
    }


    public void showAllFollowUPsInactives() {
        try {
            List<FollowUP> followUPs = followUPRepository.findAllInactive();
            if (followUPs.isEmpty()) {
                System.out.println("Não foram encontrados FollowUPs inativos.");
            } else {
                System.out.println("Segue a lista de FollowUPs inativos:");
                for (FollowUP followUP : followUPs) {
                    exibirInformacoesFollowUP(followUP);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar FollowUPs: " + e.getMessage());
        }
    }

    public void showAllFollowUPsProgramador() {
        try {
            List<FollowUP> followUPs = followUPRepository.findAllProgamador();
            if (followUPs.isEmpty()) {
                System.out.println("Não foram encontrados FollowUPs ativos.");
            } else {
                System.out.println("Segue a lista de FollowUPs ativos:");
                for (FollowUP followUP : followUPs) {
                    exibirInformacoesFollowUPProg(followUP);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar FollowUPs: " + e.getMessage());
        }
    }

    public void pesquisaAvancadaFollowUPs() {
        System.out.println("Escolha o tipo de pesquisa:");
        System.out.println("1. Por referência Mega");
        System.out.println("2. Por nome do Trading");
        System.out.println("3. Por funcionário responsável");
        System.out.println("4. Por referência Mega inativos");
        System.out.println("5. Por nome do Trading inativos");
        System.out.println("6. Por funcionário responsável inativos");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        try {
            switch (opcao) {
                case 1:
                    System.out.print("Digite a referência Mega: ");
                    String refMega = scanner.nextLine();
                    pesquisarPorRefMega(refMega);
                    break;
                case 2:
                    System.out.print("Digite o nome do Trading: ");
                    String tradingName = scanner.nextLine();
                    pesquisarPorNomeTrading(tradingName);
                    break;
                case 3:
                    System.out.print("Digite o ID do funcionário responsável: ");
                    String nome = scanner.nextLine();
                    pesquisarPorFuncionarioResponsavel(nome);
                    break;
                case 4:
                    System.out.print("Digite a referência Mega para inativos: ");
                    String refMegaInativos = scanner.nextLine();
                    pesquisarPorRefMegaInativos(refMegaInativos);
                    break;
                case 5:
                    System.out.print("Digite o nome do Trading para inativos: ");
                    String tradingNameInativos = scanner.nextLine();
                    pesquisarPorNomeTradingInativos(tradingNameInativos);
                    break;
                case 6:
                    System.out.print("Digite o ID do funcionário responsável para inativos: ");
                    nome = scanner.nextLine();
                    pesquisarPorFuncionarioResponsavelInativos(nome);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao realizar a pesquisa: " + e.getMessage());
        }
    }

    private void pesquisarPorRefMega(String refMega) throws SQLException {
        FollowUP followUP = followUPRepository.findByRefMega(refMega);
        exibirResultadoPesquisa(followUP);
    }

    private void pesquisarPorNomeTrading(String tradingName) throws SQLException {
        List<FollowUP> followUPs = followUPRepository.findByTrading(tradingName);
        exibirResultadosPesquisa(followUPs);
    }

    private void pesquisarPorFuncionarioResponsavel(String nome) throws SQLException {
        List<FollowUP> followUPs = followUPRepository.findByFuncionarioResponsavel(nome);
        exibirResultadosPesquisa(followUPs);
    }

    private void pesquisarPorRefMegaInativos(String refMega) throws SQLException {
        List<FollowUP> followUPs = followUPRepository.findByTradingInactive(refMega);
        exibirResultadosPesquisa(followUPs);
    }

    private void pesquisarPorNomeTradingInativos(String tradingName) throws SQLException {
        List<FollowUP> followUPs = followUPRepository.findByTradingInactive(tradingName);
        exibirResultadosPesquisa(followUPs);
    }

    private void pesquisarPorFuncionarioResponsavelInativos(String nome) throws SQLException {
        List<FollowUP> followUPs = followUPRepository.findByFuncionarioResponsavelInactive(nome);
        exibirResultadosPesquisa(followUPs);
    }

    private void exibirResultadoPesquisa(FollowUP followUP) {
        if (followUP != null) {
            System.out.println("FollowUP encontrado:");
            exibirInformacoesFollowUP(followUP);
        } else {
            System.out.println("Nenhum FollowUP encontrado com essa referência Mega.");
        }
    }

    private void exibirResultadosPesquisa(List<FollowUP> followUPs) {
        if (!followUPs.isEmpty()) {
            System.out.println("Segue a lista de FollowUPs encontrados:");
            for (FollowUP followUP : followUPs) {
                exibirInformacoesFollowUP(followUP);
            }
        } else {
            System.out.println("Nenhum FollowUP encontrado com esses critérios de pesquisa.");
        }
    }

    private void exibirInformacoesFollowUP(FollowUP followUP) {
        System.out.println("-----------------------------------------");
        System.out.println("RefMega: " + followUP.getRefMega());
        System.out.println("Funcionários Responsáveis: " + followUP.getFuncionariosResponsaveis());
        System.out.println("Nome Trading: " + followUP.getNomeTrading());
        System.out.println("Notify: " + followUP.getNotify());
        System.out.println("RefCliente: " + followUP.getRefCliente());
        System.out.println("Fornecedor: " + followUP.getFornecedor());
        System.out.println("Navio: " + followUP.getNavio());
        System.out.println("Chegada: " + followUP.getChegada());
        System.out.println("HBL: " + followUP.getHbl());
        System.out.println("Armador: " + followUP.getArmador());
        System.out.println("Agente: " + followUP.getAgente());
        System.out.println("CNTR: " + followUP.getCntr());
        System.out.println("Recinto: " + followUP.getRecinto());
        System.out.println("Docs Original: " + followUP.getDocsOriginal());
        System.out.println("Fio, Quantidade, Preço: " + followUP.getFio_QuantidadeFio_PrecoFio());
        System.out.println("Pagto Adv A Vista: " + followUP.getPagtoAdv_AVista());
        System.out.println("Descarga: " + followUP.getDescarga());
        System.out.println("Data Registro: " + followUP.getDataRegistro());
        System.out.println("N_DI: " + followUP.getN_DI());
        System.out.println("Canal: " + followUP.getCanal());
        System.out.println("Desembaraço: " + followUP.getDesenbaraco());
    }
    private void exibirInformacoesFollowUPProg(FollowUP followUP) {
        System.out.println("-----------------------------------------");
        System.out.println("RefMega: " + followUP.getRefMega());
        System.out.println("Funcionários Responsáveis: " + followUP.getFuncionariosResponsaveis());
        System.out.println("Nome Trading: " + followUP.getNomeTrading());
        System.out.println("Notify: " + followUP.getNotify());
        System.out.println("RefCliente: " + followUP.getRefCliente());
        System.out.println("Fornecedor: " + followUP.getFornecedor());
        System.out.println("Navio: " + followUP.getNavio());
        System.out.println("Chegada: " + followUP.getChegada());
        System.out.println("HBL: " + followUP.getHbl());
        System.out.println("Armador: " + followUP.getArmador());
        System.out.println("Agente: " + followUP.getAgente());
        System.out.println("CNTR: " + followUP.getCntr());
        System.out.println("Recinto: " + followUP.getRecinto());
        System.out.println("Docs Original: " + followUP.getDocsOriginal());
        System.out.println("Fio, Quantidade, Preço: " + followUP.getFio_QuantidadeFio_PrecoFio());
        System.out.println("Pagto Adv A Vista: " + followUP.getPagtoAdv_AVista());
        System.out.println("Descarga: " + followUP.getDescarga());
        System.out.println("Data Registro: " + followUP.getDataRegistro());
        System.out.println("N_DI: " + followUP.getN_DI());
        System.out.println("Canal: " + followUP.getCanal());
        System.out.println("Desembaraço: " + followUP.getDesenbaraco());
        System.out.println("live: " + followUP.getLive());
        System.out.println("QRegistrou: " + followUP.getQRegistrou());
        System.out.println("dataRegistrou: " + followUP.getDataRegistrou());
    }
    public void updateFollowUPByRefMega(String refMega) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione os campos que deseja atualizar:");
        System.out.println("1. RefCliente");
        System.out.println("2. Fornecedor");
        System.out.println("3. Navio");
        System.out.println("4. Notify");
        System.out.println("5. HBL");
        System.out.println("6. Armador");
        System.out.println("7. Agente");
        System.out.println("8. CNTR");
        System.out.println("9. Recinto");
        System.out.println("10. DocsOriginal");
        System.out.println("11. Fio_QuantidadeFio_PrecoFio");
        System.out.println("12. PagtoAdv_AVista");
        System.out.println("13. N_DI");
        System.out.println("14. Canal");
        System.out.println("15. Indice");
        System.out.println("0. Sair");

        System.out.print("Digite o número correspondente ao campo que deseja atualizar (ou 0 para sair): ");
        int escolha = scanner.nextInt();

        if (escolha == 0) {
            System.out.println("Operação cancelada.");
            return;
        }

        String campo;
        String novoValor;

        switch (escolha) {
            case 1:
                campo = "refCliente";
                break;
            case 2:
                campo = "fornecedor";
                break;
            case 3:
                campo = "navio";
                break;
            case 4:
                campo = "notify";
                break;
            case 5:
                campo = "hbl";
                break;
            case 6:
                campo = "armador";
                break;
            case 7:
                campo = "agente";
                break;
            case 8:
                campo = "cntr";
                break;
            case 9:
                campo = "recinto";
                break;
            case 10:
                campo = "docsOriginal";
                break;
            case 11:
                campo = "fio_QuantidadeFio_PrecoFio";
                break;
            case 12:
                campo = "pagtoAdv_AVista";
                break;
            case 13:
                campo = "n_DI";
                break;
            case 14:
                campo = "canal";
                break;
            case 15:
                campo = "indice";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        System.out.print("Digite o novo valor para " + campo + ": ");
        novoValor = scanner.next();

        try {
            boolean sucesso = followUPRepository.updateFieldByRefMega(campo, refMega, novoValor);
            if (sucesso) {
                System.out.println("Campo atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o campo. Certifique-se de que a referência Mega seja válida.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a atualização: " + e.getMessage());
        }
    }

    public void registrarFollowUP(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite as informações do FollowUP:");

        System.out.print("RefMega: ");
        String refMega = scanner.nextLine();

        System.out.print("Funcionários Responsáveis: ");
        String funcionariosResponsaveis = scanner.nextLine();

        System.out.print("Nome Trading: ");
        String nomeTrading = scanner.nextLine();

        System.out.print("Notify: ");
        String notify = scanner.nextLine();

        System.out.print("RefCliente: ");
        String refCliente = scanner.nextLine();

        System.out.print("Fornecedor: ");
        String fornecedor = scanner.nextLine();

        System.out.print("Navio: ");
        String navio = scanner.nextLine();

        Date chegada = parseDateInput("Chegada (dd/MM/yyyy): ", scanner);
        if (chegada == null) return;

        System.out.print("HBL: ");
        String hbl = scanner.nextLine();

        System.out.print("Armador: ");
        String armador = scanner.nextLine();

        System.out.print("Agente: ");
        String agente = scanner.nextLine();

        System.out.print("CNTR: ");
        String cntr = scanner.nextLine();

        System.out.print("Recinto: ");
        String recinto = scanner.nextLine();

        System.out.print("Docs Original: ");
        String docsOriginal = scanner.nextLine();

        System.out.print("Fio, Quantidade, Preço: ");
        String fio_QuantidadeFio_PrecoFio = scanner.nextLine();

        System.out.print("Pagto Adv A Vista: ");
        String pagtoAdv_AVista = scanner.nextLine();

        Date descarga = parseDateInput("Descarga (dd/MM/yyyy): ", scanner);
        if (descarga == null) return;

        Date dataRegistro = parseDateInput("Data Registro (dd/MM/yyyy): ", scanner);
        if (dataRegistro == null) return;

        System.out.print("N_DI: ");
        String n_DI = scanner.nextLine();

        System.out.print("Canal: ");
        String canal = scanner.nextLine();

        Date desembaraco = parseDateInput("Desembaraço (dd/MM/yyyy): ", scanner);
        if (desembaraco == null) return;

        try {
            FollowUP followUP = new FollowUP(refMega, funcionariosResponsaveis, nomeTrading, notify, refCliente, fornecedor, navio, chegada, hbl, armador, agente, cntr, recinto, docsOriginal, fio_QuantidadeFio_PrecoFio, pagtoAdv_AVista, descarga, dataRegistro, n_DI, canal, desembaraco);
            followUPRepository.insertFollowUP(followUP, funcionario);
            System.out.println("FollowUP registrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao registrar o FollowUP: " + e.getMessage());
        }
    }

    public void updateFollowUP() {
        Scanner scanner = new Scanner(System.in);
        showAllFollowUPs();

        System.out.print("Digite a referência Mega do FollowUP que deseja atualizar: ");
        String refMega = scanner.nextLine();

        try {
            FollowUP followUP = followUPRepository.findByRefMega(refMega);

            if (followUP != null) {
                System.out.println("FollowUP encontrado:");
                followUPRepository.findByRefMega(refMega);

                updateFollowUPByRefMega(refMega);
            } else {
                System.out.println("Nenhum FollowUP encontrado com a referência Mega fornecida.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o FollowUP: " + e.getMessage());
        }
    }

    public void menuReativarDesativarFollowUP() {
        Scanner sc = null;
        while (true) {
            System.out.println("Menu de Reativar/Desativar FollowUP:");
            System.out.println("1. Reativar FollowUP");
            System.out.println("2. Desativar FollowUP");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");


            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    reativarFollowUP();
                    break;
                case 2:
                    desativarFollowUP();
                    break;
                case 3:
                    System.out.println("Retornando ao Menu Principal...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void reativarFollowUP() {
        showAllFollowUPsInactives();
        Scanner sc = null;
        System.out.print("Digite a referência Mega do FollowUP que deseja reativar: ");
        String refMega = sc.nextLine();
        try {
            boolean sucesso = followUPRepository.turnActive(refMega);
            if (sucesso) {
                System.out.println("FollowUP reativado com sucesso!");
            } else {
                System.out.println("Falha ao reativar o FollowUP. Certifique-se de que a referência Mega seja válida.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao reativar o FollowUP: " + e.getMessage());
        }
    }

    private void desativarFollowUP() {
        showAllFollowUPs();
        Scanner sc = null;
        System.out.print("Digite a referência Mega do FollowUP que deseja desativar: ");
        String refMega = sc.nextLine();
        try {
            boolean sucesso = followUPRepository.deleteLogical(refMega);
            if (sucesso) {
                System.out.println("FollowUP desativado com sucesso!");
            } else {
                System.out.println("Falha ao desativar o FollowUP. Certifique-se de que a referência Mega seja válida.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desativar o FollowUP: " + e.getMessage());
        }
    }

    private Date parseDateInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        String dateStr = scanner.nextLine();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = dateFormat.parse(dateStr);
            DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = outputFormat.format(parsedDate);
            return outputFormat.parse(formattedDate);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Utilize o formato dd/MM/yyyy.");
            return null;
        }
    }


}
