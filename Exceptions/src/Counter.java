//package ch1;

public class Counter {
	private int value;
	private int limit;
    
	public Counter(int lim){value=0;limit=lim;}

	public void increment() throws TooHighException{
		if (value==limit)   {throw new TooHighException();}
        else {   value++;                  
	     }

	}
	
	public void decrement() throws TooLowException{
		if (value==0)   {throw new TooLowException();}
        else {   value--;                  
	     }
	}
	public int read_value(){
		return this.value;
	}
}
 

class TooLowException extends Exception{
	public TooLowException(){super();}
}

class TooHighException extends Exception{
	public TooHighException(){super();}
}