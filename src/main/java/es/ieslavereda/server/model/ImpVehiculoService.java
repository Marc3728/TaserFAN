package es.ieslavereda.server.model;

import es.ieslavereda.model.*;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpVehiculoService implements IVehiculoInterface {
    @Override
    public List<Vehiculo> getAll() {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : getTipoVehiculo(TipoVehiculo.COCHE)){
            lista.add(v);
        }
        for (Vehiculo v : getTipoVehiculo(TipoVehiculo.MOTO)){
            lista.add(v);
        }
        for (Vehiculo v : getTipoVehiculo(TipoVehiculo.BICICLETA)){
            lista.add(v);
        }
        for (Vehiculo v : getTipoVehiculo(TipoVehiculo.PATINETE)){
            lista.add(v);
        }
        return lista;
    }

    @Override
    public List<Vehiculo> getTipoVehiculo(TipoVehiculo tipo) {
        List<Vehiculo> lista = new ArrayList();
        String sql = "{call gestionvehiculos.listarvehiculos(?,?)}";
        try(Connection con = MyDataSource.getOracleDataSource().getConnection();
            CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1,tipo.toString());
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()){
                lista.add(new Vehiculo(rs.getString("c2"),rs.getString("c1"),rs.getString("c6"),rs.getString("c4"),tipo));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lista;
    }

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
    public Result<Bicicleta> insertarBici(Bicicleta bicicleta) {
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
    public Result<Patinete> insertarPatin(Patinete patinete) {
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


}
