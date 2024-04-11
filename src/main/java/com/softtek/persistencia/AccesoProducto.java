package com.softtek.persistencia;

import com.softtek.modelo.Producto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoProducto extends Conexion {

    public List<Producto> obtenerTodos() throws ClassNotFoundException, SQLException {
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()) {
            productos.add(new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock")));
        }
        return productos;

    }

    public Producto obtenerId(int idProducto) throws ClassNotFoundException, SQLException {
        Statement sentencia;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products where product_id= " + idProducto;
        Producto prod = null;
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if (resultado.next()) {
            prod = new Producto(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock"));
        }
        return prod;
    }

    public boolean modificarId(int idProducto, String nombreProducto, Double precioUnitario, int unidadesStock) throws ClassNotFoundException, SQLException {
        Statement sentencia;
        String sql = "Update products set product_name='" + nombreProducto + "', unit_price=" + precioUnitario + ", units_in_stock=" + unidadesStock + " where product_id= " + idProducto;
        abrirConexion();
        sentencia = miConexion.createStatement();
        sentencia.executeQuery(sql);
        return true;
    }

    public boolean eliminarId(String nombreProducto) throws ClassNotFoundException, SQLException {
        Statement sentencia;
        String sql = "Delete from products where product_name= " + nombreProducto;
        abrirConexion();
        sentencia = miConexion.createStatement();
        sentencia.executeUpdate(sql);
        miConexion.close();
        return true;
    }

    public boolean insertar(int idProducto, String nombreProducto, Double precioUnitario, int unidadesStock, int discontinued) throws ClassNotFoundException, SQLException {
        Statement sentencia;
        String sql = "INSERT INTO products (product_id, product_name, unit_price, units_in_stock,discontinued) " +
                "VALUES " +
                "(" + idProducto + ", '" + nombreProducto + "', " + precioUnitario + ", " + unidadesStock + ", 0)";

        abrirConexion();
        sentencia = miConexion.createStatement();
        sentencia.executeQuery(sql);
        return true;
    }
}
