package controller;

import java.util.concurrent.Semaphore;

public class ThreadBanco extends Thread{
	
	private int idtran;
	private Semaphore semaforo;
	private int opc;
	private int saldo;

	public ThreadBanco(int trans, Semaphore semaforo, int saldo) {
		this.idtran = trans;
		this.semaforo = semaforo;
		this.saldo = saldo;
	}
	
	@Override
	public void run() {
		opc = (int) (Math.random() * 2 ) + 1;
		try {
			semaforo.acquire();
			saque();
			deposito();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	
	}
		

	private void saque() {
		if(opc == 1) {
			
			System.out.println("====== OPERA��O "+idtran+" de saque ========================");
			System.out.println("Digite o c�digo da sua conta :  ");
			System.out.println("Digite o saldo da sua conta : ");
			System.out.println("Digite o valor que deseja sacar ; " + saldo);
			System.out.println("Obrigado por realziar seu saque");
		}	
	}

	private void deposito() {
		if(opc == 2) {
			
			System.out.println("====== OPERA��O "+idtran+" de dep�sito ========================");
			System.out.println("Digite o c�digo da sua conta :  ");
			System.out.println("Digite o saldo da sua conta : ");
			System.out.println("Digite o valor que deseja depositar ; " + saldo);
			System.out.println("Obrigado por realziar seu dep�sito");
		
		}	
	}

}
