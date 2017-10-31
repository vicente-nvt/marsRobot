package br.com.mars.test.implantacao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mars.business.implantacao.ImplantacaoDeRobos;

public class TestImplantacaoDeRobo {
		
	@Test
	public void implantarRoboMovimentoEsquerda(){
		
		String planalto = "5,5";
		String posicaoRobo = "1,2,N";
		String comandosRobo = "LMLMLMLMM";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
		
		assertEquals(implantacao.implantarEMoverRobo(planalto, posicaoRobo, comandosRobo),"(1,3,N)");
	}

	@Test
	public void implantarRoboMovimentoDireita(){
		
		String planalto = "6,6";
		String posicaoRobo = "3,3,E";
		String comandosRobo = "MMRMMRMRRM";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
		
		assertEquals(implantacao.implantarEMoverRobo(planalto, posicaoRobo, comandosRobo),"(5,1,E)");
	}
	
	@Test 
	public void implantarRoboRotacaoParaDireita(){

		String planalto = "5,5";
		String posicaoRobo = "0,0,N";
		String comandosRobo = "MMRMMRMM";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
		
		assertEquals(implantacao.implantarEMoverRobo(planalto, posicaoRobo, comandosRobo),"(2,0,S)");
		
	}

	@Test 
	public void implantarRoboRotacaoParaEsquerda(){

		String planalto = "5,5";
		String posicaoRobo = "0,0,N";
		String comandosRobo = "MML";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
		
		assertEquals(implantacao.implantarEMoverRobo(planalto, posicaoRobo, comandosRobo),"(0,2,W)");
		
	}	
	
	@Test 
	public void implantarRoboComandoInvalido(){

		String planalto = "5,5";
		String posicaoRobo = "0,0,N";
		String comandosRobo = "AAA";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
		
		assertEquals(implantacao.implantarEMoverRobo(planalto, posicaoRobo, comandosRobo),"E002");
		
	}	
	
	@Test
	public void implantarRoboComMovimentoAlemDoLimite(){

		String planalto = "5,5";
		String posicaoRobo = "0,0,N";
		String comandosRobo = "MMMMMMMMMMMMMMMMMMMMMMMM";
	
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos();
		
		assertEquals(implantacao.implantarEMoverRobo(planalto, posicaoRobo, comandosRobo),"E003");
		
	}
	
	
}
