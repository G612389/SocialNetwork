package social_network;

public class Relationship {
    private Profile firstUser;
    private Profile secondUser;

    public Relationship(Profile firstUser, Profile secondUser) {
        this.firstUser = firstUser;
        this.secondUser = secondUser;
    }

    public Relationship(String firstID, String secondID) {
        try {
            UserList userList = UserList.getInstance();
            new Relationship(userList.getProfileByID(firstID), userList.getProfileByID(secondID));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}
