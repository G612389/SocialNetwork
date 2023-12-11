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
        if (this.size < this.getUserList().length) {
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
     */
    public Profile getProfileByID(String ID) {
        for (int i = 0; i < this.size; i++) {
            if (this.userList[i].getID().equals(ID)) {
                return this.userList[i];
            }
        }
        // No profile found
        System.out.println("Invalid ID detected. Skipping... (ID: " + ID + ")");

        // Return null if no profile is found
        return null;
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
        // Loop through the user list
        for (int i = 0; i < this.size; i++) {
            // Check if the user's surname matches the specified surname
            if (this.userList[i].getLastName().equals(surname)) {
                // Get the relationships for the user
                Relationship[] relationshipList = RelationshipList.getInstance().getRelationshipsByUser(this.userList[i]);
                System.out.println("Relationships for user @"+this.userList[i].getID());
                // Print the relationships
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
        // Loop through the user list
        for (int i = 0; i < this.size; i++){
            // Check if the user's birthplace matches the specified birthplace
            if (this.userList[i].getBirthPlace().equalsIgnoreCase(birthplace)) {
                // Print the user
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
        // Create a temporary array to store the profiles
        Profile[] profiles = new Profile[this.size];
        // Create a counter to keep track of the number of profiles
        int profileCount = 0;

        // Loop through the user list
        for (int i = 0; i < this.size; i++) {
            // Get the birth year of the profile
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
            // Get the profile at index i
            Profile tempProfile = profiles[i];
            int j = i - 1;
            // Loop through the profiles before the current profile
            while (j >= 0 && profiles[j].getLastName().compareTo(tempProfile.getLastName()) > 0) {
                // Move the profiles up one index
                profiles[j + 1] = profiles[j];
                j--;
            }
            // Insert the profile at the correct index
            profiles[j + 1] = tempProfile;
        }

        // Print the sorted profiles
        for (int i = 0; i < profileCount; i++) {
            System.out.println(profiles[i].toString());
        }
    }

    /**
     * Prints the users in the user list who are from the specified hometown.
     * @param hometown the hometown to print users for
     */
    public void getPeopleByHometown(String hometown) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            // Check if the user's hometown matches the specified hometown
            if (userList[i].getHomeTown().equalsIgnoreCase(hometown)) {
                // Print the user
                count++;
                System.out.println(userList[i].toString());
            }
        }
        if (count == 0) {
            System.out.println("No users found from " + hometown);
        }
    }

    /**
     * Prints a list of people grouped by their hometown.
     */
    public void printPeopleByHometownList() {
        FileLoader fl = new FileLoader();
        // Get the list of hometowns from the file loader
        String[] homeTowns = fl.loadResidential();
        // Loop through the hometown list
        for (int i = 0; i < homeTowns.length; i++) {
            // Check if the end of the list has been reached
            if (homeTowns[i] == null) {
                break;
            }

            System.out.println("People from " + homeTowns[i]);
            getPeopleByHometown(homeTowns[i]);
        }
    }

    /**
     * Print if both users have the same liked films
     * @param user1 First user
     * @param user2 Second user
     */
    public void printSameProfile(String user1, String user2) {
        Profile pr = getProfileByID(user1);
        Profile pr2 = getProfileByID(user2);

        if (pr.hasSameProfile(pr2)) {
            System.out.println(user1 + " & " + user2 + " have the same profile!");
        } else {
            System.out.println(user1 + " & " + user2 + " don't have the same profile!");
        }
    }


    /**
     * Print users that like the same films as the input
     * @param userID User to check films for
     */
    public void printSameProfile(String userID) {
        Profile pr = getProfileByID(userID);
        int count = 0;

        for (Profile profile : this.userList) {
            // Prevention of NullPointerException
            if (profile == null) break;

            // Check if both ID are different (same profile would always return true for hasSameProfile() method)
            if (!userID.equals(profile.getID())) {
                if (pr.hasSameProfile(profile)) {
                    System.out.println(userID + " & " + profile.getID());
                    count++;
                }
            }
        }

        if (count == 0) System.out.println("No users found with the same profile.");
    }
}
