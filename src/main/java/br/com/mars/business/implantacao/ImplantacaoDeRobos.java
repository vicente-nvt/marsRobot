package br.com.mars.business.implantacao;

import br.com.mars.entities.implantacao.IInstrucaoDeMovimentacao;
import br.com.mars.entities.implantacao.IValidacaoDeEntradas;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.robo.Robo;

public class ImplantacaoDeRobos {

	IValidacaoDeEntradas validacao;
	IPlanalto planaltoImplantacao;
	Robo novoRobo;
	
	public ImplantacaoDeRobos(IInstrucaoDeMovimentacao instrucao, String posicaoRobo) {
				
		validacao = new ValidacaoDeEntradas();
				
		validarPosicaoDoRobo(posicaoRobo, instrucao.getPlanalto());
				
		novoRobo = new Robo(instrucao, 
							Integer.parseInt(posicaoRobo.split(",")[0]), //Posição inicial em X
							Integer.parseInt(posicaoRobo.split(",")[1]), //Posição inicial em Y
							new MapaDeDirecao().getDirecao(posicaoRobo.split(",")[2])); //Direção inicial 
	}

	public String movimentarRobo(String comandosRobo) {
		
		validarMovimentoDoRobo(comandosRobo);			
		
		if (!novoRobo.executarComandos(comandosRobo))
			throw new RuntimeException();
		
		return this.novoRobo.getPosicaoAposMovimentar();
	}
	
	private boolean validarPosicaoDoRobo(String posicaoRobo, IPlanalto planalto){

		validacao.setDimensaoDoPlanalto(planalto.getX(), planalto.getY());
		validacao.setComandoDePosicaoDoRobo(posicaoRobo);		
		
		if (!validacao.validarPosicaoDoRobo())
			throw new RuntimeException();

		return true;
	}
	
	private boolean validarMovimentoDoRobo(String comandosRobo){

		validacao.setComandoDeMovimentoDoRobo(comandosRobo);
		
		if (!validacao.validarMovimentoDoRobo())
			throw new IllegalArgumentException("Comandos inválidos");

		return true;
	}
		
}
		
		
