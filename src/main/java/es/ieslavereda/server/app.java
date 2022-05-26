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
        post(API.INSERTARCOCHE, CocheController::insertarCoche, new JsonTransformer<>());
        post(API.INSERTARMOTO, MotoController::insertarMoto, new JsonTransformer<>());
        post(API.INSERTARBICICLETA, BicicletaController::insertarBicicleta, new JsonTransformer<>());
        post(API.INSERTARPATINETE, PatineteController::insertarPatinete, new JsonTransformer<>());

        post(API.UPDATEARCOCHE, CocheController::updatearCoche, new JsonTransformer<>());
        post(API.UPDATEARMOTO, MotoController::updatearMoto, new JsonTransformer<>());
        post(API.UPDATEARBICICLETA, BicicletaController::updatearBicicleta, new JsonTransformer<>());
        post(API.UPDATEARPATINETE, PatineteController::updatearPatinete, new JsonTransformer<>());
    }
}

