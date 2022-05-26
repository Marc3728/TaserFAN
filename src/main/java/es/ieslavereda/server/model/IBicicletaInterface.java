package es.ieslavereda.server.model;

import es.ieslavereda.model.Bicicleta;
import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Result;

public interface IBicicletaInterface {
    Result<Bicicleta> insertarBicicleta(Bicicleta bicicleta);
    Result<Bicicleta> updatearBicicleta(Bicicleta bicicleta);
    Result<Bicicleta> borrarBicicleta(String matricula);
}
