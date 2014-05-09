package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Volcado {
	private static Volcado volcado;
	private static FileWriter fichero;
	private static PrintWriter pw;

	public static Volcado getInstance(){
		if(volcado == null)
			volcado = new Volcado();
		if(fichero == null && pw == null){
			try {
				fichero = new FileWriter("public/volcado.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			pw = new PrintWriter(fichero);
		}
		return volcado;
	}

	public void volcar(String... parametros){
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("public/volcado.txt");
			pw = new PrintWriter(fichero);
			for(String s: parametros){
				pw.write(s);
				pw.write("\n");}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fichero != null)
				try {
					fichero.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
