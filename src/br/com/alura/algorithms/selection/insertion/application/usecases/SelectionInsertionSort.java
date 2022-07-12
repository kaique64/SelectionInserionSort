package br.com.alura.algorithms.selection.insertion.application.usecases;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Iterator;

import br.com.alura.algorithms.selection.insertion.domain.Produto;

public class SelectionInsertionSort {

	public static void main(String[] args) {
		getActualTime();
		System.out.println();
		Produto[] produtos = { 
				new Produto("Lamborghini", 1000000),
				new Produto("Jeep", 46000),
				new Produto("Brasilia", 16000),
				new Produto("Smart", 46000),
				new Produto("Fusca", 17000)
		};

		selectionSort(produtos, produtos.length);
//		insertionSort(produtos, produtos.length);
		
		imprime(produtos);
		
		getActualTime();
	}

	private static void imprime(Produto[] produtos) {
		for (Produto produto : produtos) {
			System.out.println(produto.getNome() + " " + produto.getPreco());
		}
	}
	
	private static void selectionSort(Produto[] produtos, int termino) {
		for (int i = 0; i < produtos.length - 1; i++) {
			int cheaper = buscaMenor(produtos, i, produtos.length);

			troca(produtos, i, cheaper);
		}
	}
	
	private static void insertionSort(Produto[] produtos, int quantidadeDeElementos) {
		for (int i = 0; i < quantidadeDeElementos; i++) {
			int analise = i;
			while (analise > 0 && produtos[analise].getPreco() < produtos[analise - 1].getPreco()) {
				troca(produtos, analise, analise - 1);
				analise--;
			}
			
			imprime(produtos);
			System.out.println();
		}
	} 
	
	private static void troca(Produto[] produtos, int atual, int anterior) {
		Produto produtoAtual = produtos[atual];
		Produto produtoAnterior = produtos[anterior];
		
		produtos[atual] = produtoAnterior;
		produtos[anterior] = produtoAtual;
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
	
	private static void getActualTime() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millis = now.get(Calendar.MILLISECOND);

		System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);
	}
	
}
