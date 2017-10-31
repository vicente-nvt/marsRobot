package br.com.mars.test.planalto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;

public class TestPlanalto {
	
	@Test
	public void testarAtribuicaoDimensaoPlataforma(){
		
		IPlanalto planalto = new PlanaltoRetangular(6,6);		
		
		assertEquals(5,((PlanaltoRetangular) planalto).getX());
		assertEquals(5,((PlanaltoRetangular) planalto).getY());		
	}
}
