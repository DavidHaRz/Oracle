package David.U4_DBOR_Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccesoOracle {
	private Connection con;
	void abrirConexion() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:56231:XE",
					"SYS as SYSDBA","1234");
			System.out.println("Conexion OK");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	void cerrarConexion() {
		try{
			System.out.println("Conexion cerrada");
			con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	void mostrarContactos() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("SELECT c.nombre, c.telefono FROM contactos c");
			System.out.println("INFORMACION DE CONTACTOS--------------");
			
			while(resul.next()){
				//aquí tambien podriamos poner resul.getInt("nif");
				System.out.printf("\nNOMBRE: %s\nTELEFONO: %s",
						resul.getString(1), resul.getString(2));
				}
				System.out.println("\n--------------");
				resul.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo mostrar la información");
			}
		}
	
	void crearTablaMisAlumnos() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("CREATE TABLE misAlumnos OF ESTUDIANTE");
			System.out.println("Tabla misAlumnos creada--------------");
				System.out.println("\n--------------");
				resul.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo crear la tabla misAlumnos");
			}
		}
			
	void insertarAlumnos() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("INSERT INTO misAlumnos VALUES(estudiante('03C', persona('David Horcajada','333333333')))");
			System.out.println("Estudiante insertado en la tabla misAlumnos--------------");
				System.out.println("\n--------------");
				resul.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo insertar el alumno");
			}
		}
	
	void eliminarAlumnos() {
		try {
			// Create a statement
			Statement st = con.createStatement();
			ResultSet resul = st.executeQuery("DELETE FROM misAlumnos WHERE ID_ESTUDIANTE = (estudiante('03C', persona('David Horcajada','333333333')))");
			System.out.println("Estudiante eliminado con exito--------------");
				System.out.println("\n--------------");
				resul.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo eliminar el alumno");
			}
		}
}
