/*Application to assign seats on each flight of an airline’s plane (capacity: 10 seats)
 *Please type 1 for First Class and Please type 2 for Economy
 *First class seats 1-5
 *Economy seats 6-10
 *Display boarding pass show seat No. and whether it’s first-class or economy
 *Use a one-dimensional array of primitive type boolean to represent the seating chart of the plane
 *Initialize all the elements of array to false to indicate that all seats are empty
 *As each seat is assigned, set corresponding element of array to true to indicate that the seat is 
 *no longer available
 *Application should never assign a seat that has already been assigned
 *When economy section is full, ask the person if it’s acceptable to be placed in  first-class (and vice versa)
 *If yes, make the appropriate seat assignment
 *If no, display the message "Next flight leaves in 3 hours."*/

import java.util.Scanner;

public class SeatReservation {
	Scanner sc=new Scanner(System.in);
	private boolean firstClassSeats[]=new boolean[5];
	private boolean economyClassSeats[]=new boolean[5];
	
	private int firstClassCount=0;
	private int economyClassCount=0;
	
	private int choice;
	
	public void booking(){
		System.out.println("Please type 1 for First class OR type 2 for Economy");
		choice=sc.nextInt();
		if(choice==1)
			firstClass();
		else if(choice==2)
			economyClass();
		else
			System.out.println("Invalid selection.");
	}
	
	private void firstClass(){
		if(firstClassCount<5){
			for(int i=0;i<firstClassSeats.length;i++){
				if(!firstClassSeats[i]){
					firstClassSeats[i]=true;
					System.out.printf("First Class. Seat No. %d\n",i+1);
					firstClassCount++;
					break;
				}
			}
		}
		else if(firstClassCount>=5 && economyClassCount<5){
			System.out.println("No more seats in First class. Enter 2 "
					+ "if you would like a seat in Economy class.");
			choice=sc.nextInt();
			if(choice==2)
				economyClass();
			else
				System.out.println("The next flight leaves in 3hrs.");
		}
		else
			System.out.println("All booked. The next flight leaves in 3hrs.");
	}
	
	private void economyClass(){
		if(economyClassCount<5){
			for(int i=0;i<economyClassSeats.length;i++){
				if(!economyClassSeats[i]){
					economyClassSeats[i]=true;
					System.out.printf("Economy Class. Seat No. %d\n",i+6);
					economyClassCount++;
					break;
				}
			}
		}
		else if(economyClassCount>=5 && firstClassCount<5){
			System.out.println("No more seats in Economy class. Enter 1 "
					+ "if you would like a seat in First class.");
			choice=sc.nextInt();
			if(choice==1)
				firstClass();
			else
				System.out.println("The next flight leaves in 3hrs.");	
		}
		else
			System.out.println("All booked. The next flight leaves in 3hrs.");
	}	
}
