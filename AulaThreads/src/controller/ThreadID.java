package controller;

// Características de uma Thread:
// extends Thread
// Parâmetros por construtor
// método run()

public class ThreadID extends Thread {
	
	private int idThread;
	
	public ThreadID(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		//Só se executa o que está aqui dentro
		System.out.println(idThread);
	}

}
