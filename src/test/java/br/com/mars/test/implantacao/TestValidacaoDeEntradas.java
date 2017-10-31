package br.com.mars.test.implantacao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.business.implantacao.ValidacaoDeEntradas;
import br.com.mars.entities.implantacao.IValidacaoDeEntradas;

public class TestValidacaoDeEntradas {

	private String comandoDeDimensaoDoPlanalto = "5,5";
	private String comandoDePosicaoDaRobo = "0,0,N";
	private String comandoDeMovimentoDaRobo = "MMRMMRMRRM";
	
	private IValidacaoDeEntradas validacaoEntrada;
	
	@Before
	public void criarValidacaoDeRobo(){
		validacaoEntrada = new ValidacaoDeEntradas(comandoDeDimensaoDoPlanalto, 
												   comandoDePosicaoDaRobo, 
												   comandoDeMovimentoDaRobo);

	}
	
	@Test
	public void validarComandoDeDimensaoDoPlanalto(){
		assertTrue(validacaoEntrada.validarDimensaoDoPlanalto());
	}
	
	@Test
	public void validarComandoDePosicaoDaRobo(){
		assertTrue(validacaoEntrada.validarDimensaoDoPlanalto());
		assertTrue(validacaoEntrada.validarPosicaoDaRobo());
	}
	
	@Test
	public void validarComandoDeMovimentoDaRobo(){
		assertTrue(validacaoEntrada.validarDimensaoDoPlanalto());
		assertTrue(validacaoEntrada.validarPosicaoDaRobo());
		assertTrue(validacaoEntrada.validarMovimentoDaRobo());
		
	}
	
}
