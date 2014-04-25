package persistence;

import java.io.File;
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
				fichero = new FileWriter("C:/Users/Lara/Desktop/Tercero/prueba.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
			fichero = new FileWriter("C:/Users/Lara/Desktop/Tercero/prueba.txt");
			pw = new PrintWriter(fichero);
			for(String s: parametros){
				pw.write(s);
				pw.write("\n");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fichero != null)
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
