package es.ieslavereda.server.model;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.Moto;
import es.ieslavereda.model.MyDataSource;
import es.ieslavereda.model.Result;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpMotoService implements IMotoInterface {
    @Override
    public Result<Moto> insertarMoto(Moto moto) {
        String sql = "{call gestionvehiculos.insertarmoto(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,moto.getMatricula());
            cs.setDouble(2,moto.getPreciohora());
            cs.setString(3,moto.getMarca());
            cs.setString(4,moto.getDescripcion());
            cs.setString(5,moto.getColor());
            cs.setDouble(6,moto.getBateria());
            cs.setString(7,moto.getFecha());
            cs.setString(8,moto.getEstado());
            cs.setString(9,moto.getTipocarnet());
            cs.setDouble(10,moto.getVelocidadmax());
            cs.setDouble(11,moto.getCilindrada());

            cs.execute();

            return new Result.Success<Moto>(moto);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido anadir la moto"+moto.getMatricula(),404);
        }
    }

    @Override
    public Result<Moto> updatearMoto(Moto moto) {
        String sql = "{call gestionvehiculos.actualizarMoto(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,moto.getMatricula());
            cs.setDouble(2,moto.getPreciohora());
            cs.setString(3,moto.getMarca());
            cs.setString(4,moto.getDescripcion());
            cs.setString(5,moto.getColor());
            cs.setDouble(6,moto.getBateria());
            cs.setString(7,moto.getFecha());
            cs.setString(8,moto.getEstado());
            cs.setString(9,moto.getTipocarnet());
            cs.setDouble(10,moto.getVelocidadmax());
            cs.setDouble(11,moto.getCilindrada());

            cs.execute();

            return new Result.Success<Moto>(moto);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido actualizar la moto"+moto.getMatricula(),404);
        }
    }

    @Override
    public Result<String> borrarMoto(String matricula) {
        String sql = "{call gestionvehiculos.borrarMoto(?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,matricula);

            cs.execute();

            return new Result.Success<String>(matricula);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido actualizar la moto"+matricula,404);
        }
    }

    @Override
    public Result<Moto> seleccionarMoto(String matricula) {
        String sql = "{call gestionvehiculos.consultarmoto(?,?,?,?,?,?,?,?,?,?,?)}";
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

            Moto moto = new Moto(matricula,cs.getDouble(2),cs.getString(3),cs.getString(4),cs.getString(5),cs.getDouble(6),cs.getString(7),cs.getString(8),cs.getString(9),cs.getDouble(10),cs.getDouble(11));


            return new Result.Success<Moto>(moto);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido seleccionar la moto"+matricula,404);
        }
    }
}
