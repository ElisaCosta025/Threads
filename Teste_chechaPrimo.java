import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste de conversão de unidades")
public class Teste_checaPrimo {
    @Test
    public void checaPrimo_Test(){
        	// EXERCICIO 1
		// 20 Pode facilmente ser trocado por input do numero n pelo usuario
		double n = 20;
		// Inicializar variavel com metade do numero n (Nesse caso de teste n = 20)
		double halfN = Math.ceil(n/2);

		// Inicializar thread para checar numero de primos
		// Cada thread deve checar metade dos numeros
		// Entre 0 e o numero n simultaneamente
		checaPrimo Thread1 = new checaPrimo(2, halfN);
		checaPrimo Thread2 = new checaPrimo(halfN, n);
		// Iniciar operação das threads
		Thread1.start();
		Thread2.start();
		// Esperar até terminar de calcular
		try {
			Thread1.join();
			Thread2.join();
		} catch (InterruptedException e){
			System.out.println("Erro, thread interrompida");
		}

		// Pegar número de primos das threads
		int a = Thread1.getCounter();
		int b = Thread2.getCounter();

		// Calcular numero de primos 
		int numPrimos = a + b;
		// Testa numero de primos

        	Assertions.assertEquals(numPrimos, 8);
    }
}
