package org.example.repository;

import org.example.database.SqliteConnection;
import org.example.model.Evento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoRepository {
    public EventoRepository() {
        createTable();
    }

    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS evento (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " nome TEXT NOT NULL,\n"
                + " tipo TEXT NOT NULL,\n"
                + " local TEXT NOT NULL,\n"
                + " data TEXT NOT NULL\n"
                + ");";

        try (Connection conn = SqliteConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addEvento(Evento evento) {
        String sql = "INSERT INTO evento(nome, tipo, local, data) VALUES(?,?,?,?)";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, evento.getNome());
            pstmt.setString(2, evento.getTipo());
            pstmt.setString(3, evento.getLocal());
            pstmt.setString(4, evento.getData());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Evento> getAllEventos() {
        String sql = "SELECT id, nome, tipo, local, data FROM evento";
        List<Evento> eventos = new ArrayList<>();

        try (Connection conn = SqliteConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                eventos.add(new Evento(rs.getInt("id"), rs.getString("nome"), rs.getString("tipo"), rs.getString("local"), rs.getString("data")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return eventos;
    }

    public Evento getEventoById(int id) {
        String sql = "SELECT id, nome, tipo, local, data FROM evento WHERE id = ?";
        Evento evento = null;

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                evento = new Evento(rs.getInt("id"), rs.getString("tipo"), rs.getString("local"), rs.getString("nome"), rs.getString("data"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return evento;
    }

    public void updateEvento(Evento evento) {
        String sql = "UPDATE evento SET nome = ?, tipo = ?, local = ?, data = ? WHERE id = ?";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, evento.getNome());
            pstmt.setString(2, evento.getTipo());
            pstmt.setString(3, evento.getLocal());
            pstmt.setString(4, evento.getData());
            pstmt.setInt(5, evento.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEvento(int id) {
        String sql = "DELETE FROM evento WHERE id = ?";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
