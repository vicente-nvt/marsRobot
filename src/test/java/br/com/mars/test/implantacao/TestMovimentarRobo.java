package br.com.mars.test.implantacao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.business.implantacao.MovimentarRobo;
import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class TestMovimentarRobo {

	private IPlanalto planalto;
	
	@Before
	public void configurarPlanalto(){
		
		planalto = new PlanaltoRetangular(6,6);		
	}
	
	@Test
	public void testarMovimentoPrimeiroRobo(){
		
		Robo robo = new Robo(planalto, 1, 2, Direcao.NORTH);
		
		String movimentoRobo = "LMLMLMLMM";
		
		MovimentarRobo movimento = new MovimentarRobo(robo, movimentoRobo);

		movimento.movimentar();
		
		assertEquals(robo.getX(),1);
		assertEquals(robo.getY(),3);
		assertEquals(robo.getDirecao(),Direcao.NORTH);
	}
	
	@Test
	public void testarMovimentoSegundoRobo(){
		
		Robo robo = new Robo(planalto, 3, 3, Direcao.EAST);
		
		String movimentoRobo = "MMRMMRMRRM";
		
		MovimentarRobo movimento = new MovimentarRobo(robo, movimentoRobo);
				
		movimento.movimentar();
		
		assertEquals(robo.getX(),5);
		assertEquals(robo.getY(),1);
		assertEquals(robo.getDirecao(),Direcao.EAST);
	}	
}
