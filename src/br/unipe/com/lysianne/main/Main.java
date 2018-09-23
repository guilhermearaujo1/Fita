package br.unipe.com.lysianne.main;

import java.util.ArrayList;
import java.util.List;

import br.unipe.com.lysianne.Aluguel;
import br.unipe.com.lysianne.Cliente;
import br.unipe.com.lysianne.Fita;
import br.unipe.com.lysianne.ItemAlugavel;
import br.unipe.com.lysianne.TipoItem;

public class Main {
	
	public static void main(String[] args) {
		Fita fitaUm = new Fita(3.5, TipoItem.normal, "Todo Mundo Odeia o Chris");
		Fita fitaDois = new Fita(5, TipoItem.infantil, "Mr.pickles");
		Fita fitaTres = new Fita(5, TipoItem.lancamento, "A freira");
		Cliente cliente = new Cliente("guilherme Dias");
		List<ItemAlugavel> items = new ArrayList();
		items.add(fitaUm);
		items.add(fitaDois);
		items.add(fitaTres);
		
		Aluguel aluguel = new Aluguel(items, 4, cliente);
		System.out.println(aluguel.extrato());
	}

}
