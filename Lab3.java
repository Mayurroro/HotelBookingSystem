import java.util.Scanner;

public class Lab3 {

	//implement a 2D array as Rows be floors and columns in the rows bo Rooms

	

	//taking initial input of rooms

	public static int[][] Hotel(){

		Scanner sc = new Scanner(System.in);

		System.out.println("How much floor does Hotel has:");

		int floor = sc.nextInt();
        sc.nextLine();
		System.out.println("How much Rooms does single floor consist:");

		int room = sc.nextInt();
        sc.nextLine();
		int [][] rooms = new int[floor][room];

		for (int i=0;i<floor;i++) {

			for (int j=0;j<room;j++) {

				System.out.println("Is floor:"+i+" Room"+j+ " Available?" );

				String input = sc.nextLine().trim();

				if (input.equalsIgnoreCase("yes")) {

					rooms[i][j] = 0;

				}

				else {

					rooms[i][j] = 1;

				}

			}

		}

		return rooms;

	}

	

	//Viewing function

	public static void view(int [][] arr) { 
		int rows = arr.length;

		int col = arr[0].length;
        System.out.println("0 Represents room is Available and 1 Represents room is Booked:");

		for (int i=0;i <rows; i++) {
            System.out.print("floor " +i+ ": ");
			for (int j=0;j <col; j++) {

				System.out.printf(arr[i][j] + " ");

			}
            System.out.println(); // Move to next line after each floor
		}

	}


    //function for booking
    public static void book(int [][] arr) {
        Scanner sc = new Scanner(System.in);
        int row = arr.length;
        int col = arr[0].length;
        System.out.println("Before booking do you want to view the rooms? (yes/no)");
        String viewInput = sc.nextLine().trim();
        if(viewInput.equalsIgnoreCase("yes")) {
            view(arr);
            
        }
        System.out.println("Choose the floor and the room by entering (separate by ' 'space).");
        boolean validInput = true;
        while (validInput) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                int floor = Integer.parseInt(parts[0]);
                int room = Integer.parseInt(parts[1]);
                if (floor >= 0 && floor < row && room >= 0 && room < col) {
                    if (arr[floor][room] == 0) {
                        arr[floor][room] = 1; // Mark the room as booked
                        System.out.println("Room booked successfully.");
                    } else {
                        System.out.println("Room is already booked.");
                    }
                    validInput = false;
                }   
                }
                  
            else{
                System.out.println("Invalid input. Please enter floor and room number separated by space.");
            }
                
        }
            
    }
        
       

	public static void main (String []arge) {

		Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hotel Booking System");

        System.out.println("Please enter the details of the hotel:");
		int [][] arr = Hotel();

		

		boolean con = true;

		while(con!= false) {

			System.out.println("Enter the task(Viewing/booking/exit)");

			String input = sc.nextLine();

			try {

				if(input.equalsIgnoreCase("viewing")) {
                    //calling viewing function
                    view(arr);
				}
                else if(input.equalsIgnoreCase("booking")) {
                    //calling booking function
                    book(arr);
                }
                else if(input.equalsIgnoreCase("exit")) {
                    con = false;
                }

			}

			catch(Exception e) {

				System.out.println("***Enter valid task***");

			}

		}

	}
}