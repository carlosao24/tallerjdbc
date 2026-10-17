package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteVehiculo {
	
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = Conexion.getConnection();
			
			String sql = """
					DELETE FROM vehiculos WHERE placa = ?
					""";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "pqr-123");
			int filas1 = ps.executeUpdate();
			log.info("Se elimino correctamente: " + filas1);
			
			ps.setString(1, "abc-456");
			int filas2 = ps.executeUpdate();
			log.info("Se elimino correctamente: " + filas2);
			
		}catch(Exception e){
			log.error("Error al eliminar " + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}