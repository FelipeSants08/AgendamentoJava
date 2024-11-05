package br.com.fiap.resource;

import br.com.fiap.bo.AgendamentoBO;
import br.com.fiap.to.AgendamentoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/agendamentos")
public class AgendamentoResource {

    private AgendamentoBO agendamentoBO = new AgendamentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<AgendamentoTO> resultado = agendamentoBO.findAll();
        if (resultado != null && !resultado.isEmpty()) {
            return Response.ok(resultado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        AgendamentoTO agendamento = agendamentoBO.findById(id);
        if (agendamento != null) {
            return Response.ok(agendamento).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(AgendamentoTO agendamento) {
        boolean created = agendamentoBO.insert(agendamento);
        if (created) {
            return Response.status(Response.Status.CREATED).entity(agendamento).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, AgendamentoTO agendamento) {
        agendamento.setId(id);
        boolean updated = agendamentoBO.update(agendamento);
        if (updated) {
            return Response.ok(agendamento).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = agendamentoBO.delete(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
