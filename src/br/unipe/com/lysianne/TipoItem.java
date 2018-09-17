package br.unipe.com.lysianne;

public enum TipoItem {

	normal(1, "normal"), lancamento(2, "lancamento"), infantil(3, "infantil");

	private int id;
	private String descricao;

	private TipoItem(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getId() {
		return id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(int id) {
		this.id = id;
	}

}
