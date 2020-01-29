package implementaciones;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import interfaces.Exportador;

public class ExportadorTexto implements Exportador {

	public void exportar(List<Object> lista) {
		try {
			String fechaHoyString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			PrintWriter writer = new PrintWriter("Valores_Sobrantes_" + fechaHoyString + "_.txt", "UTF-8");
			for (Object textObject : lista) {
				String text = (String) textObject;
				writer.println(text);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}