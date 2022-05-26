package es.ieslavereda.server.model;

import es.ieslavereda.model.*;

import java.util.List;

public interface IVehiculoInterface {
    List<Vehiculo> getAll();
    List<Vehiculo> getTipoVehiculo(TipoVehiculo tipo);
    Result<Coche> insertarCoche(Coche coche);
    Result<Moto> insertarMoto(Moto moto);
    Result<Bicicleta> insertarBici(Bicicleta bicicleta);
    Result<Patinete> insertarPatin(Patinete patinete);
}
