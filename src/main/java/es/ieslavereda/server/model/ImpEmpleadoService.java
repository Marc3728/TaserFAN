package es.ieslavereda.server.model;

import es.ieslavereda.model.Empleado;
import es.ieslavereda.model.MyDataSource;
import es.ieslavereda.model.Result;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ImpEmpleadoService implements IEmpleadoInterface {

    @Override
    public List<Empleado> getAll() {
        return null;
    }

    @Override
    public Result<Empleado> get(String dni) {
        return null;
    }

    @Override
    public boolean update(Empleado person) {
        return false;
    }

    @Override
    public Result<Empleado> delete(Empleado person) {
        return null;
    }

    @Override
    public Result<Empleado> add(Empleado person) {
        return null;
    }

    @Override
    public Result<Empleado> auth(Empleado empleado) {
        DataSource dataSource = MyDataSource.getOracleDataSource();
        String sql = "select * from empleado where email=? and password like ENCRYPT_PASWD.encrypt_val(?)";

        try(Connection con = dataSource.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            int pos = 0;
            pstmt.setString(++pos,empleado.getEmail());
            pstmt.setString(++pos,empleado.getPassword());
            ResultSet rs = pstmt.executeQuery();

            String DNI;
            String nombre;
            String apellidos;
            if (rs.next()){
                DNI = rs.getString("dni");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");

                return new Result.Success<Empleado>(new Empleado(DNI,nombre,apellidos,empleado.getEmail(),empleado.getPassword()));
                //return new Result.Success<Empleado>(empleado);
            } else {
                return new Result.Error("no has podido verificar a "+empleado.getEmail(),404);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
