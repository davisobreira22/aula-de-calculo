 package app.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;
import app.repository.CalculosRepository;

@Service
public class CalculosService {
	
	@Autowired
	private CalculosRepository calculosRepository;
	
	
	public List<Resultado> findAll(){
		return this.calculosRepository.findAll();
	}
	
	// Método que realiza todos os cálculos usando a lista de números da entrada
		public Resultado calcular(Entrada entrada) {
			
			Resultado resultado = new Resultado();
			List<Integer> numeros = entrada.getLista();
			
			// Realizar soma e calcular média
			int soma = this.somar(numeros);
			System.out.println("A soma deu " + soma);
			resultado.setSoma(soma);
			
			double media = this.media(numeros);
			System.out.println("A média é " + media);
			resultado.setMedia(media);
			
			// Chamando o método maiorNumeroLista
			int maiorNumero = this.maiorNumeroLista(numeros);
			System.out.println("O maior número da lista é: " + maiorNumero);

			// Chamando o método menorNumeroLista
			int menorNumero = this.menorNumeroLista(numeros);
			System.out.println("O menor número da lista é: " + menorNumero);
			
			// Chamando o método totalElementosLista
			int totalElementos = this.totalElementosLista(numeros);
			System.out.println("O total de elementos na lista é: " + totalElementos);

			// Chamando o método multiplicar
			int produto = this.multiplicar(numeros);
			System.out.println("O produto de todos os elementos da lista é: " + produto);

			// Chamando o método moda
			int moda = this.moda(numeros);
			System.out.println("A moda da lista é: " + moda);

			// Chamando o método mediana
			double mediana = this.mediana(numeros);
			System.out.println("A mediana da lista é: " + mediana);

			// Salvando o resultado no repositório
			resultado = this.calculosRepository.save(resultado);
			
			return resultado;
		}
	
	public int somar(List<Integer> lista) {
		int soma = 0;
		for(int i = 0; i < lista.size(); i++) {
			soma += lista.get(i);
		}
		return soma;
	}
	
	private double media(List<Integer> lista) {
		return (double) this.somar(lista) / lista.size();
	}

	// Método para obter o maior número da lista
	public int maiorNumeroLista(List<Integer> lista) {
		int maior = Collections.max(lista);
		System.out.println("O maior número da lista é: " + maior);
		return maior;
	}

	// Método para obter o menor número da lista
	public int menorNumeroLista(List<Integer> lista) {
		int menor = Collections.min(lista);
		System.out.println("O menor número da lista é: " + menor);
		return menor;
	}

	// Método para obter o total de elementos da lista
	public int totalElementosLista(List<Integer> lista) {
		int total = lista.size();
		System.out.println("O total de elementos na lista é: " + total);
		return total;
	}

	// Método para multiplicar todos os elementos da lista
	public int multiplicar(List<Integer> lista) {
		int produto = 1;
		for (int numero : lista) {
			produto *= numero;
		}
		System.out.println("O produto de todos os elementos da lista é: " + produto);
		return produto;
	}

	// Método para calcular a moda (número que mais aparece)
	public int moda(List<Integer> lista) {
		Map<Integer, Integer> frequencia = new HashMap<>();
		for (int numero : lista) {
			frequencia.put(numero, frequencia.getOrDefault(numero, 0) + 1);
		}
		
		Optional<Map.Entry<Integer, Integer>> moda = frequencia.entrySet().stream()
			.max(Map.Entry.comparingByValue());
		
		int valorModa = moda.isPresent() ? moda.get().getKey() : -1; // Retorna -1 se não houver moda
		System.out.println("A moda da lista é: " + valorModa);
		return valorModa;
	}

	// Método para calcular a mediana
	public double mediana(List<Integer> lista) {
		List<Integer> listaOrdenada = lista.stream().sorted().collect(Collectors.toList());
		int tamanho = listaOrdenada.size();
		
		double mediana;
		if (tamanho % 2 == 0) {
			// Se o tamanho da lista for par, a mediana é a média dos dois elementos centrais
			mediana = (listaOrdenada.get(tamanho / 2 - 1) + listaOrdenada.get(tamanho / 2)) / 2.0;
		} else {
			// Se o tamanho for ímpar, a mediana é o elemento central
			mediana = listaOrdenada.get(tamanho / 2);
		}
		System.out.println("A mediana da lista é: " + mediana);
		return mediana;
	}
}
