package es.ieslavereda.server.controllers;

import es.ieslavereda.model.Moto;
import es.ieslavereda.model.Patinete;
import es.ieslavereda.model.Result;
import es.ieslavereda.server.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class PatineteController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static JsonTransformer<Patinete> jsonTransformerp=new JsonTransformer<>();
    private static IPatineteInterface service = new ImpPatineteService();

    public static Result<Patinete> insertarPatinete(Request request, Response response){
        Result<Patinete> result;
        String body = request.body();
        Patinete patinete = jsonTransformerp.getObject(body,Patinete.class);
        logger.info(patinete.getMatricula());
        result = service.insertarPatinete(patinete);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Patinete> updatearPatinete(Request request, Response response){
        Result<Patinete> result;
        String body = request.body();
        Patinete patinete = jsonTransformerp.getObject(body,Patinete.class);
        logger.info(patinete.getMatricula());
        result = service.updatearPatinete(patinete);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }
}
