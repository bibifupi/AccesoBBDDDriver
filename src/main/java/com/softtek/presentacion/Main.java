package com.softtek.presentacion;

import com.softtek.persistencia.AccesoProducto;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        /*Conexion c1 = new Conexion();
        try {
            c1.abrirConexion();
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/
        AccesoProducto aP1 = new AccesoProducto();


        System.out.println("\nObtener todos los productos: \n");
        try {
            System.out.println(aP1.obtenerTodos());
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }


        /*System.out.println("\nModificar un producto por su id: \n");
        try {
            System.out.println(aP1.modificarId(1, "Lola", 50.5, 9));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/
        System.out.println("\nEliminar un producto por su nombre: \n");
        try {
            System.out.println(aP1.eliminarId("Chang"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        /*System.out.println("\nInsertar un producto: \n");
        try {
            System.out.println(aP1.insertar(99, "Zelda", 99.99, 1,1));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }*/


        System.out.println("\nObtener un producto por su id: \n");
        try {
            System.out.println(aP1.obtenerId(2));
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
