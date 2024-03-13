package controller;

public class Sapo extends Thread {

	private static int saposTerminaram = 0;
	private static int count = 0;

	private int id;
	private int pulo;
	private int distMax = 100;
	private int dist;
	private int colocacao;

	public Sapo() {
		id = ++count;
	}

	@Override
	public void run() {
		iniciarCorrida();
	}

	private void iniciarCorrida() {
		while (dist < distMax) {
			pulo = (int) (Math.random() * 10);
			dist += pulo;
			System.out.println("Sapo: " + currentThread().getId() + " pulou " + pulo + " centímetros e já percorreu: "
					+ dist + " centímetros");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		saposTerminaram++;
		colocacao = saposTerminaram;
		System.out.println("Sapo " + id + " terminou na posição: " + colocacao);
	}
}
