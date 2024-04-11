package com.softtek.presentacion;

import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoProducto;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProbarStream {

    public static void main(String[] args) {
        AccesoProducto ap1 = new AccesoProducto();

        try {
            obtenerCategoria2(ap1);
            //obtenerComienzoN(ap1);
            //obtenerPorNombre(ap1);
            //obtenerPrecioMax(ap1);
            //obtenerMedia(ap1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1. Obtener los productos cuya categoría sea 2
    public static void obtenerCategoria2(AccesoProducto ap1) throws SQLException, ClassNotFoundException {

        Predicate<Producto> obtenerCategoria = x -> x.getCategoria() == 2;

        ap1.obtenerTodos().stream()
                .filter(obtenerCategoria)
                .forEach(System.out::println);
    }

    //2. Obtener los productos que comiencen con N
    public static void obtenerComienzoN(AccesoProducto ap1) throws SQLException, ClassNotFoundException {
        Predicate<Producto> obtenerComienzo = x -> x.getNombreProducto().startsWith("N");

        ap1.obtenerTodos().stream()
                .filter(obtenerComienzo)
                .forEach(System.out::println);

    }

    //3. Ordenar los productos de forma ascendente por nombre de producto
    public static void obtenerPorNombre(AccesoProducto ap1) throws SQLException, ClassNotFoundException {
        List<Producto> productosOrdenados = ap1.obtenerTodos().stream()
                .sorted(Comparator.comparing(Producto::getNombreProducto))
                .collect(Collectors.toList());

        productosOrdenados.forEach(System.out::println);
    }

    //4. Obtener el producto con el precio máximo
    public static void obtenerPrecioMax(AccesoProducto ap1) throws SQLException, ClassNotFoundException {
        double max = ap1.obtenerTodos().stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .max()
                .orElse(0);

        double min = ap1.obtenerTodos().stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .min()
                .orElse(0);

        Producto producto = ap1.obtenerTodos().stream()
                .max(Comparator.comparing(Producto::getPrecioUnitario))
                .orElse(new Producto());

        System.out.println(producto);
    }

    //5. Obtener el promedio del precio de producto
    public static void obtenerMedia(AccesoProducto ap1) throws SQLException, ClassNotFoundException {
        double precioMedia = ap1.obtenerTodos().stream()
                .mapToDouble(Producto::getPrecioUnitario)
                .average()
                .orElse(0.0);


        System.out.println(precioMedia);
    }
//7. Obtener las categorías y la cantidad de productos
}

