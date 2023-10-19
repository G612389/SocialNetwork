package social_network;


/**
 * The Relationship class represents a relationship between two profiles in a social network.
 * A Relationship object can be constructed with two Profile objects or two Profile IDs.
 * Two Relationship objects are considered equal if they have the same firstUser and secondUser, regardless of the order.
 * 
 * @author G612389
 * @version DSA_2023_2024
 * @see Profile
 */
public class Relationship {
    private Profile firstUser;
    private Profile secondUser;

    /**
     * Constructs a Relationship object with two Profile objects representing the first and second users.
     *
     * @param firstUser the first user in the relationship
     * @param secondUser the second user in the relationship
     */
    public Relationship(Profile firstUser, Profile secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }

    /**
     * Constructs a Relationship object with two Profile IDs representing the first and second users.
     *
     * @param firstID the ID of the first user in the relationship
     * @param secondID the ID of the second user in the relationship
     */
    public Relationship(String firstID, String secondID) {
        try {
            UserList userList = UserList.getInstance();
            Profile firstUser = userList.getProfileByID(firstID);
            Profile secondUser = userList.getProfileByID(secondID);
            if (firstUser == null || secondUser == null) {
                System.out.println("Invalid ID detected in the following relationship: "+firstID+","+secondID);
                return;
            }
            this.firstUser = firstUser;
            this.secondUser = secondUser;
        } catch (Exception e) {
            System.out.println("Invalid ID detected in the following relationship: "+firstID+","+secondID);
        }
    }

    /**
     * Returns the first user in the relationship.
     *
     * @return the first user in the relationship
     */
    public Profile getFirstUser() {
        return this.firstUser;
    }

    /**
     * Returns the second user in the relationship.
     *
     * @return the second user in the relationship
     */
    public Profile getSecondUser() {
        return this.secondUser;
    }

    /**
     * Compares this Relationship object to another Relationship object for equality.
     * Two Relationship objects are considered equal if they have the same firstUser and secondUser, regardless of the order.
     *
     * @param relationship the Relationship object to compare to
     * @return true if the two Relationship objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Relationship)) {
            return false;
        }
        Relationship relationship = (Relationship) obj;
        return (this.firstUser != null && this.firstUser.equals(relationship.getFirstUser()) && this.secondUser != null && this.secondUser.equals(relationship.getSecondUser())) || (this.firstUser != null && this.firstUser.equals(relationship.getSecondUser()) && this.secondUser != null && this.secondUser.equals(relationship.getFirstUser()));
    }

    /**
     * Checks if the relationship between two profiles is equal to this relationship.
     *
     * @param firstID the ID of the first profile
     * @param secondID the ID of the second profile
     * @return true if the relationship between the two profiles is equal to this relationship, false otherwise
     * @throws IllegalArgumentException if either of the IDs is invalid
     */
    public boolean equals(String firstID, String secondID) {
        try {
            UserList userList = UserList.getInstance();
            return this.equals(new Relationship(userList.getProfileByID(firstID), userList.getProfileByID(secondID)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    /**
     * Returns a string representation of the relationship, which consists of the IDs of the first and second users
     * separated by a space.
     *
     * @return a string representation of the relationship
     */
    @Override
    public String toString() {
        String firstUserID = firstUser != null ? firstUser.getID() : "null";
        String secondUserID = secondUser != null ? secondUser.getID() : "null";
        return firstUserID + " " + secondUserID;
    }
}
