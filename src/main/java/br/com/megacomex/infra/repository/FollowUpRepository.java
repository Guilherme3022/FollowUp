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


    public boolean updateRefClienteByRefMega(String refMega, String newRefCliente) throws SQLException {
        return updateFieldByRefMega("refCliente", refMega, newRefCliente);
    }

    public boolean updateFornecedorByRefMega(String refMega, String newFornecedor) throws SQLException {
        return updateFieldByRefMega("fornecedor", refMega, newFornecedor);
    }

    public boolean updateNavioByRefMega(String refMega, String newNavio) throws SQLException {
        return updateFieldByRefMega("navio", refMega, newNavio);
    }

    public boolean updateNotifyByRefMega(String refMega, String newNotify) throws SQLException {
        return updateFieldByRefMega("notify", refMega, newNotify);
    }

    public boolean updateHblByRefMega(String refMega, String newHbl) throws SQLException {
        return updateFieldByRefMega("hbl", refMega, newHbl);
    }

    public boolean updateArmadorByRefMega(String refMega, String newArmador) throws SQLException {
        return updateFieldByRefMega("armador", refMega, newArmador);
    }

    public boolean updateAgenteByRefMega(String refMega, String newAgente) throws SQLException {
        return updateFieldByRefMega("agente", refMega, newAgente);
    }

    public boolean updateCntrByRefMega(String refMega, String newCntr) throws SQLException {
        return updateFieldByRefMega("cntr", refMega, newCntr);
    }

    public boolean updateRecintoByRefMega(String refMega, String newRecinto) throws SQLException {
        return updateFieldByRefMega("recinto", refMega, newRecinto);
    }

    public boolean updateDocsOriginalByRefMega(String refMega, String newDocsOriginal) throws SQLException {
        return updateFieldByRefMega("docsOriginal", refMega, newDocsOriginal);
    }

    public boolean updateFio_QuantidadeFio_PrecoFioByRefMega(String refMega, String newFio_QuantidadeFio_PrecoFio) throws SQLException {
        return updateFieldByRefMega("fio_QuantidadeFio_PrecoFio", refMega, newFio_QuantidadeFio_PrecoFio);
    }

    public boolean updatePagtoAdv_AVistaByRefMega(String refMega, String newPagtoAdv_AVista) throws SQLException {
        return updateFieldByRefMega("pagtoAdv_AVista", refMega, newPagtoAdv_AVista);
    }

    public boolean updateNDIByRefMega(String refMega, String newNDI) throws SQLException {
        return updateFieldByRefMega("n_DI", refMega, newNDI);
    }

    public boolean updateCanalByRefMega(String refMega, String newCanal) throws SQLException {
        return updateFieldByRefMega("canal", refMega, newCanal);
    }
    public boolean updateIndiceByRefMega(String refMega, String newCanal) throws SQLException {
        return updateFieldByRefMega("indice", refMega, newCanal);
    }

    public boolean updateFieldByRefMega(String fieldName, String refMega, String newValue) throws SQLException {
        if (refMega == null || newValue == null) {
            return false;
        }

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(("UPDATE FollowUP SET " + fieldName + " = ? WHERE refMega = ?"));
        preparedStatement.setString(1, newValue);
        preparedStatement.setString(2, refMega);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
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
