package es.ieslavereda.server.controllers;

import es.ieslavereda.model.*;
import es.ieslavereda.server.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.List;

public class VehiculoController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static JsonTransformer<Empleado> jsonTransformer=new JsonTransformer<>();
    private static JsonTransformer<TipoVehiculo> jsonTransformerv=new JsonTransformer<>();
    private static JsonTransformer<Coche> jsonTransformerc=new JsonTransformer<>();
    private static JsonTransformer<Moto> jsonTransformerm=new JsonTransformer<>();
    private static JsonTransformer<Bicicleta> jsonTransformerb=new JsonTransformer<>();
    private static JsonTransformer<Patinete> jsonTransformerp=new JsonTransformer<>();
    private static IVehiculoInterface service = new ImpVehiculoService();

    public static Object getAll(Request request, Response response) {
        logger.info("get all vehicles");
        List<Vehiculo> result;
        result = service.getAll();
        return result;
    }

    public static Object getTipoVehiculo(Request request, Response response) {
        logger.info("get vehicles with type");
        List<Vehiculo> result;
        String body = request.body();
        TipoVehiculo tipo = jsonTransformerv.getObject(body, TipoVehiculo.class);
        result = service.getTipoVehiculo(tipo);
        return result;
    }

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

    public static Result<Bicicleta> insertarBicicleta(Request request, Response response){
        Result<Bicicleta> result;
        String body = request.body();
        Bicicleta bicicleta = jsonTransformerb.getObject(body,Bicicleta.class);
        logger.info(bicicleta.getMatricula());
        result = service.insertarBici(bicicleta);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }

    public static Result<Patinete> insertarPatinete(Request request, Response response){
        Result<Patinete> result;
        String body = request.body();
        Patinete patinete = jsonTransformerp.getObject(body,Patinete.class);
        logger.info(patinete.getMatricula());
        result = service.insertarPatin(patinete);

        if (result instanceof Result.Success){
            response.status(200);
        } else {
            response.status(404);
        }

        return result;
    }


}
