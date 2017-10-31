package br.com.mars.business.implantacao;

import java.util.HashMap;
import java.util.Map;

import br.com.mars.entities.direcao.Direcao;

public class MapaDeDirecao {

	private Map<String,Direcao> mapa;
		
	public MapaDeDirecao (){
		mapa = new HashMap<String,Direcao>();
		
		mapa.put("N", Direcao.NORTH);
		mapa.put("S", Direcao.SOUTH);
		mapa.put("E", Direcao.EAST);
		mapa.put("W", Direcao.WEST);
	}	
	
	public Direcao getDirecao(String direcao){
		return mapa.get(direcao);
	}
}
