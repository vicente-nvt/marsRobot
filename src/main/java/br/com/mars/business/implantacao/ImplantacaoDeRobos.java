package br.com.mars.business.implantacao;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class ImplantacaoDeRobos {

	IPlanalto planaltoImplantacao;
	boolean falhaNaImplantacao;
	String retornoFalha;
	
	public String implantarEMoverRobo (String planalto, String posicaoRobo, String comandosRobo){
		
		retornoFalha = validarEntradas(planalto, posicaoRobo, comandosRobo);
				
		Robo novoRobo = implantarRobo(planalto, posicaoRobo);
		
		retornoFalha += moverRobo(comandosRobo, novoRobo);
		
		if (!retornoFalha.isEmpty()) {
			falhaNaImplantacao = true;
			return retornoFalha;
		}
								
		return "("  + novoRobo.getX() + "," + novoRobo.getY() + "," + novoRobo.getDirecao().toString().charAt(0) + ")";	
	}

	private String moverRobo(String comandosRobo, Robo novoRobo) {
		
		MovimentarRobo movimento = new MovimentarRobo(novoRobo, comandosRobo);
		
		if (!movimento.movimentar())
			return "E003";
		
		return "";
	}

	private Robo implantarRobo(String planalto, String posicaoRobo) {
		
		int xPlanalto = Integer.parseInt(planalto.split(",")[0]);
		int yPlanalto = Integer.parseInt(planalto.split(",")[0]);		
		
		planaltoImplantacao = new PlanaltoRetangular(xPlanalto, yPlanalto);
		
		int xRobo = Integer.parseInt(posicaoRobo.split(",")[0]);
		int yRobo = Integer.parseInt(posicaoRobo.split(",")[1]);
		Direcao direcaoRobo = new MapaDeDirecao().getDirecao(posicaoRobo.split(",")[2]);		
				
		return new Robo(planaltoImplantacao, xRobo, yRobo, direcaoRobo);
	}

	private String validarEntradas(String planalto, String posicaoRobo, String comandosRobo) {
		
		String mensagemRetorno = "";
		
		ValidacaoDeEntradas validacao = new ValidacaoDeEntradas(planalto, posicaoRobo, comandosRobo);;	
					
		if (!validacao.validarDimensaoDoPlanalto()) 
			mensagemRetorno += "E000";
		
		if (!validacao.validarPosicaoDoRobo())
			mensagemRetorno += "E001";
		
		if (!validacao.validarMovimentoDoRobo())
			mensagemRetorno += "E002";
		
		return mensagemRetorno;
	}
	
	public boolean getfalhaNaImplantacao(){
		return this.falhaNaImplantacao;
	}
}
		
		
