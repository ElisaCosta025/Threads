import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste de conversão de unidades")
public class Teste_Counters {
    
    @Test
    public void Counter_Test(){
      Counter test_Counter = new Counter();
		  increment_Twenty_Times Thread1 = new increment_Twenty_Times(test_Counter);
		  decrement_Twenty_Times Thread2 = new decrement_Twenty_Times(test_Counter);
		  // Iniciar operação das threads
		  Thread1.start();
		  Thread2.start();

		  try {
		  	Thread1.join();
			  Thread2.join();
		  } catch (InterruptedException e){
			  System.out.println("Erro, thread interrompida");
		  }

		  Assertions.assertTrue(test_Counter.get_count() >= 0 && test_Counter.get_count() <= 3);
    }
}
