package es.ieslavereda.server.model;

import es.ieslavereda.model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpBicicletaService implements IBicicletaInterface {
    @Override
    public Result<Bicicleta> insertarBicicleta(Bicicleta bicicleta) {



        String sql = "{call gestionvehiculos.insertarbicicleta(?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,bicicleta.getMatricula());
            cs.setDouble(2,bicicleta.getPreciohora());
            cs.setString(3,bicicleta.getMarca());
            cs.setString(4,bicicleta.getDescripcion());
            cs.setString(5,bicicleta.getColor());
            cs.setDouble(6,bicicleta.getBateria());
            cs.setString(7,bicicleta.getFecha());
            cs.setString(8,bicicleta.getEstado());
            cs.setString(9,bicicleta.getTipocarnet());
            cs.setString(10,bicicleta.getTipo());

            cs.execute();

            return new Result.Success<Bicicleta>(bicicleta);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido anadir el patinete"+bicicleta.getMatricula(),404);
        }
    }

    @Override
    public Result<Bicicleta> updatearBicicleta(Bicicleta bicicleta) {
        String sql = "{call gestionvehiculos.actualizarBicicleta(?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,bicicleta.getMatricula());
            cs.setDouble(2,bicicleta.getPreciohora());
            cs.setString(3,bicicleta.getMarca());
            cs.setString(4,bicicleta.getDescripcion());
            cs.setString(5,bicicleta.getColor());
            cs.setDouble(6,bicicleta.getBateria());
            cs.setString(7,bicicleta.getFecha());
            cs.setString(8,bicicleta.getEstado());
            cs.setString(9,bicicleta.getTipocarnet());
            cs.setString(10,bicicleta.getTipo());

            cs.execute();

            return new Result.Success<Bicicleta>(bicicleta);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido actualizar el patinete"+bicicleta.getMatricula(),404);
        }
    }

    @Override
    public Result<String> borrarBicicleta(String matricula) {
        String sql = "{call gestionvehiculos.borrarBicicleta(?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,matricula);

            cs.execute();

            return new Result.Success<String>(matricula);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido borrar la bicicleta"+matricula,404);
        }
    }

    @Override
    public Result<Bicicleta> seleccionarBicicleta(String matricula) {
        String sql = "{call gestionvehiculos.consultarbicicleta(?,?,?,?,?,?,?,?,?,?)}";
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
            cs.registerOutParameter(10, Types.VARCHAR);

            cs.execute();

            Bicicleta bicicleta = new Bicicleta(matricula,cs.getDouble(2),cs.getString(3),cs.getString(4),cs.getString(5),cs.getDouble(6),cs.getString(7),cs.getString(8),cs.getString(9),cs.getString(10));


            return new Result.Success<Bicicleta>(bicicleta);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido seleccionar la bicicleta"+matricula,404);
        }
    }
}
