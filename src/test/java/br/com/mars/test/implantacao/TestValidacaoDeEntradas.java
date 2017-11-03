package br.com.mars.test.implantacao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.business.implantacao.ValidacaoDeEntradas;
import br.com.mars.entities.implantacao.IValidacaoDeEntradas;

public class TestValidacaoDeEntradas {

	private String comandoDeDimensaoDoPlanalto = "5,5";
	private String comandoDePosicaoDoRobo = "0,0,N";
	private String comandoDeMovimentoDoRobo = "MMRMMRMRRM";
	
	private IValidacaoDeEntradas validacaoEntrada;
	
	@Before
	public void criarValidacaoDeRobo(){
		validacaoEntrada = new ValidacaoDeEntradas(comandoDeDimensaoDoPlanalto, 
												   comandoDePosicaoDoRobo, 
												   comandoDeMovimentoDoRobo);

	}
	
	@Test
	public void validarComandoDeDimensaoDoPlanalto(){
		assertTrue(validacaoEntrada.validarDimensaoDoPlanalto());
	}
	
	@Test
	public void validarComandoDePosicaoDoRobo(){
		assertTrue(validacaoEntrada.validarDimensaoDoPlanalto());
		assertTrue(validacaoEntrada.validarPosicaoDoRobo());
	}
	
	@Test
	public void validarComandoDeMovimentoDoRobo(){
		assertTrue(validacaoEntrada.validarDimensaoDoPlanalto());
		assertTrue(validacaoEntrada.validarPosicaoDoRobo());
		assertTrue(validacaoEntrada.validarMovimentoDoRobo());
		
	}
	
}
