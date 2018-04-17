package br.com.mars.entities.implantacao;

public interface IValidacaoDeEntradas {

	public boolean validarDimensaoDoPlanalto();
	public boolean validarPosicaoDoRobo();
	public boolean validarMovimentoDoRobo();
	public void setDimensaoDoPlanalto(int x, int y);
	public void setComandoDePosicaoDoRobo(String posicaoRobo);
	public void setComandoDeMovimentoDoRobo(String comandosRobo);	
}
