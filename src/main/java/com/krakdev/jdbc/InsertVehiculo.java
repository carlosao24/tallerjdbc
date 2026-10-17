package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {

	private static final Logger log = LogManager.getLogger(InsertVehiculo.class);

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = Conexion.getConnection();

			String sql = """
					INSERT INTO vehiculos(placa, marca, modelo, anio, precio, color, disponible, kilometraje)
					VALUES(?,?,?,?,?,?,?,?)
					""";
			ps = con.prepareStatement(sql);

			// --- Vehículo 1 ---
			ps.setString(1, "hbc-389");
			ps.setString(2, "chevrolet");
			ps.setString(3, "aveo");
			ps.setInt(4, 2018);
			ps.setDouble(5, 8000.0);
			ps.setString(6, "negro");
			ps.setBoolean(7, true);
			ps.setInt(8, 53000);
			ps.executeUpdate(); 

			// --- Vehículo 2 ---
			ps.setString(1, "pqr-123");
			ps.setString(2, "mazda");
			ps.setString(3, "cx-3");
			ps.setInt(4, 2021);
			ps.setDouble(5, 18500.0);
			ps.setString(6, "blanco");
			ps.setBoolean(7, true);
			ps.setInt(8, 153000);
			ps.executeUpdate(); 

			// --- Vehículo 3 ---
			ps.setString(1, "xyz-789");
			ps.setString(2, "toyota");
			ps.setString(3, "corolla");
			ps.setInt(4, 2020);
			ps.setDouble(5, 15000.0);
			ps.setString(6, "gris");
			ps.setBoolean(7, true);
			ps.setInt(8, 35573);
			ps.executeUpdate(); 

			// --- Vehículo 4 ---
			ps.setString(1, "abc-456");
			ps.setString(2, "hyundai");
			ps.setString(3, "accent");
			ps.setInt(4, 2019);
			ps.setDouble(5, 10500.0);
			ps.setString(6, "rojo");
			ps.setBoolean(7, false);
			ps.setInt(8, 763930);
			ps.executeUpdate(); 

			// --- Vehículo 5 ---
			ps.setString(1, "lmn-987");
			ps.setString(2, "kia");
			ps.setString(3, "sportage");
			ps.setInt(4, 2022);
			ps.setDouble(5, 22000.0);
			ps.setString(6, "azul");
			ps.setBoolean(7, true);
			ps.setInt(8, 34500);
			ps.executeUpdate();

			int filas = ps.executeUpdate();
			log.info("Filas insertadas " + filas);
		} catch (Exception e) {
			log.error("Error al insertar " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
