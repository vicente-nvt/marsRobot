package br.com.mars.test.sonda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class TestGirarRoboParaEsquerda {

	Robo robo;
	IPlanalto planalto;
	Direcao novaDirecao;
	
	@Before
	public void criarPlanalto(){
		this.planalto = new PlanaltoRetangular(5,5);
		this.robo = new Robo(planalto,0,0,Direcao.NORTH);
	}
	
	@Test
	public void girarRoboParaDireitaTestPosicionadoNorth(){
		
		robo.setDirecao(Direcao.NORTH);
		
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaEsquerda();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.WEST);		
	}
	
	@Test
	public void girarRoboParaDireitaPosicionadoEast(){
		
		robo.setDirecao(Direcao.EAST);
				
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaEsquerda();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.NORTH);				
	}
	
	@Test
	public void girarRoboParaDireitaPosicionadoSouth(){
		
		robo.setDirecao(Direcao.SOUTH);
				
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaEsquerda();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.EAST);				
	}
	
	@Test
	public void girarRoboParaDireitaPosicionadoWest(){
		
		robo.setDirecao(Direcao.WEST);
				
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaEsquerda();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.SOUTH);				
	}

}
