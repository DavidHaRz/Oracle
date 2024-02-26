package David.U4_DBOR_Oracle;

public class UsaAccesoOracle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesoOracle a = new AccesoOracle();
		a.abrirConexion();
		//a.mostrarContactos();
		//a.crearTablaMisAlumnos();
		//a.insertarAlumnos();
		a.eliminarAlumnos();
		a.cerrarConexion();
	}
}
