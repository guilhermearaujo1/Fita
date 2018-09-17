package br.unipe.com.lysianne;

public abstract class ItemAlugavel{
	protected double preco;
	protected String descricao;
	protected TipoItem tipoItem;
	
	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
