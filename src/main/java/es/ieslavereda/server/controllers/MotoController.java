package es.ieslavereda.server.controllers;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Moto;
import es.ieslavereda.model.Result;
import es.ieslavereda.server.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class MotoController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static JsonTransformer<Moto> jsonTransformerm=new JsonTransformer<>();
    private static IMotoInterface service = new ImpMotoService();

    public static Result<Moto> insertarMoto(Request request, Response response){
        Result<Moto> result;
        String body = request.body();
        Moto moto = jsonTransformerm.getObject(body,Moto.class);
        logger.info(moto.getMatricula());
        result = service.insertarMoto(moto);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Moto> updatearMoto(Request request, Response response){
        Result<Moto> result;
        String body = request.body();
        Moto moto = jsonTransformerm.getObject(body,Moto.class);
        logger.info(moto.getMatricula());
        result = service.updatearMoto(moto);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<String> borrarMoto(Request request, Response response){
        Result<String> result;
        String body = request.body();
        String moto = request.queryParams("matricula");
        logger.info(moto);
        result = service.borrarMoto(moto);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Moto> seleccionarMoto(Request request, Response response){
        Result<Moto> result;
        String moto = request.queryParams("matricula");
        logger.info(moto);
        result = service.seleccionarMoto(moto);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }
}
