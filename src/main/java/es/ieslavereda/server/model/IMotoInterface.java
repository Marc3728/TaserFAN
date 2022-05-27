package es.ieslavereda.server.model;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Moto;
import es.ieslavereda.model.Result;

public interface IMotoInterface {
    Result<Moto> insertarMoto(Moto moto);
    Result<Moto> updatearMoto(Moto moto);
    Result<String> borrarMoto(String matricula);
    Result<Moto> seleccionarMoto(String matricula);
}
