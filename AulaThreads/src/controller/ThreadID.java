package controller;

// Caracter�sticas de uma Thread:
// extends Thread
// Par�metros por construtor
// m�todo run()

public class ThreadID extends Thread {
	
	private int idThread;
	
	public ThreadID(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		//S� se executa o que est� aqui dentro
		System.out.println(idThread);
	}

}
