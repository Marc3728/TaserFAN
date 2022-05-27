package es.ieslavereda.server.model;

import es.ieslavereda.model.Coche;
import es.ieslavereda.model.MyDataSource;
import es.ieslavereda.model.Result;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpCocheService implements ICocheInterface {
    @Override
    public Result<Coche> insertarCoche(Coche coche) {
        String sql = "{call gestionvehiculos.insertarcoche(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,coche.getMatricula());
            cs.setDouble(2,coche.getPreciohora());
            cs.setString(3,coche.getMarca());
            cs.setString(4,coche.getDescripcion());
            cs.setString(5,coche.getColor());
            cs.setDouble(6,coche.getBateria());
            cs.setString(7,coche.getFecha());
            cs.setString(8,coche.getEstado());
            cs.setString(9,coche.getTipocarnet());
            cs.setInt(10,coche.getNumplazas());
            cs.setInt(11,coche.getNumpuertas());

            cs.execute();


            return new Result.Success<Coche>(coche);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido anadir el coche"+coche.getMatricula(),404);
        }
    }

    @Override
    public Result<Coche> updatearCoche(Coche coche) {
        String sql = "{call gestionvehiculos.actualizarCoche(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,coche.getMatricula());
            cs.setDouble(2,coche.getPreciohora());
            cs.setString(3,coche.getMarca());
            cs.setString(4,coche.getDescripcion());
            cs.setString(5,coche.getColor());
            cs.setDouble(6,coche.getBateria());
            cs.setString(7,coche.getFecha());
            cs.setString(8,coche.getEstado());
            cs.setString(9,coche.getTipocarnet());
            cs.setInt(10,coche.getNumplazas());
            cs.setInt(11,coche.getNumpuertas());

            cs.execute();


            return new Result.Success<Coche>(coche);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido actualizar el coche"+coche.getMatricula(),404);
        }
    }

    @Override
    public Result<String> borrarCoche(String matricula) {
        String sql = "{call gestionvehiculos.borrarcoche(?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {


            cs.setString(1,matricula);

            cs.execute();


            return new Result.Success<String>(matricula);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido borrar el coche"+matricula,404);
        }
    }

    @Override
    public Result<Coche> seleccionarCoche(String matricula) {
        String sql = "{call gestionvehiculos.consultarcoche(?,?,?,?,?,?,?,?,?,?,?)}";
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

            Coche coche = new Coche(matricula,cs.getDouble(2),cs.getString(3),cs.getString(4),cs.getString(5),cs.getDouble(6),cs.getString(7),cs.getString(8),cs.getString(9),cs.getInt(10),cs.getInt(11));


            return new Result.Success<Coche>(coche);


        } catch (SQLException throwables) {
            return new Result.Error("no has podido seleccionar el coche"+matricula,404);
        }
    }
}
