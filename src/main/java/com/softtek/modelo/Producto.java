package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int unidadesStock;
}
