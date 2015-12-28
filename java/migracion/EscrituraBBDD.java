package migracion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EscrituraBBDD {
	DBConnection conn = null;
	PreparedStatement pst = null;
	// String sql = "INSERT INTO `persona` (`nombre`, `dni`, `observaciones`,
	// `email`) VALUES ( ?, ?, ?, ? );";
	String sql = "INSERT INTO `persona` (`nombre`, `observaciones`, `email`) VALUES ( ?, ?, ? );";
	int cont;

	public int insert(Persona p) throws SQLException {

		int resul = -1;

		pst.setString(1, p.getNombre() + " " + p.getApellido1() + " " + p.getApellido2());
		// pst.setString(2, p.getDni());
		pst.setString(2, p.getRol());
		pst.setString(3, p.getEmail());
		pst.execute();
		cont++;

		// System.out.println(cont);

		return resul;
	}

	public void open() throws SQLException {
		conn = new DBConnection();
		pst = conn.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		cont = 0;
	}

	public void close() throws SQLException {
		System.out.println("personas insertadas: " + cont);
		conn.desconectar();
		pst.close();
	}

}
