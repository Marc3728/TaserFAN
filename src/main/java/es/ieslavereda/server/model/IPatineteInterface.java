package es.ieslavereda.server.model;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Patinete;
import es.ieslavereda.model.Result;

public interface IPatineteInterface {
    Result<Patinete> insertarPatinete(Patinete patinete);
    Result<Patinete> updatearPatinete(Patinete patinete);
    Result<Patinete> borrarPatinete(String matricula);
}
