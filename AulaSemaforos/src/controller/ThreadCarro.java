package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		carroAndando();
//		---------Inicio Se��o Cr�tica------
		try {
			semaforo.acquire();
			carroEstacionado();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
//		---------Fim Se��o Cr�tica---------
		carroSaindo();
	}
	
	private void carroAndando() {
		int distanciaTotal = (int) ((Math.random() * 1001) + 1000);
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCarro + " j� andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idCarro + " foi o " + posChegada + "o. a chegar");
	}
//  Math.random() gera um valor de 0 at� 0.99999999999...
//  De 0 a 1000
//  (Min) 0 * 1001 = 0 || (Max) 0.9999999... * 1001 = 1000.9999
							// Fazendo o casting pra (int) > 1000
//  De 1000 a 2000 > S� somar + 1000 (Ou seja, o m�nimo da sua classe de varia��o
	
	private void carroEstacionado() {
		System.out.println("#" + idCarro + " estacionou");
		int tempo = (int)((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 

	private void carroSaindo() {
		posSaida++;
		System.out.println("#" + idCarro + " foi o " + posSaida + "o. a sair.");
	}

}
