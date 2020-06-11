
import java.util.Scanner;


public class TestCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter c1 = new Counter(10);

		Scanner sc = new Scanner(System.in);
		int choice = 1;
		while(choice!=4)
			{

                // insert **try {**  here



			System.out.println();
			System.out.println("1.Increment");
			System.out.println("2.Decrement");
			System.out.println("3.Read Value");
			System.out.println("4.Exit");

			System.out.print("Please enter a value-->");
			choice =sc.nextInt();
		
			if(choice==1)
			{
				try{
					c1.increment();
					System.out.println("Value = " + c1.read_value());
				}catch(TooHighException e) {
					System.out.println("Too High");
				}
				 
			}
			else if(choice==2)
			{
				try{
					c1.decrement();
					System.out.println("Value = " + c1.read_value());
				}catch(TooLowException e) {
					System.out.println("Too Low");
				}
			}
			else if(choice==3)
			{
				int res=c1.read_value();
				System.out.println("Value = "+res);
			}

                 // insert  close of try   ***}*** here
    
                 //  insert catch statements here



			}  // end while

	}

}
