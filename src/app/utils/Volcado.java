package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Volcado {
	private static Volcado volcado;
	private static BufferedWriter out = null;

	public static Volcado getInstance(){
		try {
			if(volcado == null || out == null ){
				volcado =  new Volcado();

				out = new BufferedWriter(new FileWriter("public/volcado.txt"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return volcado;
	}

	public void volcar(String... parametros){

		try {


			for(String s: parametros){
				out.write(s);
				out.write("\t");}
			out.flush();
			out.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
