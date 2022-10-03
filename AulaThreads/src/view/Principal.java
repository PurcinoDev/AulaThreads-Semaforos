package view;

import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
		
//		for (int idThread = 0 ; idThread < 5 ; idThread++) {

//			ThreadId threadId = new ThreadId(); < Está correto, mas:
			
//			Thread threadId = new ThreadID(idThread); 
			// Usamos esta forma para mostrar que uma classe que 
			// herda o tipo Thread da superclasse pode ser 
			// instanciada como a própria Thread em si.
			
//			threadId.start(); // Inicia uma thread
//		}
		
		int a = 10;
		int b = 2;
		
		for (int op = 0 ; op < 4 ; op++) {
			Thread tCalc = new ThreadCalc(a, b, op);
			tCalc.start();
		}
		
	}
}
