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

        delete(API.BORRARCOCHE, CocheController::borrarCoche, new JsonTransformer<>());
        delete(API.BORRARMOTO, MotoController::borrarMoto, new JsonTransformer<>());
        delete(API.BORRARBICICLETA, BicicletaController::borrarBicicleta, new JsonTransformer<>());
        delete(API.BORRARPATINETE, PatineteController::borrarPatinete, new JsonTransformer<>());

        post(API.SELECCIONARCOCHE, CocheController::seleccionarCoche, new JsonTransformer<>());
        post(API.SELECCIONARMOTO, MotoController::seleccionarMoto, new JsonTransformer<>());
        post(API.SELECCIONARBICICLETA, BicicletaController::seleccionarBicicleta, new JsonTransformer<>());
        post(API.SELECCIONARPATINETE, PatineteController::seleccionarPatinete, new JsonTransformer<>());
    }
}

