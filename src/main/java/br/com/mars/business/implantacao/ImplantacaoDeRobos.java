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
		
		retornoFalha = "";
		
		ValidacaoDeEntradas validacao;	
			
		validacao = new ValidacaoDeEntradas(planalto, posicaoRobo, comandosRobo);
		
		if (!validacao.validarDimensaoDoPlanalto()) 
			retornoFalha += "E000";
		
		if (!validacao.validarPosicaoDaRobo())
			retornoFalha += "E001";
		
		if (!validacao.validarMovimentoDaRobo())
			retornoFalha += "E002";
				
		int xPlanalto = Integer.parseInt(planalto.split(",")[0]);
		int yPlanalto = Integer.parseInt(planalto.split(",")[0]);		
		
		planaltoImplantacao = new PlanaltoRetangular(xPlanalto, yPlanalto);
		
		int xRobo = Integer.parseInt(posicaoRobo.split(",")[0]);
		int yRobo = Integer.parseInt(posicaoRobo.split(",")[1]);
		Direcao direcaoRobo = new MapaDeDirecao().getDirecao(posicaoRobo.split(",")[2]);		
		
		Robo novaRobo = new Robo(planaltoImplantacao, xRobo, yRobo, direcaoRobo);
		
		MovimentarRobo movimento = new MovimentarRobo(novaRobo, comandosRobo);
		
		if (!movimento.movimentar())
			retornoFalha += "E003";
		
		if (!retornoFalha.equals("")) {
			falhaNaImplantacao = true;
			return retornoFalha;
		}
								
		return "("  + novaRobo.getX() + "," + novaRobo.getY() + "," + novaRobo.getDirecao().toString().charAt(0) + ")";	
	}
	
	public boolean getfalhaNaImplantacao(){
		return this.falhaNaImplantacao;
	}
}
		
		
