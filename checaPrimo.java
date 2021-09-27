public class checaPrimo extends Thread {

	private double x;
	private double y;
	private int counter;

	public checaPrimo(double lower, double higher){
		this.x = lower;
		this.y = higher;
		this.counter = 0;
	}

	public void  run()
	{
		// For each number between given values
		for (double i = x; i < y; i++)
		{

			if (y <= 2){
				break;
			}

			// Boolean variable to check if prime
			boolean primo = true;
			// Check if the number is prime
			for (double j = 2; j < y; j++){
				if (i%j == 0 && i != j){
					primo = false;
				}
			}
			// If it's prime, increase counter
			if (primo == true){
				counter++;
			}
			
		}
	}

	public int getCounter(){
		return(counter);
	}
}