package br.com.mars.test.implantacao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.mars.business.implantacao.ImplantacaoDeRobos;
import br.com.mars.business.implantacao.InstrucaoDeMovimentacaoPlanaltoRetangular;
import br.com.mars.entities.implantacao.IInstrucaoDeMovimentacao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;

public class TestImplantacaoDeRobo {
		
	@Test
	public void implantarRoboMovimentoEsquerda(){
						
		IPlanalto planalto = new PlanaltoRetangular(5, 5);
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);		
				
		String posicaoRobo = "1,2,N";
		String comandosRobo = "LMLMLMLMM";		
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos(instrucao, posicaoRobo);		
		
		assertEquals(implantacao.movimentarRobo(comandosRobo),"(1,3,N)");
	}

	@Test
	public void implantarRoboMovimentoDireita(){

		IPlanalto planalto = new PlanaltoRetangular(6, 6);
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);		
		
		String posicaoRobo = "3,3,E";
		String comandosRobo = "MMRMMRMRRM";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos(instrucao, posicaoRobo);		
		
		assertEquals(implantacao.movimentarRobo(comandosRobo),"(5,1,E)");
	}
	
	@Test 
	public void implantarRoboRotacaoParaDireita(){
		
		IPlanalto planalto = new PlanaltoRetangular(5, 5);
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);		
		
		String posicaoRobo = "0,0,N";
		String comandosRobo = "MMRMMRMM";

		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos(instrucao, posicaoRobo);
		
		assertEquals(implantacao.movimentarRobo(comandosRobo),"(2,0,S)");
		
	}

	@Test 
	public void implantarRoboRotacaoParaEsquerda(){

		IPlanalto planalto = new PlanaltoRetangular(5, 5);
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);		
		
		String posicaoRobo = "0,0,N";
		String comandosRobo = "MML";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos(instrucao, posicaoRobo);
		
		assertEquals(implantacao.movimentarRobo(comandosRobo),"(0,2,W)");
		
	}	
	
	@Test (expected = RuntimeException.class)
	public void implantarRoboComandoInvalido(){

		IPlanalto planalto = new PlanaltoRetangular(5, 5);
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);		

		String posicaoRobo = "0,0,N";
		String comandosRobo = "AAA";
		
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos(instrucao, posicaoRobo);
		
		implantacao.movimentarRobo(comandosRobo);		
	}	
	
	@Test (expected = RuntimeException.class)
	public void implantarRoboComMovimentoAlemDoLimite(){

		IPlanalto planalto = new PlanaltoRetangular(5, 5);
		IInstrucaoDeMovimentacao instrucao = new InstrucaoDeMovimentacaoPlanaltoRetangular(planalto);		
		
		String posicaoRobo = "0,0,N";
		String comandosRobo = "MMMMMMMMMMMMMMMMMMMMMMMM";
	
		ImplantacaoDeRobos implantacao = new ImplantacaoDeRobos(instrucao, posicaoRobo);
		
		implantacao.movimentarRobo(comandosRobo);
		
	}
	
	
}
