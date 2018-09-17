package br.unipe.com.lysianne;

import java.util.ArrayList;
import java.util.List;

public class Aluguel {
	private int diasAlugada;
	Cliente cliente;
	private List<ItemAlugavel> items = new ArrayList();

	public Aluguel(List<ItemAlugavel> items, int diasAlugada, Cliente cliente) {
		this.items = items;
		this.diasAlugada = diasAlugada;
		this.cliente = cliente;
	}

	public int getDiasAlugada() {
		return diasAlugada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<ItemAlugavel> getItems() {
		return items;
	}

	public void setItems(List<ItemAlugavel> items) {
		this.items = items;
	}

	public void setDiasAlugada(int diasAlugada) {
		this.diasAlugada = diasAlugada;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        double valorTotal = 0.0;
        int pontosDeAlugadorFrequente = 0;
        String resultado = "Registro de Alugueis de " 
                           + getCliente().getNome() + fimDeLinha;

        for (ItemAlugavel item : items) {

            double valorCorrente = 0.0;

            // determina valores para cada linha
            // switch com enum
            switch (item.getTipoItem()) {
            case normal:
                valorCorrente += 2;
                if (this.diasAlugada > 2) {
                    valorCorrente += (this.diasAlugada - 2) 
                                     * 1.5;
                }
                break;
            case lancamento:
                valorCorrente += this.diasAlugada  * 3;
                break;
            case infantil:
                valorCorrente += 1.5;
                if (this.diasAlugada  > 3) {
                    valorCorrente += (this.diasAlugada  - 3) 
                                     * 1.5;
                }
                break;
            } // switch
            // trata de pontos de alugador frequente
            pontosDeAlugadorFrequente++;
            // adiciona bonus para aluguel de um lançamento
            // por pelo menos 2 dias
            if (item.getTipoItem() 
                    == TipoItem.lancamento
                    && this.diasAlugada  > 1) {
                pontosDeAlugadorFrequente++;
            }

            // mostra valores para este aluguel
            resultado += "\t" + item.getDescricao() + "\t"
                    + valorCorrente + fimDeLinha;
            valorTotal += valorCorrente;
        } // for
        // adiciona rodapé
        resultado += "Valor total devido: " + valorTotal + fimDeLinha;
        resultado += "Voce acumulou " + pontosDeAlugadorFrequente
                + " pontos de alugador frequente";
        return resultado;
    }


}
