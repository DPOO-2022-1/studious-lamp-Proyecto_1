package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Impresora {

	public void CrearArch(String texto, String nombre) {

		try {

			String ruta = "./Data/" + nombre + ".txt";

			File file = new File(ruta);

			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
