package br.com.mars.test.robo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class TestMoverRoboForaDoLimite {

	private IPlanalto planalto;
	private Robo robo;
	
	
	@Before
	public void posicionarRobo(){
		
		this.planalto = new PlanaltoRetangular(5,5);
		this.robo = new Robo(this.planalto,5,5,Direcao.NORTH);		
	}
		
	@Test
	public void moverParaNorteForaDoLimiteEmY(){
		robo.setX(2);
		robo.setY(5);
		robo.setDirecao(Direcao.NORTH);
				
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),2);
		assertEquals(robo.getY(),5);
	}
	
		
	@Test
	public void moverParaSulForaDoLimiteEmY(){
		robo.setX(2);
		robo.setY(0);
		robo.setDirecao(Direcao.SOUTH);
		
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),2);
		assertEquals(robo.getY(),0);
	}
	
	@Test
	public void moverParaLesteForaDoLimiteEmX(){
		robo.setX(5);
		robo.setY(2);
		robo.setDirecao(Direcao.EAST);
		
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),5);
		assertEquals(robo.getY(),2);		
	}
	
	@Test
	public void moverParaOesteForaDoLimiteEmX(){
		robo.setX(0);
		robo.setY(2);
		robo.setDirecao(Direcao.WEST);
		
		robo.getPlanalto().moverNoPlanalto(robo);
		
		assertEquals(robo.getX(),0);
		assertEquals(robo.getY(),2);				
	}
}
