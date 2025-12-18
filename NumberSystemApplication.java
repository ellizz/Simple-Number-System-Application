/**
 * The Big Bang Conversion program allows a user to convert numbers between 
 * different number systems, such as binary, decimal, octal, and hexadecimal.
 *
 * Made by: Albert Edward F. Jacinto
 */
 
 
 //Packages that will be used
import java.util.Scanner;

public class NumberSystemApplication {
	public static void main(String[] args) {
		
		// Initialize the scanner for user input
		Scanner sc = new Scanner(System.in);
		
		// Data types and Variables that will be used
		String choice, tempnum = "0", sys = "system";
		int tempdeci = 0;
		
		// Continuously loops the program unless user breaks it
		while (true) { 
			
			// Variables that will initiliazed as 0 everytime loop restarts
			int ext = 0, ext2 = 0;
			
			// Print the main menu options
			System.out.print(
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"		  The Big Bang Conversion\n" +
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"[1]Binary				[4]Hexadecimal\n" +
				"[2]Decimal				[5]Exit\n" +
				"[3]Octal\n\n" +
				"What number system would you like to be converted?\n" +
				"Choose from 1-5: ");
			choice = sc.next();
			System.out.println();
			
			// Use a switch statement to determine the selected number system
			switch (choice) {
				case ("1"):
					sys = "Binary";
					System.out.print("Enter a Binary number: ");
					tempnum = sc.next();
					try {
						tempdeci = Integer.parseInt(tempnum, 2); // Converts the input into a temporary decimal variable
						
					} catch (NumberFormatException e) { // Catches the error if user failed to put a valid number
						ext = 1;
					}
					break;
					
				case ("2"):
					sys = "Decimal";
					System.out.print("Enter a Decimal number: ");
					tempnum = sc.next();
					try {
						tempdeci = Integer.parseInt(tempnum, 10); // Converts the input into a temporary decimal variable
						
					} catch (NumberFormatException e) { // Catches the error if user failed to put a valid number
						ext = 1;
					}
					break;
					
				case ("3"):
					sys = "Octal";
					System.out.print("Enter an Octal number: ");
					tempnum = sc.next();
					try {
						tempdeci = Integer.parseInt(tempnum, 8); // Converts the input into a temporary decimal variable
						
					} catch (NumberFormatException e) { // Catches the error if user failed to put a valid number
						ext = 1;
					}
					break;
					
				case ("4"):
					sys = "Hexadecimal";
					System.out.print("Enter a Hexadecimal number: ");
					tempnum = sc.next();
					tempnum = tempnum.toUpperCase();
					try {
						tempdeci = Integer.parseInt(tempnum, 16); // Converts the input into a temporary decimal variable
						
					} catch (NumberFormatException e) { // Catches the error if user failed to put a valid number
						ext = 1;
					}
					break;
					
				case ("5"): // Exits the program
					ext2 = 1;
					break;
					
				default: // Loops back to the start if user failed to input properly
					System.out.println("Invalid Input");
					continue;
			}
			
			// Check if the input is not a valid number for the selected system
			// and asks the user if they want to try again
			if (ext == 1) {
				System.out.print(
					"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					tempnum + " is not a valid " + sys + " number\n" +
					"Cannot proceed\n" +
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
					"Want to convert something else?(y/n): ");
				choice = sc.next();
				System.out.println();
				
				switch (choice.toLowerCase()) {
					case ("y"):
					case ("yes"):
						continue;
						
					case ("n"):
					case ("no"):
						ext2 = 1;
						break;
						
					default:
						System.out.print("\nInvalid Input! Terminating...");
						ext2 = 1;
						break;
				}
			} 
			
			// Ends the loop and directs to End Card
			if (ext2 == 1) {
				break;
			}
			
			// Converts the temporary decimal variable into their specific string numuber systems.
			String bina = Integer.toString(tempdeci, 2);
			String deci = Integer.toString(tempdeci, 10);
			String octa = Integer.toString(tempdeci, 8);
			String hexa = Integer.toString(tempdeci, 16);
			hexa = hexa.toUpperCase();
			
			// Asks the user what number system they want to do convert their number to
			System.out.print(
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"		Your " + sys + " number: " + tempnum +
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
				"[1]Binary				[4]Hexadecimal\n" +
				"[2]Decimal				[5]All\n" +
				"[3]Octal\n\n" +
				"What number system would you like your number to be converted to?\n" +
				"Choose from 1-5: ");
			choice = sc.next();
			
			System.out.print(
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
			if (choice.equals("1")) { 	// Displays Binary result only
				System.out.print(
					"Your " + sys + " number: " + tempnum +
					"\nConverted to Binary: " + bina);
					
			} else if (choice.equals("2")) { 	// Displays Decimal result only
				System.out.print(
					"Your " + sys + " number: " + tempnum +
					"\nConverted to Decimal: " + deci);
					
			} else if (choice.equals("3")) {	// Displays Octal result only
				System.out.print(
					"Your " + sys + " number: " + tempnum +
					"\nConverted to Octal: " + octa);
					
			} else if (choice.equals("4")) {	// Displays Hexadecimal result only
				System.out.print(
					"Your " + sys + " number: " + tempnum +
					"\nConverted to Hexadecimal: " + hexa);
					
			} else if (choice.equals("5")) {	// Displays every result
				System.out.print(
					"Your " + sys + " number: " + tempnum + "\n" +
					"\nConverted to Binary: " + bina +
					"\nConverted to Decimal: " + deci +
					"\nConverted to Octal: " + octa +
					"\nConverted to Hexadecimal: " + hexa);
					
			} else { // User fails to enter a valid input
				System.out.print("Invalid Input");
			}
			
			System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
			//Asks the user if they want to convert again
			System.out.print("Would you like to convert something else?(Y/N): ");
			choice = sc.next();
			
			switch (choice.toLowerCase()) {
				case ("y"):
				case ("yes"):
					System.out.println();
					continue;
					
				case ("n"):
				case ("no"):
					break;
					
				default:
					System.out.print("\nInvalid Input! Terminating...");
					break;
			}
			
			break;
			
		} // End of loop
		
		// End Card
		System.out.println(
			"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
			"			Thank you for using\n" +
			"		  The Big Bang Conversion\n" +
			"				  Goodbye\n" +
			"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
	}
}