import java.text.DecimalFormat;

class Counter{
	private int count = 1;

	synchronized void increment(){
		if (count < 3){
			this.count += 1;
		}
	}
	synchronized void decrement(){
		if (count > 0){
			this.count -= 1;
		}
	}

	synchronized int get_count(){
		return this.count;
	}

}

class increment_Twenty_Times extends Thread{

	private Counter ctr;

	public increment_Twenty_Times(Counter c){
		this.ctr = c;
	}

	public void  run(){
		for (int i = 0; i < 20; i++){
			this.ctr.increment();
			try{
				Thread.sleep(generate_Time());
			} catch (InterruptedException e){
				System.out.println("Erro, thread interrompida");
			}
		}
	}

	private long generate_Time(){
		double number = Math.random() * (0.500);
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		double t = Double.parseDouble(numberFormat.format(number));
		t = t*1000;
		return (long) t;
	}

}

class decrement_Twenty_Times extends Thread{
	
	private Counter ctr;

	public decrement_Twenty_Times(Counter c){
		this.ctr = c;
	}

	public void run(){
		for (int i = 0; i < 20; i++){
			this.ctr.decrement();
			try{
				Thread.sleep(generate_Time());
			} catch (InterruptedException e){
				System.out.println("Erro, thread interrompida");
			}
		}
	}

	private long generate_Time(){
		double number = Math.random() * (0.500);
		DecimalFormat numberFormat = new DecimalFormat("#.000");
		double t = Double.parseDouble(numberFormat.format(number));
		t = t*1000;
		return (long) t;
	}
}
