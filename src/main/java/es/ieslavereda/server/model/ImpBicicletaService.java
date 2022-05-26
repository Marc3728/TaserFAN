package es.ieslavereda.server.model;

import es.ieslavereda.model.Bicicleta;
import es.ieslavereda.model.MyDataSource;
import es.ieslavereda.model.Result;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ImpBicicletaService implements IBicicletaInterface {
    @Override
    public Result<Bicicleta> insertarBicicleta(Bicicleta bicicleta) {
        String sql = "{call gestionvehiculos.insertarbicicleta(?,?,?,?,?,?,?,?,?,?,?)}";
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
            cs.setDouble(10,bicicleta.getTamano());
            cs.setInt(11,bicicleta.getRuedas());

            cs.execute();

            return new Result.Success<Bicicleta>(bicicleta);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido anadir la bicicleta"+bicicleta.getMatricula(),404);
        }
    }

    @Override
    public Result<Bicicleta> updatearBicicleta(Bicicleta bicicleta) {
        String sql = "{call gestionvehiculos.actualizarBicicleta(?,?,?,?,?,?,?,?,?,?,?)}";
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
            cs.setDouble(10,bicicleta.getTamano());
            cs.setInt(11,bicicleta.getRuedas());

            cs.execute();

            return new Result.Success<Bicicleta>(bicicleta);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido actualizar la bicicleta"+bicicleta.getMatricula(),404);
        }
    }

    @Override
    public Result<Bicicleta> borrarBicicleta(String matricula) {
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
}
