package es.ieslavereda.server.model;

import es.ieslavereda.model.Empleado;
import es.ieslavereda.model.Result;

import java.util.List;

public interface IEmpleadoInterface {
    List<Empleado> getAll();
    Result<Empleado> get(String dni);
    boolean update(Empleado empleado);
    Result<Empleado> delete(Empleado empleado);
    Result<Empleado> add(Empleado empleado);
    Result<Empleado> auth(Empleado empleado);
}
