import java.util.Scanner;

public class SeatReservationTest {
	static boolean running=true;
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		SeatReservation reservist=new SeatReservation();
		
		while(running){
			reservist.booking();
			
			System.out.println("Type 'Quit' to exit, else any key to continue.");
			String optOut=sc.next();
			
			if(optOut.equalsIgnoreCase("Quit"))
				running=false;
		}
		sc.close();
	}
}
