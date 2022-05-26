package es.ieslavereda.server.controllers;

import es.ieslavereda.model.Empleado;
import es.ieslavereda.model.Result;
import es.ieslavereda.server.model.IEmpleadoInterface;
import es.ieslavereda.server.model.ImpEmpleadoService;
import es.ieslavereda.server.model.JsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
public class EmpleadoController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static JsonTransformer<Empleado> jsonTransformer=new JsonTransformer<>();
    private static IEmpleadoInterface service = new ImpEmpleadoService();

    public static Object authEmpleado(Request request, Response response) {
        logger.info("Add new person");
        Result<Empleado> result;
        String body = request.body();
        Empleado empleado = jsonTransformer.getObject(body,Empleado.class);
        result = service.auth(empleado);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }
}
