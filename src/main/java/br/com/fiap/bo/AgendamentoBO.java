package br.com.fiap.bo;

import br.com.fiap.dao.AgendamentoDAO;
import br.com.fiap.to.AgendamentoTO;

import java.util.List;

public class AgendamentoBO {

    private AgendamentoDAO agendamentoDAO;

    public AgendamentoBO() {
        this.agendamentoDAO = new AgendamentoDAO();
    }

    public List<AgendamentoTO> findAll() {
        return agendamentoDAO.findAll();
    }

    public AgendamentoTO findById(Long id) {
        return agendamentoDAO.findById(id);
    }

    public boolean insert(AgendamentoTO agendamento) {
        return agendamentoDAO.insert(agendamento);
    }

    public boolean update(AgendamentoTO agendamento) {
        if (findById(agendamento.getId()) != null) {
            return agendamentoDAO.update(agendamento);
        }
        return false;
    }

    public boolean delete(Long id) {
        if (findById(id) != null) {
            return agendamentoDAO.delete(id);
        }
        return false;
    }
}
