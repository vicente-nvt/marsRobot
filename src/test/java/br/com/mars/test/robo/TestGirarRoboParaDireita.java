package br.com.mars.test.robo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.mars.business.implantacao.InstrucaoDeMovimentacaoPlanaltoRetangular;
import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.implantacao.IInstrucaoDeMovimentacao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class TestGirarRoboParaDireita {

	Robo robo;
	IPlanalto planalto;
	Direcao novaDirecao;
	IInstrucaoDeMovimentacao instrucao;
	
	@Before
	public void criarPlanalto(){
		this.planalto = new PlanaltoRetangular(5,5);
		this.instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);
		this.robo = new Robo(instrucao,0,0,Direcao.NORTH);
	}
	
	@Test
	public void girarRoboParaDireitaTestPosicionadoNorth(){
		
		robo.setDirecao(Direcao.NORTH);
		
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaDireita();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.EAST);		
	}
	
	@Test
	public void girarRoboParaDireitaPosicionadoEast(){
		
		robo.setDirecao(Direcao.EAST);
				
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaDireita();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.SOUTH);				
	}
	
	@Test
	public void girarRoboParaDireitaPosicionadoSouth(){
		
		robo.setDirecao(Direcao.SOUTH);
				
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaDireita();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.WEST);				
	}
	
	@Test
	public void girarRoboParaDireitaPosicionadoWest(){
		
		robo.setDirecao(Direcao.WEST);
				
		novaDirecao = robo.getDirecao().getRegra().getPosicaoDaDireita();		
		
		robo.setDirecao(novaDirecao);
		
		assertEquals(robo.getDirecao(),Direcao.NORTH);				
	}

}
