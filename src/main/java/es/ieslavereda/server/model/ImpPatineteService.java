package es.ieslavereda.server.model;

import es.ieslavereda.model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpPatineteService implements IPatineteInterface {
    @Override
    public Result<Patinete> insertarPatinete(Patinete patinete) {
        String sql = "{call gestionvehiculos.insertarpatinete(?,?,?,?,?,?,?,?,?,?,?)}";
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
            cs.setDouble(10,patinete.getTamano());
            cs.setInt(11,patinete.getRuedas());

            cs.execute();

            return new Result.Success<Patinete>(patinete);


        } catch (SQLException throwables) {
            return new Result.Error(throwables.getMessage(),throwables.getErrorCode());
        }
    }

    @Override
    public Result<Patinete> updatearPatinete(Patinete patinete) {


        String sql = "{call gestionvehiculos.actualizarPatinete(?,?,?,?,?,?,?,?,?,?,?)}";
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
            cs.setDouble(10,patinete.getTamano());
            cs.setInt(11,patinete.getRuedas());

            cs.execute();

            return new Result.Success<Patinete>(patinete);


        } catch (SQLException throwables) {
            return new Result.Error(throwables.getMessage(),throwables.getErrorCode());
        }
    }

    @Override
    public Result<String> borrarPatinete(String matricula) {
        String sql = "{call gestionvehiculos.borrarPatinete(?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,matricula);

            cs.execute();

            return new Result.Success<String>(matricula);


        } catch (SQLException throwables) {
            return new Result.Error(throwables.getMessage(),throwables.getErrorCode());
        }
    }

    @Override
    public Result<Patinete> seleccionarPatinete(String matricula) {


        String sql = "{call gestionvehiculos.consultarpatinete(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,matricula);
            cs.registerOutParameter(2, Types.NUMERIC);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.NUMERIC);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.registerOutParameter(8, Types.VARCHAR);
            cs.registerOutParameter(9, Types.VARCHAR);
            cs.registerOutParameter(10, Types.NUMERIC);
            cs.registerOutParameter(11, Types.NUMERIC);

            cs.execute();

            Patinete patinete = new Patinete(matricula,cs.getDouble(2),cs.getString(3),cs.getString(4),cs.getString(5),cs.getDouble(6),cs.getString(7),cs.getString(8),cs.getString(9),cs.getDouble(10),cs.getInt(11));


            return new Result.Success<Patinete>(patinete);


        } catch (SQLException throwables) {
            return new Result.Error(throwables.getMessage(),throwables.getErrorCode());
        }
    }
}
