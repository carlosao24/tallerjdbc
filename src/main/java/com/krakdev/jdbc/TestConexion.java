package com.krakdev.jdbc;

import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {
        try (Connection con = Conexion.getConnection()) {
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            System.out.println("No se pudo conectar: " + e.getMessage());
        }
    }
}