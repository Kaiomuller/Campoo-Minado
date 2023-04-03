package br.com.codar.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.codar.cm.execao.ExplosaoException;

	public class CampoTeste {
		private Campo campo;
	
		@BeforeEach
		void iniciarCampo() {
		campo = new Campo(3, 3);
		}
	
	@Test
		void testeVizinhoReal() {
			Campo vizinho = new Campo (3, 2);
			boolean resultado = campo.adicionarVizinho(vizinho);
			assertTrue(resultado);
				

	}
	
	@Test
	void testePardaoAtribuidoMarcado() {
		assertFalse(campo.isMarcado());
		
	}
	
	@Test
	void testeAlterarMarcacao() {
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		campo.alternarMarcacao();
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class,  () -> {
			campo.abrir();
			});
	}
	
	@Test
	void testeAbrirComVizinho() {
		
		Campo vizinhoDovizinho1 = new Campo(1, 1);

		Campo vizinho1 = new Campo (2, 2);
		vizinho1.adicionarVizinho(vizinhoDovizinho1);
		
		campo.adicionarVizinho(vizinhoDovizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && vizinhoDovizinho1.isAberto());
		
	}
	@Test
	void testeAbrirComVizinho2() {
		
		Campo vizinhoDovizinho1 = new Campo(1, 1);
		Campo vizinhoDovizinho2 = new Campo(1, 1);
		vizinhoDovizinho2.minar();
		
		Campo vizinho1 = new Campo (2, 2);
		vizinho1.adicionarVizinho(vizinhoDovizinho1);
		vizinho1.adicionarVizinho(vizinhoDovizinho2);
		
		campo.adicionarVizinho(vizinhoDovizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && !vizinhoDovizinho1.isFechado());
		
	}
}
