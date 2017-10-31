package br.com.mars.test.sonda;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class TestMoverRoboDentroDoLimite {

	private IPlanalto planalto;
	private Robo robo;	
	
	@Before
	public void posicionarRobo(){
		
		this.planalto = new PlanaltoRetangular(5,5);
		this.robo = new Robo(this.planalto,5,5,Direcao.NORTH);		
	}
		
	@Test
	public void moverParaNorteDentroDoLimiteEmY(){
		robo.setX(2);
		robo.setY(2);
		robo.setDirecao(Direcao.NORTH);
				
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),2);
		assertEquals(robo.getY(),3);
	}
	
		
	@Test
	public void moverParaSulDentroDoLimiteEmY(){
		robo.setX(2);
		robo.setY(2);
		robo.setDirecao(Direcao.SOUTH);
		
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),2);
		assertEquals(robo.getY(),1);
	}
	
	@Test
	public void moverParaLesteDentroDoLimiteEmX(){
		robo.setX(2);
		robo.setY(2);
		robo.setDirecao(Direcao.EAST);
		
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),3);
		assertEquals(robo.getY(),2);		
	}
	
	@Test
	public void moverParaOesteDentroDoLimiteEmX(){
		robo.setX(2);
		robo.setY(2);
		robo.setDirecao(Direcao.WEST);
		
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),1);
		assertEquals(robo.getY(),2);				
	}
}
