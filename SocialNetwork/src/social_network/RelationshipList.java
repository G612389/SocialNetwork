package social_network;

public class RelationshipList {
    private static RelationshipList relationshipListInstance = null;
    private Relationship[] relationshipList;
    private int size;

    private RelationshipList() {
        this.relationshipList = new Relationship[5050]; // Max number of relationships between 100 users is 5050 (100 choose 2)
        this.size = 0;
    }

    public static RelationshipList getInstance() {
        if (relationshipListInstance == null) {
            relationshipListInstance = new RelationshipList();
        }
        return relationshipListInstance;
    }

    public void addRelationship(Relationship relationship) {
        if (this.size < 5050) {
            // Check if the relationship already exists
            // I know, I know, this is not efficient at all but I don't want to be stuck here all day
            // I'll fix it later™
            for (int i = 0; i < this.size; i++) {
                if (this.relationshipList[i].equals(relationship)) {
                    throw new IllegalArgumentException("Relationship already exists");
                }
            }
            
            this.relationshipList[this.size] = relationship;
            this.size++;
        } else {
            throw new IllegalArgumentException("Relationship list is full");
        }
    }
}
