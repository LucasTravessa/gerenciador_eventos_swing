package org.example.repository;

import org.example.database.SqliteConnection;
import org.example.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    
    PessoaRepository(){
        createTable();
    }
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS pessoa (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " nome TEXT NOT NULL,\n"
                + " cpf TEXT NOT NULL\n"
                + " email TEXT NOT NULL\n"
                + ");";

        try (Connection conn = SqliteConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome, cpf, email) VALUES(?,?,?)";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpf());
            pstmt.setString(3, pessoa.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Pessoa> getAllPessoas() {
        String sql = "SELECT id, nome, cpf, email FROM pessoa";
        List<Pessoa> pessoas = new ArrayList<>();

        try (Connection conn = SqliteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pessoas.add(new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pessoas;
    }

    public Pessoa getPessoaById(int id) {
        String sql = "SELECT id, nome, cpf, email FROM pessoa WHERE id = ?";
        Pessoa pessoa = null;

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"),rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pessoa;
    }

    public void updatePessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoas SET nome = ?, cpf= ?, email = ? WHERE id = ?";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpf());
            pstmt.setString(3, pessoa.getEmail());
            pstmt.setInt(4, pessoa.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePessoa(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
