package es.ieslavereda.server.controllers;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Result;
import es.ieslavereda.server.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class CocheController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static JsonTransformer<Coche> jsonTransformerc=new JsonTransformer<>();
    private static ICocheInterface service = new ImpCocheService();

    public static Result<Coche> insertarCoche(Request request, Response response){
        Result<Coche> result;
        String body = request.body();
        Coche coche = jsonTransformerc.getObject(body,Coche.class);
        logger.info(coche.getMatricula());
        result = service.insertarCoche(coche);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Coche> updatearCoche(Request request, Response response){
        Result<Coche> result;
        String body = request.body();
        Coche coche = jsonTransformerc.getObject(body,Coche.class);
        logger.info(coche.getMatricula());
        result = service.updatearCoche(coche);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Coche> borrarCoche(Request request, Response response){
        Result<Coche> result;
        String body = request.body();
        String coche = request.queryParams("matricula");
        logger.info(coche);
        result = service.borrarCoche(coche);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }
}
