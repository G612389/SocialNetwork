package social_network;

/**
 * The UserList class represents a list of user profiles in a social network.
 * It is implemented as a singleton to ensure that there is only one instance of the list.
 * The maximum size of the list is 100.
 * 
 * @author G612389
 * @version DSA_2023_2024
 * @see Profile
 */
public class UserList {
    private static UserList userListInstance = null;
    private Profile[] userList;
    private int size;

    /**
     * Constructs a new UserList object with an initial capacity of 100 and size of 0.
     */
    private UserList() {
        this.userList = new Profile[100];
        this.size = 0;
    }

    /**
     * Returns the singleton instance of the UserList class.
     * If the instance does not exist, it creates a new one.
     *
     * @return the singleton instance of the UserList class
     */
    public static UserList getInstance() {
        if (userListInstance == null) {
            userListInstance = new UserList();
        }
        return userListInstance;
    }
    
    /**
     * Adds a profile to the user list.
     * 
     * @param profile the profile to add
     * @throws IllegalArgumentException if the user list is full or if the profile already exists in the list
     */
    public void addProfile(Profile profile) {
        if (this.size < 100) {
            // Check if the profile already exists
            for (int i = 0; i < this.size; i++) {
                if (this.userList[i].equals(profile)) {
                    throw new IllegalArgumentException("Profile already exists");
                }
            }
            
            this.userList[this.size] = profile;
            this.size++;
        } else {
            throw new IllegalArgumentException("User list is full");
        }
    }

    /**
     * Returns the profile of the user with the specified ID.
     * @param ID the ID of the user whose profile is to be returned
     * @return the profile of the user with the specified ID
     * @throws IllegalArgumentException if the specified ID is invalid
     */
    public Profile getProfileByID(String ID) {
        for (int i = 0; i < this.size; i++) {
            if (this.userList[i].getID().equals(ID)) {
                return this.userList[i];
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }

    /**
     * Returns an array of Profile objects representing all the users in the user list.
     *
     * @return an array of Profile objects representing all the users in the user list
     */
    public Profile[] getUserList() {
        return this.userList;
    }

    /**
     * Returns the number of users in the UserList.
     *
     * @return the number of users in the UserList
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Prints the list of users in the UserList object.
     */
    public void printUserList() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.userList[i].toString());
        }
    }

    /**
     * Prints the user information for the user with the given ID.
     * @param ID the ID of the user to print information for
     */
    public void printUserByID(String ID) {
        for (int i = 0; i < this.size; i++) {
            if (this.userList[i].getID().equals(ID)) {
                System.out.println(this.userList[i].toString());
            }
        }
    }

    /**
     * Prints the relationships for the user with the given surname.
     * @param surname the surname of the user to print relationships for
     */
    public void printRelationshipsBySurname(String surname) {
        for (int i = 0; i < this.size; i++) {
            if (this.userList[i].getLastName().equals(surname)) {
                Relationship[] relationshipList = RelationshipList.getInstance().getRelationshipsByUser(this.userList[i]);
                System.out.println("Relationships for user @"+this.userList[i].getID());
                for (int j = 0; j < relationshipList.length; j++) {
                    if (relationshipList[j] == null) {
                        continue;
                    }
                    System.out.println(relationshipList[j].toString());
                }
            }
        }
    }
    
    /**
     * Prints the users in the user list who were born in the specified birthplace.
     * @param birthplace the birthplace to print users for
     */
    public void printPeopleByBirthplace(String birthplace) {
        for (int i = 0; i<this.size; i++){
            if (this.userList[i].getBirthPlace().equalsIgnoreCase(birthplace)) {
                System.out.println(this.userList[i].toString());
            }
        }
    }

    /**
     * Prints the users in the user list who were born between the specified dates.
     * @param d1 the lower bound of the date range
     * @param d2 the upper bound of the date range
     */
    public void getPeopleBetweenDates(int d1, int d2) {
        Profile[] profiles = new Profile[this.size];
        int profileCount = 0;

        for (int i = 0; i < this.size; i++) {
            int birthYear = Integer.parseInt(this.userList[i].getBirthDate().split("-")[2]);

            // Profile is between the dates
            if (birthYear >= d1 && birthYear <= d2) {
                // Save profile in temporary array
                profiles[profileCount] = this.userList[i];
                profileCount++;
            }
        }

        // Sort the profiles by surname and then by name
        for (int i = 0; i < profileCount; i++) {
            Profile tempProfile = profiles[i];
            int j = i - 1;
            while (j >= 0 && profiles[j].getLastName().compareTo(tempProfile.getLastName()) > 0) {
                profiles[j + 1] = profiles[j];
                j--;
            }
            profiles[j + 1] = tempProfile;
        }

        // Print the sorted profiles
        for (int i = 0; i < profileCount; i++) {
            System.out.println(profiles[i].toString());
        }
    }

    // TODO: Fix this method
    // Won't write anything into the console
    public void getPeopleByHometown(String hometown) {
        for (int i = 0; i < this.size; i++) {
            System.out.println(hometown+" "+i);
            if (userList[i].getHomeTown().equals(hometown)) {
                System.out.println(userList[i].toString());
            }
        }
    }

    /**
     * Prints a list of people grouped by their hometown.
     */
    public void printPeopleByHometownList() {
        FileLoader fl = new FileLoader();
        String[] homeTowns = fl.loadResidential();
        for (int i = 0; i < homeTowns.length; i++) {
            if (homeTowns[i] == null) {
                break;
            }
            System.out.println("People from " + homeTowns[i]);
            getPeopleByHometown(homeTowns[i]);
        }
    }
}
