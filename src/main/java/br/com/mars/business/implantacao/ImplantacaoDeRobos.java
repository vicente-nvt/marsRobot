package br.com.mars.business.implantacao;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;
import br.com.mars.entities.planalto.PlanaltoRetangular;
import br.com.mars.entities.robo.Robo;

public class ImplantacaoDeRobos {

	IPlanalto planaltoImplantacao;
	
	public String implantarEMoverRobo (String planalto, String posicaoRobo, String comandosRobo){
		
		ValidacaoDeEntradas validacao;	
			
		validacao = new ValidacaoDeEntradas(planalto, posicaoRobo, comandosRobo);
		
		if (!validacao.validarDimensaoDoPlanalto()) 
			return "E000";
		
		if (!validacao.validarPosicaoDaRobo())
			return "E001";
		
		if (!validacao.validarMovimentoDaRobo())
			return "E002";
				
		int xPlanalto = Integer.parseInt(planalto.split(",")[0]);
		int yPlanalto = Integer.parseInt(planalto.split(",")[0]);		
		
		planaltoImplantacao = new PlanaltoRetangular(xPlanalto, yPlanalto);
		
		int xRobo = Integer.parseInt(posicaoRobo.split(",")[0]);
		int yRobo = Integer.parseInt(posicaoRobo.split(",")[1]);
		Direcao direcaoRobo = new MapaDeDirecao().getDirecao(posicaoRobo.split(",")[2]);		
		
		Robo novaRobo = new Robo(planaltoImplantacao, xRobo, yRobo, direcaoRobo);
		
		MovimentarRobo movimento = new MovimentarRobo(novaRobo, comandosRobo);
		
		if (!movimento.movimentar())
			return "E003";
								
		return "("  + novaRobo.getX() + "," + novaRobo.getY() + "," + novaRobo.getDirecao().toString().charAt(0) + ")";	
	}	
}
		
		
