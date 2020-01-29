package implementaciones;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import interfaces.Exportador;

public class ExportadorExcel implements Exportador {
	
	public void exportar(List<Object> lista) {
		String fechaHoyString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		// Creamos el libro de trabajo de Excel
		HSSFWorkbook libro = new HSSFWorkbook();
		// Creamos la hoja de Excel
		HSSFSheet hoja = libro.createSheet();
		// Creamos las filas de Excel
		for (int i = 0; i < lista.size(); i++) {
//Casteamos el indice de la lista a String y luego parseamos el resultado a Integer
			Integer numero = Integer.parseInt((String) lista.get(i));
//creamos la fila
			HSSFRow fila = hoja.createRow(i);
//creamos la celda en la primera columna
			HSSFCell celda = fila.createCell((short) 0);
//Insertamos el numero en la celda
			celda.setCellValue(numero);
		}
//Exportamos el archivo
		try {
			FileOutputStream elFichero = new FileOutputStream("Valores_Sobrantes_" + fechaHoyString + "_.xls");
			libro.write(elFichero);
			elFichero.close();
			libro.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			libro.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
