package main;

import java.util.ArrayList;

import configuracion.LectorConfiguracion;
import implementaciones.ExportadorExcel;
import implementaciones.ExportadorTexto;
import interfaces.Exportador;

public class Main {
	private static Exportador exportador;

	public static void main(String[] args) {
		if (null == args || args.length == 0) {
			System.out.println("No existen datos para exportar");
		} else {
			try {
				ArrayList<Object> lista = new ArrayList<Object>();
				for (String arg : args[0].split(",")) {
					lista.add(arg);
				}
				if (LectorConfiguracion.formatoSalida().equals("xls")) {
					exportador = new ExportadorExcel();
				} else if (LectorConfiguracion.formatoSalida().equals("txt")) {
					exportador = new ExportadorTexto();
				}
				exportador.exportar(lista);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
