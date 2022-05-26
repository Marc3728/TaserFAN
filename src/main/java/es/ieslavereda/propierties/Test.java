package es.ieslavereda.propierties;

import es.ieslavereda.model.Model;

public class Test {
    public static void main(String[] args) {


        Model model = new Model();
        System.out.println(model.getPersonsora());
        System.out.println(model.authEmpleado("pepa@mordor.es","1111"));
    }
}
