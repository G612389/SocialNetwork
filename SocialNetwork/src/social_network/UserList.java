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
}
