/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Franco Valerio
 */
public class Conexion {

	static private Connection c = null; // Objeto de tipo coneccion donde se guardaran los datos de coneccion
	static private Statement stmt = null; // Objeto de tipo sentencia SQL
	static private ResultSet rs = null; // Objeto de tipo resultado Query SQL
	
	// CONSTRUCTOR
	public Conexion()  {
		
	}
        
	public static void crear() throws SQLException{
            try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AutoCar", "postgres", "12345");
			c.setAutoCommit(true);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			
		}
        }
//	public boolean ingresarDatosBD(Object objeto) throws SQLException {
//		if (c != null) {
//			// Si se creo la conexion a la BD exitosamente se continua
//			// Se crea una nueva sentencia SQL
//			stmt = c.createStatement();
//			String sql = "INSERT INTO tabla1 (atributo1,atributo2)" 
//			    + "VALUES ('" + empresa.getNombre() + "','" + empresa.getRut() + "');";
//			stmt.executeUpdate(sql);
//			cerrarDatabase();
//			return true;
//		} else
//			return false;
//		// Si no se pudo establecer la conexion a la BD se retorna null;
//	}

	public static Object[][] leerDatosBD() throws SQLException {
            int contador = 0;
            Object[][] ob = new Object[contar("clientes")][8];
		if (c != null) {
			// Si se creo la conexion a la BD exitosamente se continua
			// Se crea una nueva sentencia SQL
			stmt = c.createStatement();
			// Se ejecuta la sentencia SQL y se guarda
			rs = stmt.executeQuery("SELECT * FROM clientes");
			if (rs == null){
				// Si no hay nada en la tabla retorna null
				
				
			}
			else {
				while (rs.next()){
                                    ob[contador][0] = rs.getString("cedula");
                                    ob[contador][1] = rs.getString("nombre");
                                    ob[contador][2] = rs.getString("direccion");
                                    ob[contador][3] = rs.getString("correo");
                                    ob[contador][4] = rs.getString("telefono");
                                    ob[contador][5] = rs.getString("ciudad");
                                     
                                    contador++;
                                }
                                    
                                    
				
				// Se retorna toda la coleccion
				return ob;
			}
		} else{
                   
                }
		 return null;	
			
	}
        public static int contar(String tabla) throws SQLException {
            int contador=0;
		if (c != null) {
			// Si se creo la conexion a la BD exitosamente se continua
			// Se crea una nueva sentencia SQL
			stmt = c.createStatement();
			// Se ejecuta la sentencia SQL y se guarda
			rs = stmt.executeQuery("SELECT * FROM "+tabla);
			if (rs == null){
				// Si no hay nada en la tabla retorna null
				
				
			}
			else {
				while (rs.next())
                                 contador++;
				
				// Se retorna toda la coleccion
			}
                        return contador;
		} else{
                
                }
			
		return -1;	
	}
	
	
	public boolean eliminarDatosBD(String clave) throws SQLException {
		String sql;
		if (c != null) {
			// Si se creo la conexion a la BD exitosamente se continua
			// Se crea una nueva sentencia SQL
			stmt = c.createStatement();
			sql = "DELETE FROM tabla1 WHERE (atributo1 = '" + clave + "');";
			stmt.executeUpdate(sql);
			stmt.close();
			cerrarDatabase();
			return true;
		} else
			return false;
		// Si no se pudo establecer la conexion a la BD se retorna null;
	}

	/**
	 * Cierra la coneccion con la BD
	 */
	public static void cerrarDatabase() throws SQLException {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		// Se cierra conexion a la BD
		c.close();
	}
}