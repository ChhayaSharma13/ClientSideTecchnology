import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CounterImpl extends UnicastRemoteObject implements Counter {

	private int value;
	
	 public CounterImpl( int d ) throws RemoteException 
	   {
		 value = d;
	    }

	@Override
	public void increment() throws RemoteException {
		// TODO Auto-generated method stub
		this.value++;
	}

	@Override
	public void decrement() throws RemoteException {
		// TODO Auto-generated method stub
		this.value--;
	}
	
	public void reset() throws RemoteException {
		// TODO Auto-generated method stub
		this.value = 0;
	}

	@Override
	public int read_value() throws RemoteException {
		// TODO Auto-generated method stub
		return this.value;
	}

}
