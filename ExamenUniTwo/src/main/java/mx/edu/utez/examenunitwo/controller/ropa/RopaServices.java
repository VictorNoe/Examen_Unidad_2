package mx.edu.utez.examenunitwo.controller.ropa;

import mx.edu.utez.examenunitwo.model.clothes.BeanRopa;
import mx.edu.utez.examenunitwo.model.clothes.DaoRopa;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/ropa")
public class RopaServices {
    Map<String, Object> response = new HashMap<>();

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List <BeanRopa> getAll() {
        return new DaoRopa().findAll();
    }

    @POST
    @Path("/")
    @Produces(value = {"application/json"})
    public Map<String, Object> save(BeanRopa ropa) {
        Response<BeanRopa> result = new DaoRopa().save(ropa);
        response.put("result",result);
        return response;
    }
}
