package br.unipe.com.lysianne;

import java.util.ArrayList;
import java.util.List;

public class Aluguel {
	private int diasAlugada;
	Cliente cliente;
	private List<ItemAlugavel> items = new ArrayList();
	private double valorTotal;
	
	public Aluguel(List<ItemAlugavel> items, int diasAlugada, Cliente cliente) {
		this.items = items;
		this.diasAlugada = diasAlugada;
		this.cliente = cliente;
	}
	
	public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        int pontosDeAlugadorFrequente = 0;
        String resultado = "Registro de Alugueis de " 
                           + getCliente().getNome() + fimDeLinha;

        for (ItemAlugavel item : items) {

            double valorCorrente = 0.0;
            double totalAcrescimo = 0.0;

            switch (item.getTipoItem()) {
            case normal:
            	valorCorrente += item.getPreco();
                if (this.diasAlugada > 2) {
                    totalAcrescimo += (this.diasAlugada - 2) * 1.5;
                }
                break;
            case lancamento:
                valorCorrente += item.getPreco() * 3;
                break;
            case infantil:
                valorCorrente += item.getPreco();
                if (this.diasAlugada  > 3)
                	totalAcrescimo += (this.diasAlugada  - 3) * 1.5;
                break;
            }
            pontosDeAlugadorFrequente++;
            if (item.getTipoItem() == TipoItem.lancamento && this.diasAlugada > 1) {
                pontosDeAlugadorFrequente++;
            }

            resultado += "\t" + item.getDescricao() + "\t"
                    + "Valor da fita: R$" + valorCorrente + "\tValor do acrescimo: R$" + totalAcrescimo + fimDeLinha;          		
            this.valorTotal += (valorCorrente + totalAcrescimo);
        }
        cliente.setPontos(pontosDeAlugadorFrequente);
        resultado += "Valor total devido: " + valorTotal + fimDeLinha;
        resultado += "Voce acumulou " + pontosDeAlugadorFrequente
                + " pontos de alugador frequente";
        return resultado;
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
