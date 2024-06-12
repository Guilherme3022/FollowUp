package br.com.megacomex.infra.repository;

import br.com.megacomex.Domain.entities.FollowUP;
import br.com.megacomex.Domain.entities.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FollowUpRepository {
    private DatabaseConnection connection;

    public FollowUpRepository() {
        this.connection = DatabaseConnection.getInstance();
    }

    public List<FollowUP> findAll() throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("live");
            if (live == 1) {
                FollowUP followUP = new FollowUP();
                followUP.setId(resultSet.getInt("id"));
                followUP.setRefMega(resultSet.getString("refMega"));
                followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
                followUP.setNomeTrading(resultSet.getString("nomeTrading"));
                followUP.setNotify(resultSet.getString("notify"));
                followUP.setRefCliente(resultSet.getString("refCliente"));
                followUP.setFornecedor(resultSet.getString("fornecedor"));
                followUP.setNavio(resultSet.getString("navio"));
                followUP.setChegada(resultSet.getDate("chegada"));
                followUP.setHbl(resultSet.getString("hbl"));
                followUP.setArmador(resultSet.getString("armador"));
                followUP.setAgente(resultSet.getString("agente"));
                followUP.setCntr(resultSet.getString("cntr"));
                followUP.setRecinto(resultSet.getString("recinto"));
                followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
                followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
                followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
                followUP.setDescarga(resultSet.getDate("descarga"));
                followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
                followUP.setN_DI(resultSet.getString("n_DI"));
                followUP.setCanal(resultSet.getString("canal"));
                followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
                followUPs.add(followUP);
            }
        }
        return followUPs;
    }
    public List<FollowUP> findAllProgamador() throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("live");
            if (live == 1) {
                FollowUP followUP = new FollowUP();
                followUP.setId(resultSet.getInt("id"));
                followUP.setRefMega(resultSet.getString("refMega"));
                followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
                followUP.setNomeTrading(resultSet.getString("nomeTrading"));
                followUP.setNotify(resultSet.getString("notify"));
                followUP.setRefCliente(resultSet.getString("refCliente"));
                followUP.setFornecedor(resultSet.getString("fornecedor"));
                followUP.setNavio(resultSet.getString("navio"));
                followUP.setChegada(resultSet.getDate("chegada"));
                followUP.setHbl(resultSet.getString("hbl"));
                followUP.setArmador(resultSet.getString("armador"));
                followUP.setAgente(resultSet.getString("agente"));
                followUP.setCntr(resultSet.getString("cntr"));
                followUP.setRecinto(resultSet.getString("recinto"));
                followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
                followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
                followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
                followUP.setDescarga(resultSet.getDate("descarga"));
                followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
                followUP.setN_DI(resultSet.getString("n_DI"));
                followUP.setCanal(resultSet.getString("canal"));
                followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
                followUP.setLive(resultSet.getInt("live"));
                followUP.setQRegistrou(resultSet.getString("QRegistrou"));
                followUP.setDataRegistrou(resultSet.getDate("dataRegistrou"));
                followUP.setLast_updated_at(resultSet.getDate("last_updated_at"));
                followUP.setUpdated_by(resultSet.getString("updated_by"));
                followUPs.add(followUP);
            }
        }
        return followUPs;
    }
    public List<FollowUP> findAllInactive() throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("live");
            if (live == 0) {
                FollowUP followUP = new FollowUP();
                followUP.setRefMega(resultSet.getString("refMega"));
                followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
                followUP.setNomeTrading(resultSet.getString("nomeTrading"));
                followUP.setNotify(resultSet.getString("notify"));
                followUP.setRefCliente(resultSet.getString("refCliente"));
                followUP.setFornecedor(resultSet.getString("fornecedor"));
                followUP.setNavio(resultSet.getString("navio"));
                followUP.setChegada(resultSet.getDate("chegada"));
                followUP.setHbl(resultSet.getString("hbl"));
                followUP.setArmador(resultSet.getString("armador"));
                followUP.setAgente(resultSet.getString("agente"));
                followUP.setCntr(resultSet.getString("cntr"));
                followUP.setRecinto(resultSet.getString("recinto"));
                followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
                followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
                followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
                followUP.setDescarga(resultSet.getDate("descarga"));
                followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
                followUP.setN_DI(resultSet.getString("n_DI"));
                followUP.setCanal(resultSet.getString("canal"));
                followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
                followUPs.add(followUP);
            }
        }
        return followUPs;
    }

    public FollowUP findByRefMega(String refMega) throws SQLException {
        FollowUP followUP = null;
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP WHERE refMega = ?");
        preparedStatement.setString(1, refMega);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            followUP = new FollowUP();
            int live = resultSet.getInt("live");
            if (live == 1) {
                followUP.setRefMega(resultSet.getString("refMega"));
                followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
                followUP.setNomeTrading(resultSet.getString("nomeTrading"));
                followUP.setNotify(resultSet.getString("notify"));
                followUP.setRefCliente(resultSet.getString("refCliente"));
                followUP.setFornecedor(resultSet.getString("fornecedor"));
                followUP.setNavio(resultSet.getString("navio"));
                followUP.setChegada(resultSet.getDate("chegada"));
                followUP.setHbl(resultSet.getString("hbl"));
                followUP.setArmador(resultSet.getString("armador"));
                followUP.setAgente(resultSet.getString("agente"));
                followUP.setCntr(resultSet.getString("cntr"));
                followUP.setRecinto(resultSet.getString("recinto"));
                followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
                followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
                followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
                followUP.setDescarga(resultSet.getDate("descarga"));
                followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
                followUP.setN_DI(resultSet.getString("n_DI"));
                followUP.setCanal(resultSet.getString("canal"));
                followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
            } else {
                System.out.println("Processo inativo");
            }
        }
        return followUP;
    }

    public List<FollowUP> findByTrading(String tradingName) throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP WHERE nomeTrading = ?");
        preparedStatement.setString(1, tradingName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("live");
            if (live == 1) {
                FollowUP followUP = new FollowUP();
                followUP.setRefMega(resultSet.getString("refMega"));
                followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
                followUP.setNomeTrading(resultSet.getString("nomeTrading"));
                followUP.setNotify(resultSet.getString("notify"));
                followUP.setRefCliente(resultSet.getString("refCliente"));
                followUP.setFornecedor(resultSet.getString("fornecedor"));
                followUP.setNavio(resultSet.getString("navio"));
                followUP.setChegada(resultSet.getDate("chegada"));
                followUP.setHbl(resultSet.getString("hbl"));
                followUP.setArmador(resultSet.getString("armador"));
                followUP.setAgente(resultSet.getString("agente"));
                followUP.setCntr(resultSet.getString("cntr"));
                followUP.setRecinto(resultSet.getString("recinto"));
                followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
                followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
                followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
                followUP.setDescarga(resultSet.getDate("descarga"));
                followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
                followUP.setN_DI(resultSet.getString("n_DI"));
                followUP.setCanal(resultSet.getString("canal"));
                followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
                followUPs.add(followUP);
            }
        }
        return followUPs;
    }

    public List<FollowUP> findByFuncionarioResponsavel(String nomeFuncionario) throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        // Obtenha o ID do funcionário pelo nome
        FuncionarioRepository funncionarioRepository = null;
        int funcionarioId = funncionarioRepository.findFuncionarioIdByNome(nomeFuncionario);

        // Se o ID do funcionário for -1, retorne uma lista vazia
        if (funcionarioId == -1) {
            return followUPs;
        }

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP WHERE funcionariosResponsaveis = ? AND live = 1");
        preparedStatement.setInt(1, funcionarioId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            FollowUP followUP = new FollowUP();
            followUP.setRefMega(resultSet.getString("refMega"));
            followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
            followUP.setNomeTrading(resultSet.getString("nomeTrading"));
            followUP.setNotify(resultSet.getString("notify"));
            followUP.setRefCliente(resultSet.getString("refCliente"));
            followUP.setFornecedor(resultSet.getString("fornecedor"));
            followUP.setNavio(resultSet.getString("navio"));
            followUP.setChegada(resultSet.getDate("chegada"));
            followUP.setHbl(resultSet.getString("hbl"));
            followUP.setArmador(resultSet.getString("armador"));
            followUP.setAgente(resultSet.getString("agente"));
            followUP.setCntr(resultSet.getString("cntr"));
            followUP.setRecinto(resultSet.getString("recinto"));
            followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
            followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
            followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
            followUP.setDescarga(resultSet.getDate("descarga"));
            followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
            followUP.setN_DI(resultSet.getString("n_DI"));
            followUP.setCanal(resultSet.getString("canal"));
            followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
            followUPs.add(followUP);
        }
        return followUPs;
    }
    public List<FollowUP> findByTradingInactive(String tradingName) throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP WHERE nomeTrading = ?");
        preparedStatement.setString(1, tradingName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("live");
            if (live == 0) {
                FollowUP followUP = new FollowUP();
                followUP.setRefMega(resultSet.getString("refMega"));
                followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
                followUP.setNomeTrading(resultSet.getString("nomeTrading"));
                followUP.setNotify(resultSet.getString("notify"));
                followUP.setRefCliente(resultSet.getString("refCliente"));
                followUP.setFornecedor(resultSet.getString("fornecedor"));
                followUP.setNavio(resultSet.getString("navio"));
                followUP.setChegada(resultSet.getDate("chegada"));
                followUP.setHbl(resultSet.getString("hbl"));
                followUP.setArmador(resultSet.getString("armador"));
                followUP.setAgente(resultSet.getString("agente"));
                followUP.setCntr(resultSet.getString("cntr"));
                followUP.setRecinto(resultSet.getString("recinto"));
                followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
                followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
                followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
                followUP.setDescarga(resultSet.getDate("descarga"));
                followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
                followUP.setN_DI(resultSet.getString("n_DI"));
                followUP.setCanal(resultSet.getString("canal"));
                followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
                followUPs.add(followUP);
            }
        }
        return followUPs;
    }

    public List<FollowUP> findByFuncionarioResponsavelInactive(String nomeFuncionario) throws SQLException {
        List<FollowUP> followUPs = new ArrayList<>();
        // Obtenha o ID do funcionário pelo nome
        FuncionarioRepository funncionarioRepository = null;
        int funcionarioId = funncionarioRepository.findFuncionarioIdByNome(nomeFuncionario);

        // Se o ID do funcionário for -1, retorne uma lista vazia
        if (funcionarioId == -1) {
            return followUPs;
        }

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM FollowUP WHERE funcionariosResponsaveis = ? AND live = 0");
        preparedStatement.setInt(1, funcionarioId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            FollowUP followUP = new FollowUP();
            followUP.setRefMega(resultSet.getString("refMega"));
            followUP.setFuncionariosResponsaveis(resultSet.getString("funcionariosResponsaveis"));
            followUP.setNomeTrading(resultSet.getString("nomeTrading"));
            followUP.setNotify(resultSet.getString("notify"));
            followUP.setRefCliente(resultSet.getString("refCliente"));
            followUP.setFornecedor(resultSet.getString("fornecedor"));
            followUP.setNavio(resultSet.getString("navio"));
            followUP.setChegada(resultSet.getDate("chegada"));
            followUP.setHbl(resultSet.getString("hbl"));
            followUP.setArmador(resultSet.getString("armador"));
            followUP.setAgente(resultSet.getString("agente"));
            followUP.setCntr(resultSet.getString("cntr"));
            followUP.setRecinto(resultSet.getString("recinto"));
            followUP.setDocsOriginal(resultSet.getString("docsOriginal"));
            followUP.setFio_QuantidadeFio_PrecoFio(resultSet.getString("fio_QuantidadeFio_PrecoFio"));
            followUP.setPagtoAdv_AVista(resultSet.getString("pagtoAdv_AVista"));
            followUP.setDescarga(resultSet.getDate("descarga"));
            followUP.setDataRegistro(resultSet.getDate("dataRegistro"));
            followUP.setN_DI(resultSet.getString("n_DI"));
            followUP.setCanal(resultSet.getString("canal"));
            followUP.setDesenbaraco(resultSet.getDate("desenbaraco"));
            followUPs.add(followUP);
        }
        return followUPs;
    }

    public void insertFollowUP(FollowUP followUP, Funcionario funcionario) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(("INSERT INTO FollowUP (refMega, funcionariosResponsaveis, nomeTrading, notify, refCliente, fornecedor, navio, chegada, hbl, armador, agente, cntr, recinto, docsOriginal, fio_QuantidadeFio_PrecoFio, pagtoAdv_AVista, descarga, dataRegistro, n_DI, canal, desenbaraco, QRegistrou, dataRegistrou) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"));

        preparedStatement.setString(1, followUP.getRefMega());
        preparedStatement.setString(2, followUP.getFuncionariosResponsaveis());
        preparedStatement.setString(3, followUP.getNomeTrading());
        preparedStatement.setString(4, followUP.getNotify());
        preparedStatement.setString(5, followUP.getRefCliente());
        preparedStatement.setString(6, followUP.getFornecedor());
        preparedStatement.setString(7, followUP.getNavio());
        preparedStatement.setString(8, dateFormat.format(followUP.getChegada())); // chegada
        preparedStatement.setString(9, followUP.getHbl());
        preparedStatement.setString(10, followUP.getArmador());
        preparedStatement.setString(11, followUP.getAgente());
        preparedStatement.setString(12, followUP.getCntr());
        preparedStatement.setString(13, followUP.getRecinto());
        preparedStatement.setString(14, followUP.getDocsOriginal());
        preparedStatement.setString(15, followUP.getFio_QuantidadeFio_PrecoFio());
        preparedStatement.setString(16, followUP.getPagtoAdv_AVista());
        preparedStatement.setString(17, dateFormat.format(followUP.getDescarga())); // descarga
        preparedStatement.setString(18, dateFormat.format(followUP.getDataRegistro())); // dataRegistro
        preparedStatement.setString(19, followUP.getN_DI());
        preparedStatement.setString(20, followUP.getCanal());
        preparedStatement.setString(21, dateFormat.format(followUP.getDesenbaraco())); // desenbaraco
        preparedStatement.setString(22, funcionario.getNome()); // QRegistrou = pessoa logada
        preparedStatement.setString(23, dateFormat.format(new java.util.Date())); // dataRegistrou = data atual

        preparedStatement.executeUpdate();
    }



    public boolean updateFieldByRefMega(String fieldName, String refMega, String newValue, Funcionario funcionarioLogado) throws SQLException {
        if (refMega == null || newValue == null || funcionarioLogado == null) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String updateSQL = "UPDATE FollowUP SET " + fieldName + " = ?, updated_by = ?, last_updated_at = ? WHERE refMega = ?";
        try (PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(updateSQL)) {
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, funcionarioLogado.getNome()); // Nome do funcionário logado
            preparedStatement.setString(3,dateFormat.format(new java.util.Date())); // Data atual
            preparedStatement.setString(4, refMega);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao executar a atualização: " + e.getMessage());
            throw e;
        }
    }
    public boolean deleteLogical(String refMega) throws SQLException {
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(
                "UPDATE FollowUP SET Live = ? WHERE refMega = ?");
        preparedStatement.setInt(1, 0);
        preparedStatement.setString(2, refMega );
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }

    public boolean turnActive(String refMega) throws SQLException {
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(
                "UPDATE FollowUP SET Live = ? WHERE refMega = ?");
        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, refMega);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }



}
