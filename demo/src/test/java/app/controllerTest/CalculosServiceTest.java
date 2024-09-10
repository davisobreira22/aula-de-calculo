package app.controllerTest;
 

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculosService;

@SpringBootTest // Contexto do Spring nos testes
public class CalculosServiceTest {

    @Autowired
    private CalculosService calculosService;

    // Teste de soma - cenário de soma correta
    @Test
    @DisplayName("Teste unitário - soma correta")
    void cenario01() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(4);
        lista.add(2);

        int soma = calculosService.somar(lista);

        Assertions.assertEquals(10, soma); // Verificação
    }

    // Teste de soma - cenário de erro (valor nulo)
    @Test
    @DisplayName("Teste unitário - soma com valor nulo")
    void cenario02() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(4);
        lista.add(null);

        Assertions.assertThrows(Exception.class, () -> {
            int soma = calculosService.somar(lista);
        });
    }

    // Teste de maior número - cenário correto
    @Test
    @DisplayName("Teste unitário - maior número correto")
    void cenario03() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(5);

        int maior = calculosService.maiorNumeroLista(lista);

        Assertions.assertEquals(5, maior);
    }

    // Teste de maior número - cenário com valores negativos
    @Test
    @DisplayName("Teste unitário - maior número com valores negativos")
    void cenario04() {
        List<Integer> lista = new ArrayList<>();
        lista.add(-10);
        lista.add(-5);
        lista.add(-3);

        int maior = calculosService.maiorNumeroLista(lista);

        Assertions.assertEquals(-3, maior);
    }

    // Teste de menor número - cenário correto
    @Test
    @DisplayName("Teste unitário - menor número correto")
    void cenario05() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(5);

        int menor = calculosService.menorNumeroLista(lista);

        Assertions.assertEquals(1, menor);
    }

    // Teste de menor número - cenário com valores negativos
    @Test
    @DisplayName("Teste unitário - menor número com valores negativos")
    void cenario06() {
        List<Integer> lista = new ArrayList<>();
        lista.add(-10);
        lista.add(-5);
        lista.add(-3);

        int menor = calculosService.menorNumeroLista(lista);

        Assertions.assertEquals(-10, menor);
    }

    // Teste de total de elementos - cenário correto
    @Test
    @DisplayName("Teste unitário - total de elementos correto")
    void cenario07() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(5);

        int total = calculosService.totalElementosLista(lista);

        Assertions.assertEquals(3, total);
    }

    // Teste de total de elementos - lista vazia
    @Test
    @DisplayName("Teste unitário - total de elementos com lista vazia")
    void cenario08() {
        List<Integer> lista = new ArrayList<>();

        int total = calculosService.totalElementosLista(lista);

        Assertions.assertEquals(0, total);
    }

    // Teste de multiplicação - cenário correto
    @Test
    @DisplayName("Teste unitário - multiplicação correta")
    void cenario09() {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(4);

        int produto = calculosService.multiplicar(lista);

        Assertions.assertEquals(24, produto);
    }

    // Teste de multiplicação - lista com zero
    @Test
    @DisplayName("Teste unitário - multiplicação com zero")
    void cenario10() {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(0);
        lista.add(4);

        int produto = calculosService.multiplicar(lista);

        Assertions.assertEquals(0, produto);
    }

    // Teste de moda - cenário correto
    @Test
    @DisplayName("Teste unitário - moda correta")
    void cenario11() {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(2);
        lista.add(3);

        int moda = calculosService.moda(lista);

        Assertions.assertEquals(2, moda);
    }

    // Teste de moda - sem moda (todos elementos únicos)
    @Test
    @DisplayName("Teste unitário - sem moda")
    void cenario12() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        int moda = calculosService.moda(lista);

        Assertions.assertEquals(1, moda); // -1 significa que não há moda
    }

    // Teste de mediana - cenário com lista de tamanho ímpar
    @Test
    @DisplayName("Teste unitário - mediana com lista ímpar")
    void cenario13() {
        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(1);
        lista.add(2);

        double mediana = calculosService.mediana(lista);

        Assertions.assertEquals(2.0, mediana);
    }

    // Teste de mediana - cenário com lista de tamanho par
    @Test
    @DisplayName("Teste unitário - mediana com lista par")
    void cenario14() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        double mediana = calculosService.mediana(lista);

        Assertions.assertEquals(2.5, mediana);
    }
}
