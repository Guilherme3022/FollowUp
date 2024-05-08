package br.com.megacomex.infra.repository;
import br.com.megacomex.Domain.entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioRepository {
    private DatabaseConnection connection;

    public FuncionarioRepository() {
        this.connection = DatabaseConnection.getInstance();
    }

    public List<Funcionario> findAll() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM Funcionario");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("Live");
            if (live == 1) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
    public List<Funcionario> findAllInactives() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM Funcionario");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int live = resultSet.getInt("Live");
            if (live == 0) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    public Funcionario findByNomeAndSenha(String nome, String senha) throws SQLException {
        Funcionario funcionario = null;
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT * FROM funcionario WHERE nome = ? AND senha = ?");
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, senha);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            funcionario = new Funcionario();
            int live = resultSet.getInt("Live");
            if (live == 1) {
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setCargo(resultSet.getString("cargo"));
            } else {
                System.out.println("Funcionário inativo");
            }
        } else {
            System.out.println("Funcionário não encontrado");
        }
        return funcionario;
    }

    public int findFuncionarioIdByNome(String nome) throws SQLException {
        int funcionarioId = -1; // Inicialize com um valor padrão que indique que o funcionário não foi encontrado

        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT id, live FROM funcionario WHERE nome = ?");
        preparedStatement.setString(1, nome);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int live = resultSet.getInt("live");
            if (live == 1) {
                funcionarioId = resultSet.getInt("id"); // Atualize o ID do funcionário se ele for encontrado
            } else {
                System.out.println("Funcionário inativo.");
            }
        } else {
            System.out.println("Funcionário não encontrado.");
        }
        return funcionarioId;
    }

    public Funcionario recoveryPassword(int id) throws SQLException {
        Funcionario funcionario = null;
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement("SELECT senha, live FROM funcionario WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            funcionario = new Funcionario();
            int live = resultSet.getInt("Live");
            if (live == 1) {
                funcionario.setSenha(resultSet.getString("senha"));
            } else {
                System.out.println("inactive individual");
            }
        }
        return funcionario;
    }

    public void insertFuncionario(Funcionario funcionario) throws SQLException {
        PreparedStatement preparedStatement = connection.getConnection().prepareStatement("INSERT INTO Funcionario (nome, cargo, senha) VALUES (?, ?, ?)");
        preparedStatement.setString(1, funcionario.getNome());
        preparedStatement.setString(2, funcionario.getCargo());
        preparedStatement.setString(3, funcionario.getSenha());
        preparedStatement.executeUpdate();
    }
    public boolean deleteLogical(int id) throws SQLException {
        if (id <= 0) {
            return false;
        }
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(
                "UPDATE Funcionario SET Live = ? WHERE id = ?");
        preparedStatement.setInt(1, 0);
        preparedStatement.setInt(2, id);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }

    public boolean turnActive(int id) throws SQLException {
        if (id <= 0) {
            return false;
        }
        PreparedStatement preparedStatement = this.connection.getConnection().prepareStatement(
                "UPDATE FollowUP SET Live = ? WHERE id = ?");
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, id);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }


}
