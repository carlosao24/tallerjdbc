package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateVehiculo {
	
	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.getConnection();
			
			String sql = """
					
					UPDATE vehiculos SET marca = ?, precio = ?, kilometraje = ?
					WHERE placa = ?
					
					""";
			ps = con.prepareStatement(sql);
			ps.setString(1, "Chevrolet Aveo Family");
			ps.setDouble(2, 8500.0);
			ps.setInt(3, 67904);
			ps.setString(4, "hbc-389");
			
			int filas = ps.executeUpdate();
			
			log.info("Filas actualizadas: " + filas);
			
		} catch(Exception e) {
			log.error("Error al actualizar vehículo: " + e.getMessage());
		} finally {
			try {
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}