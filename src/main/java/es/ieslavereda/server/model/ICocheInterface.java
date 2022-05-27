package es.ieslavereda.server.model;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Result;

public interface ICocheInterface {
    Result<Coche> insertarCoche(Coche coche);
    Result<Coche> updatearCoche(Coche coche);
    Result<String> borrarCoche(String matricula);
    Result<Coche> seleccionarCoche(String matricula);
}
