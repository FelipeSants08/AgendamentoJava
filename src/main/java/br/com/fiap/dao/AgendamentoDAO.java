package br.com.fiap.dao;

import br.com.fiap.to.AgendamentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO extends Repository {

    public List<AgendamentoTO> findAll() {
        List<AgendamentoTO> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos ORDER BY id";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AgendamentoTO agendamento = new AgendamentoTO();
                agendamento.setId(rs.getLong("id"));
                agendamento.setCarro(rs.getString("carro"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setDataAgendamento(rs.getDate("data_agendamento").toLocalDate());
                agendamento.setDescricaoProblema(rs.getString("descricao_problema"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar agendamentos: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamentos;
    }

    public AgendamentoTO findById(Long id) {
        AgendamentoTO agendamento = null;
        String sql = "SELECT * FROM agendamentos WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                agendamento = new AgendamentoTO();
                agendamento.setId(rs.getLong("id"));
                agendamento.setCarro(rs.getString("carro"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setDataAgendamento(rs.getDate("data_agendamento").toLocalDate());
                agendamento.setDescricaoProblema(rs.getString("descricao_problema"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar agendamento por ID: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return agendamento;
    }

    public boolean insert(AgendamentoTO agendamento) {
        String sql = "INSERT INTO agendamentos (carro, cliente, data_agendamento, descricao_problema) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, agendamento.getCarro());
            ps.setString(2, agendamento.getCliente());
            ps.setDate(3, java.sql.Date.valueOf(agendamento.getDataAgendamento()));
            ps.setString(4, agendamento.getDescricaoProblema());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir agendamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(AgendamentoTO agendamento) {
        String sql = "UPDATE agendamentos SET carro = ?, cliente = ?, data_agendamento = ?, descricao_problema = ? WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, agendamento.getCarro());
            ps.setString(2, agendamento.getCliente());
            ps.setDate(3, java.sql.Date.valueOf(agendamento.getDataAgendamento()));
            ps.setString(4, agendamento.getDescricaoProblema());
            ps.setLong(5, agendamento.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar agendamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM agendamentos WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar agendamento: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }
}

