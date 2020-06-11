import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote {

	public void increment() throws RemoteException;
	public void decrement() throws RemoteException;
	public void reset() throws RemoteException;
	public int read_value() throws RemoteException;
	
}
