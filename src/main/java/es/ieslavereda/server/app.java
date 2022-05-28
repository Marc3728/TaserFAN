package es.ieslavereda.server;
import es.ieslavereda.server.controllers.*;
import es.ieslavereda.server.model.JsonTransformer;
import static spark.Spark.*;
public class app {
    public static void main(String[] args) {
        //get(API.ALL_PERSON, EmpleadoController::getPersons, new JsonTransformer<>());
        //get(API.PERSON, EmpleadoController::getPerson,new JsonTransformer<>());
        //post(API.PERSON, EmpleadoController::addPerson, new JsonTransformer<>());
        get(API.AUTH, EmpleadoController::authEmpleado, new JsonTransformer<>());
        post(API.AUTH, EmpleadoController::authEmpleado, new JsonTransformer<>());
        get(API.VEHICULOS, VehiculoController::getAll, new JsonTransformer<>());
        post(API.TIPOVEHICULO, VehiculoController::getTipoVehiculo, new JsonTransformer<>());
        post(API.COCHE, CocheController::insertarCoche, new JsonTransformer<>());
        post(API.MOTO, MotoController::insertarMoto, new JsonTransformer<>());
        post(API.BICICLETA, BicicletaController::insertarBicicleta, new JsonTransformer<>());
        post(API.PATINETE, PatineteController::insertarPatinete, new JsonTransformer<>());

        put(API.COCHE, CocheController::updatearCoche, new JsonTransformer<>());
        put(API.MOTO, MotoController::updatearMoto, new JsonTransformer<>());
        put(API.BICICLETA, BicicletaController::updatearBicicleta, new JsonTransformer<>());
        put(API.PATINETE, PatineteController::updatearPatinete, new JsonTransformer<>());

        delete(API.COCHE, CocheController::borrarCoche, new JsonTransformer<>());
        delete(API.MOTO, MotoController::borrarMoto, new JsonTransformer<>());
        delete(API.BICICLETA, BicicletaController::borrarBicicleta, new JsonTransformer<>());
        delete(API.PATINETE, PatineteController::borrarPatinete, new JsonTransformer<>());

        get(API.COCHE, CocheController::seleccionarCoche, new JsonTransformer<>());
        get(API.MOTO, MotoController::seleccionarMoto, new JsonTransformer<>());
        get(API.BICICLETA, BicicletaController::seleccionarBicicleta, new JsonTransformer<>());
        get(API.PATINETE, PatineteController::seleccionarPatinete, new JsonTransformer<>());
    }
}

