package br.com.mars.test.robo;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.mars.business.implantacao.InstrucaoDeMovimentacaoPlanaltoRetangular;
import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.implantacao.IInstrucaoDeMovimentacao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class TestPosicionarRobo {

	
	@Test
	public void posicionarRoboNoPlanalto(){
				
		IPlanalto planalto = new PlanaltoRetangular(5,5);
		
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);
		
		Robo robo = new Robo(instrucao,0,0,Direcao.NORTH);
			
		assertEquals(robo.getX(),0);
		assertEquals(robo.getY(), 0);
		assertEquals(robo.getDirecao(), Direcao.NORTH);		
	}
}
