package br.com.alura.algorithms.selection.insertion.application.usecases;

import br.com.alura.algorithms.selection.insertion.domain.Produto;

public class SelectMinorPrice {

	public static void main(String[] args) {
		
		Produto[] produtos = { 
				new Produto("Lamborghini", 1000000),
				new Produto("Jeep", 46000),
				new Produto("Brasilia", 16000),
				new Produto("Smart", 46000),
				new Produto("Fusca", 17000)
		};
		
		int cheaper = buscaMenor(produtos, 0, 4);
		
		System.out.println(cheaper);
		System.out.println("O carro mais barato é " + produtos[cheaper].getNome() 
				+ " e custa R$ " + produtos[cheaper].getPreco());
		
	}

	private static int buscaMenor(Produto[] produtos, int inicio, int termino) {
		int cheaper = inicio;
		
		for (int i = inicio; i < termino; i++) {
			double cheaperProductPrice = produtos[cheaper].getPreco();
			double actualProductPrice = produtos[i].getPreco();

			if (actualProductPrice < cheaperProductPrice) {
				cheaper = i;
			}
		}
		
		return cheaper;
	}

}
