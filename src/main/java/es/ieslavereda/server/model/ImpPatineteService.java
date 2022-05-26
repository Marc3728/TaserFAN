package es.ieslavereda.server.model;

import es.ieslavereda.model.MyDataSource;
import es.ieslavereda.model.Patinete;
import es.ieslavereda.model.Result;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ImpPatineteService implements IPatineteInterface {
    @Override
    public Result<Patinete> insertarPatinete(Patinete patinete) {
        String sql = "{call gestionvehiculos.insertarpatinete(?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,patinete.getMatricula());
            cs.setDouble(2,patinete.getPreciohora());
            cs.setString(3,patinete.getMarca());
            cs.setString(4,patinete.getDescripcion());
            cs.setString(5,patinete.getColor());
            cs.setDouble(6,patinete.getBateria());
            cs.setString(7,patinete.getFecha());
            cs.setString(8,patinete.getEstado());
            cs.setString(9,patinete.getTipocarnet());
            cs.setString(10,patinete.getTipo());

            cs.execute();

            return new Result.Success<Patinete>(patinete);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido anadir el patinete"+patinete.getMatricula(),404);
        }
    }

    @Override
    public Result<Patinete> updatearPatinete(Patinete patinete) {
        String sql = "{call gestionvehiculos.actualizarPatinete(?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,patinete.getMatricula());
            cs.setDouble(2,patinete.getPreciohora());
            cs.setString(3,patinete.getMarca());
            cs.setString(4,patinete.getDescripcion());
            cs.setString(5,patinete.getColor());
            cs.setDouble(6,patinete.getBateria());
            cs.setString(7,patinete.getFecha());
            cs.setString(8,patinete.getEstado());
            cs.setString(9,patinete.getTipocarnet());
            cs.setString(10,patinete.getTipo());

            cs.execute();

            return new Result.Success<Patinete>(patinete);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido actualizar el patinete"+patinete.getMatricula(),404);
        }
    }

    @Override
    public Result<Patinete> borrarPatinete(String matricula) {
        String sql = "{call gestionvehiculos.borrarPatinete(?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,matricula);

            cs.execute();

            return new Result.Success<String>(matricula);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido borrar el patinete"+matricula,404);
        }
    }
}
