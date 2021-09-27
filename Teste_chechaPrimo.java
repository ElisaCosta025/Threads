import java.util.Scanner;

public class Teste_chechaPrimo{

	public static void main(String agrs[]){
		
		// EXERCICIO 1
		// Input do numero n pelo usuario
		Scanner Scan_Num_Input = new Scanner(System.in);
		double n = Scan_Num_Input.nextInt();
		// Inicializar variavel com metade do numero n
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
		// Print numero de primos
		System.out.println(numPrimos);
		Scan_Num_Input.close();
	}
	
}