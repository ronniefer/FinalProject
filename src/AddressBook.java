import java.util.ArrayList;

public class AddressBook {
	
	ArrayList<Entry> myList = new ArrayList<Entry>();
	
	public void addEntry(Entry newEntry) {
		
		if (searchAddressBook("4", newEntry.getEmailAddress()).isEmpty()) {
			this.myList.add(newEntry);
			System.out.println("\nAdded new entry!\n");
		} else {
			System.out.println("\nEmail address has to be unique\n");
		}
	}

	public void removeEntry(String targetEmail) {
		
		Entry entryForRemoval;
		
		if (!searchAddressBook("4", targetEmail).isEmpty()) {
			entryForRemoval = searchAddressBook("4", targetEmail).get(0);
			int index = this.myList.indexOf(entryForRemoval);
			this.myList.remove(index);
			System.out.println("\nDeleted the following entry:\n");
			System.out.println(entryForRemoval.toString());
		} else {
			System.out.println("\nEmail address not found\n");
		}
	}
	
    public ArrayList<Entry> searchAddressBook(String searchBy, String searchValue) {
    	
        ArrayList<Entry> resultList = new ArrayList<Entry>();
        
        for (Entry entry : myList) {
        	
            String found = "";
            
            switch (searchBy) {
                case "1": 
                	found = entry.getFirstName();
                case "2": 
                	found = entry.getLastName();
                case "3": 
                	found = entry.getPhoneNumber();
                case "4": 
                	found = entry.getEmailAddress();
            }

            if (found.contains(searchValue)) {
            	resultList.add(entry);
            }
        }
        
        return resultList;
    }
}
