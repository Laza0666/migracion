package migracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LecturaTxt {

	static EscrituraBBDD escritura = new EscrituraBBDD();

	public static void main(String[] arg) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] campos = null;
		int cont = 0;

		try {
			archivo = new File("C:\\Alumnos.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			escritura.open();
			while ((linea = br.readLine()) != null) {
				campos = linea.split(",");

				if (campos.length == 7) {
					Persona p = new Persona();
					p.setNombre(campos[0]);
					p.setApellido1(campos[1]);
					p.setApellido2(campos[2]);
					p.setEdad(Integer.parseInt(campos[3]));
					p.setEmail(campos[4]);
					p.setDni(campos[5]);
					p.setRol(campos[6]);
					escritura.insert(p);

				} else {
					cont++;
				}
			}
			System.out.println("descartados: " + cont);
			escritura.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
