package br.com.mars.business.implantacao;

import br.com.mars.entities.implantacao.IValidacaoDeEntradas;

public class ValidacaoDeEntradas implements IValidacaoDeEntradas {

	private String comandoDeDimensaoDoPlanalto;
	private String comandoDePosicaoDaRobo;
	private String comandoDeMovimentoDaRobo;
	
	private int xPlanalto;
	private int yPlanalto;
	private int xRobo;
	private int yRobo;	
	
	public ValidacaoDeEntradas(String comandoDeDimensaoDoPlanalto,
							 String comandoDePosicaoDaRobo,
							 String comandoDeMovimentoDaRobo){
		
		this.comandoDeDimensaoDoPlanalto = comandoDeDimensaoDoPlanalto;
		this.comandoDePosicaoDaRobo = comandoDePosicaoDaRobo;
		this.comandoDeMovimentoDaRobo = comandoDeMovimentoDaRobo;
	}
	
	@Override
	public boolean validarDimensaoDoPlanalto() {
		
		String[] dimensoes = comandoDeDimensaoDoPlanalto.split(",");
		
		if (dimensoes.length != 2)  
			return false;
					
		try {
			xPlanalto = Integer.parseInt(dimensoes[0]);
		} catch (Exception e) {
			return false;
		}
		
		try {
			yPlanalto = Integer.parseInt(dimensoes[1]);
		} catch (Exception e) {
			return false;
		} 
		
		return (xPlanalto > 0) && (yPlanalto > 0);			
		
	}

	@Override
	public boolean validarPosicaoDaRobo() {
		
		String[] posicaoDaRobo = comandoDePosicaoDaRobo.split(",");
		
		if (posicaoDaRobo.length != 3)
			return false;
	
		try {
			xRobo = Integer.parseInt(posicaoDaRobo[0]);
		} catch (Exception e) {
			return false;
		}
		
		try {
			yRobo = Integer.parseInt(posicaoDaRobo[1]);
		} catch (Exception e) {
			return false;
		} 		
		
		if (new MapaDeDirecao().getDirecao(posicaoDaRobo[2]) == null)
			return false;
		
		return (xRobo >= 0) && (yRobo >= 0) && (xRobo <= xPlanalto) && (yRobo <= yPlanalto);
	}

	@Override
	public boolean validarMovimentoDaRobo() {
		
		return comandoDeMovimentoDaRobo.matches("[RLM]+");		
		
	}

}