package br.com.mars.entities.implantacao;

import br.com.mars.entities.direcao.Direcao;
import br.com.mars.entities.planalto.IPlanalto;

public interface IInstrucaoDeMovimentacao {
	
	public boolean moverNoPlanalto(Direcao diretao, int x, int y);
	public IPlanalto getPlanalto();
	public int getX();
	public int getY();
}
