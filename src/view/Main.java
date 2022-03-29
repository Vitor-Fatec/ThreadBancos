package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBanco;

public class Main {

	public static void main(String[] args) {
	int permissoes= 1;
	Semaphore semaforo = new Semaphore(permissoes);
	
	for(int trans = 1; trans <= 20; trans++) {
		int saldo = (int)((Math.random() * 10000) * 100) / 100;
		Thread transacoes = new ThreadBanco(trans, semaforo, saldo);
		transacoes.start();
	}

	}

}
