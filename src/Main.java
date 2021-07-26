import java.util.ArrayList;
import java.util.Scanner;

public class Main {
            
    public static void main(String[] args) {   
    	
    	AddressBook myAddressBook = new AddressBook();
    	Scanner userInput = new Scanner(System.in);
    	boolean stayOn = true;
       
        

    	 while (stayOn) {
        	System.out.println ("\n*** Address Book ***\n");
        	
        	System.out.println ("1) Add an entry");
			System.out.println ("2) Remove an entry");
			System.out.println ("3) Search for a specific entry");
			System.out.println ("4) Print Address Book");
			System.out.println ("5) Delete Book");
			System.out.println ("6) Quit\n");
			
			System.out.print ("Please choose what you'd like to do with the database: ");
            
			//int menuChoice = userInput.nextInt();
			String menuChoice = userInput.nextLine();
			
            switch (menuChoice) {
                //case 1:
                case "1":
                    System.out.println("First name: ");
                    String newFirstName = userInput.nextLine();
                    System.out.println("Last name: ");
                    String newLastName = userInput.nextLine();
                    System.out.println("Phone number: ");
                    String newPhoneNumber = userInput.nextLine();
                    System.out.println("Email address: ");
                    String newEmailAddress = userInput.nextLine();

                    Entry newEntry = new Entry(newFirstName, newLastName, newPhoneNumber, newEmailAddress);
                    myAddressBook.addEntry(newEntry);   
                    System.out.println("Press enter to continue...");
                    userInput.nextLine();                    
                    break;
                    
                case "2":
                	System.out.println("\nEnter an entry's email to remove: ");
                	String targetEmail = userInput.next();
                	myAddressBook.removeEntry(targetEmail); 
                	break;
                	
                case "3":
                	System.out.println("\n1) First name");
                	System.out.println("2) Last name");
                	System.out.println("3) Phone Number");
                	System.out.println("4) Email Address\n");
                	System.out.println("Chose a search type: ");
                    String searchChoice = userInput.nextLine();
                    System.out.println("Enter your search: ");
                    String searchTerm = userInput.nextLine();
                    System.out.println(myAddressBook.searchAddressBook(searchChoice, searchTerm));                                
                    break;
                	
                case "4":
                	if (myAddressBook.myList.isEmpty()) {
                		System.out.println("\nAddress Book is empty!");
                	} else {
                    	System.out.println("\n" + myAddressBook.myList);
                    	System.out.println("Press enter to continue...");
                    	userInput.nextLine();
                	}
                	break;
                	
                case "5":
                	myAddressBook.myList.clear();
                	System.out.println("\nBook deleted\n");
                	System.out.println("Press enter to continue...");
                	userInput.nextLine();
                	break;
                	
                case "6":
                	userInput.close();
                	stayOn = false;
                	break;
            }
        }
        
        System.out.println ( "Goodbye!");
    }
}