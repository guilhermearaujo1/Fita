package br.unipe.com.lysianne;

public class Fita extends ItemAlugavel{
	
	public Fita(double preco, TipoItem tipoItem, String descricao) {
		this.tipoItem = tipoItem;
		this.preco = preco;
		this.descricao = descricao;

	}
}
