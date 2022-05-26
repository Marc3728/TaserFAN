package es.ieslavereda.model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {


    public List<Empleado> getPersonsora(){
        List<Empleado> personList = new ArrayList<>();
        DataSource dataSource = MyDataSource.getOracleDataSource();

        try(Connection con = dataSource.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from empleado")) {
            String DNI;
            String nombre;
            String apellidos;
            String email;
            String password;
            while (resultSet.next()){
                DNI = resultSet.getString("dni");
                nombre = resultSet.getString("nombre");
                apellidos = resultSet.getString("apellidos");
                email = resultSet.getString("email");
                password = resultSet.getString("password");

                personList.add(new Empleado(DNI,nombre,apellidos,email,password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return personList;
    }

    public Result<Empleado> authEmpleado(String email, String passwd){
        DataSource dataSource = MyDataSource.getOracleDataSource();

        try(Connection con = dataSource.getConnection();
            Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery("select count(*) from empleado where email like '"+
                    email+"' and password like ENCRYPT_PASWD.encrypt_val('"+ passwd + "')");

            rs.next();
            int count = rs.getInt(1);
            String DNI;
            String nombre;
            String apellidos;
            if (count==1){
                ResultSet resultSet = statement.executeQuery("select * from empleado where email like '"+email+"'");
                resultSet.next();
                DNI = resultSet.getString("dni");
                nombre = resultSet.getString("nombre");
                apellidos = resultSet.getString("apellidos");

                return new Result.Success<Empleado>(new Empleado(DNI,nombre,apellidos,email,passwd));

            } else {
                return new Result.Error("no has podido verificar a "+email,404);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
