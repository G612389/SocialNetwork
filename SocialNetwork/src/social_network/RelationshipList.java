package social_network;

/**
 * This class represents a list of relationships between users in a social network.
 * The maximum number of relationships between 100 users is 5050 (100 choose 2).
 * The RelationshipList class contains an array of Relationship objects and keeps track of its size.
 * 
 * @author G612389
 * @version DSA_2023_2024
 * @see Relationship
 */
public class RelationshipList {
    private static RelationshipList relationshipListInstance = null;
    private Relationship[] relationshipList;
    private int size;

    /**
     * This class represents a list of relationships between users in a social network.
     * The maximum number of relationships between 100 users is 5050 (100 choose 2).
     * The RelationshipList class contains an array of Relationship objects and keeps track of its size.
     */
    private RelationshipList() {
        this.relationshipList = new Relationship[5050]; // Max number of relationships between 100 users is 5050 (100 choose 2)
        this.size = 0;
    }

    /**
     * Singleton approach to ensure that there is only one instance of the list.
     * 
     * @return the singleton instance of the RelationshipList class
     */
    public static RelationshipList getInstance() {
        if (relationshipListInstance == null) {
            relationshipListInstance = new RelationshipList();
        }
        return relationshipListInstance;
    }

    /**
     * Adds a new relationship to the list.
     * 
     * @param relationship the relationship to be added
     * @throws IllegalArgumentException if the relationship already exists or the list is full
     */
    public void addRelationship(Relationship relationship) {
        if (this.size < 5050) {
            // Check if the relationship already exists
            // I know, I know, this is not efficient at all but I don't want to be stuck here all day
            // I'll fix it later™
            for (int i = 0; i < this.size; i++) {
                if (this.relationshipList[i].equals(relationship)) {
                    System.out.println("Found a relationship that already existed. Skipping...");
                }
            }
            
            this.relationshipList[this.size] = relationship;
            this.size++;
        } else {
            throw new IllegalArgumentException("Relationship list is full");
        }
    }

    /**
     * Returns an array of Relationship objects representing the relationships in this RelationshipList.
     *
     * @return an array of Relationship objects representing the relationships in this RelationshipList
     */
    public Relationship[] getRelationshipList() {
        return this.relationshipList;
    }

    /**
     * Returns the number of relationships in this RelationshipList.
     *
     * @return the number of relationships in this RelationshipList
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns an array of Relationship objects that involve the specified user.
     * 
     * @param user the Profile object representing the user to search for
     * @return an array of Relationship objects involving the specified user
     */
    public Relationship[] getRelationshipsByUser(Profile user) {
        Relationship[] relationships = new Relationship[100];
        int relationshipsSize = 0;

        for (int i = 0; i < this.size; i++) {
            if (this.relationshipList[i].getFirstUser().equals(user) || this.relationshipList[i].getSecondUser().equals(user)) {
                relationships[relationshipsSize] = this.relationshipList[i];
                relationshipsSize++;
            }
        }

        return relationships;
    }

    /**
     * Returns an array of Relationship objects associated with the given user ID.
     * 
     * @param userID the ID of the user to retrieve relationships for
     * @return an array of Relationship objects associated with the given user ID
     * @throws IllegalArgumentException if the given user ID is invalid
     */
    public Relationship[] getRelationshipsByUser(String userID) {
        try {
            UserList userList = UserList.getInstance();
            return this.getRelationshipsByUser(userList.getProfileByID(userID));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    /**
     * Prints the list of relationships in the RelationshipList object.
     */
    public void printRelationshipList() {
        System.out.println("Relationship list size: "+this.size);
        System.out.println("Relationship list:");
        for (int i = 0; i < this.size; i++) {
            if (this.relationshipList[i] == null) {
                System.out.println("NULL");
                continue;
            }
            System.out.println(this.relationshipList[i].toString());
        }
    }
}