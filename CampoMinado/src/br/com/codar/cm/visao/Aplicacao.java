package br.com.codar.cm.visao;

import br.com.codar.cm.modelo.Tabuleiro;
 

public class Aplicacao {
	
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
	
		new TabuleiroConsole(tabuleiro);
		
		
	}

}
