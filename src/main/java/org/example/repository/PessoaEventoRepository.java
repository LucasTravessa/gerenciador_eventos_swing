package org.example.repository;

import org.example.database.SqliteConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaEventoRepository {
    PessoaEventoRepository(){
        createTable();
    }

    private void createTable() {
        try (Connection conn = SqliteConnection.connect();
             Statement stmt = conn.createStatement()) {

            String userEventsTableSql = "CREATE TABLE IF NOT EXISTS pessoa_eventos (\n"
                    + " pessoa_id INTEGER NOT NULL,\n"
                    + " evento_id INTEGER NOT NULL,\n"
                    + " PRIMARY KEY (pessoa_id, evento_id),\n"
                    + " FOREIGN KEY (pessoa_id) REFERENCES users(id),\n"
                    + " FOREIGN KEY (evento_id) REFERENCES events(id)\n"
                    + ");";

            stmt.execute(userEventsTableSql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addPessoaToEvento(int pessoaId, int eventoId) {
        String sql = "INSERT INTO pessoa_eventos(pessoa_id, evento_id) VALUES(?,?)";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pessoaId);
            pstmt.setInt(2, eventoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removePessoaFromEvento(int pessoaId, int eventoId) {
        String sql = "DELETE FROM pessoa_eventos WHERE pessoa_id = ? AND evento_id = ?";

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pessoaId);
            pstmt.setInt(2, eventoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> getEventosForPessoa(int pessoaId) {
        String sql = "SELECT evento_id FROM pessoa_eventos WHERE pessoa_id = ?";
        List<Integer> eventIds = new ArrayList<>();

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pessoaId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                eventIds.add(rs.getInt("evento_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return eventIds;
    }

    public List<Integer> getPessoasForEvento(int eventoId) {
        String sql = "SELECT pessoa_id FROM pessoa_eventos WHERE evento_id = ?";
        List<Integer> userIds = new ArrayList<>();

        try (Connection conn = SqliteConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventoId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                userIds.add(rs.getInt("pessoa_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userIds;
    }


}
