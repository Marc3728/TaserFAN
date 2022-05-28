package es.ieslavereda.server.controllers;

import es.ieslavereda.model.Bicicleta;
import es.ieslavereda.model.Moto;
import es.ieslavereda.model.Result;
import es.ieslavereda.server.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class BicicletaController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static JsonTransformer<Bicicleta> jsonTransformerb=new JsonTransformer<>();
    private static IBicicletaInterface service = new ImpBicicletaService();

    public static Result<Bicicleta> insertarBicicleta(Request request, Response response){
        Result<Bicicleta> result;
        String body = request.body();
        Bicicleta bicicleta = jsonTransformerb.getObject(body,Bicicleta.class);
        logger.info(bicicleta.getMatricula());
        result = service.insertarBicicleta(bicicleta);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Bicicleta> updatearBicicleta(Request request, Response response){
        Result<Bicicleta> result;
        String body = request.body();
        Bicicleta bicicleta = jsonTransformerb.getObject(body,Bicicleta.class);
        logger.info(bicicleta.getMatricula());
        result = service.updatearBicicleta(bicicleta);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<String> borrarBicicleta(Request request, Response response){
        Result<String> result;
        String body = request.body();
        String bicicleta = request.queryParams("matricula");
        logger.info(bicicleta);
        result = service.borrarBicicleta(bicicleta);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Bicicleta> seleccionarBicicleta(Request request, Response response){
        Result<Bicicleta> result;
        String bicicleta = request.queryParams("matricula");
        logger.info(bicicleta);
        result = service.seleccionarBicicleta(bicicleta);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }
}
