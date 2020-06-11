import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class CounterServer {
	 public static  void main( String args[] ) {
	 		Scanner sc = new Scanner(System.in);
	    	 try { 
	             LocateRegistry.createRegistry(1099); 
	             System.out.println("java RMI registry created.");
	         } catch (RemoteException e) {
	        	 System.out.println( "Error: " + e );
	         }
	    	 System.out.println("Enter Your Value:"); 
	    	 int nm=sc.nextInt();
	    	 System.out.println(nm);
	         try {
	              CounterImpl p1 = new CounterImpl( nm);
	              Naming.rebind( "toaster", p1 );
	         }
	         catch( Exception e ) { System.out.println( "Error: " + e ); }
	     }
}
