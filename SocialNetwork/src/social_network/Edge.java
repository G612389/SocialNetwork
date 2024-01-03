package social_network;

public class Edge {
    private String firstUserID;
    private String secondUserID;

    public Edge(String firstUserID, String secondUserID) {
        this.firstUserID = firstUserID;
        this.secondUserID = secondUserID;
    }

    public String getFirstUserID() {
        return this.firstUserID;
    }

    public String getSecondUserID() {
        return this.secondUserID;
    }

    public boolean equals(Edge otherEdge) {
        return (this.firstUserID.equals(otherEdge.getFirstUserID()) && this.secondUserID.equals(otherEdge.getSecondUserID())) || (this.firstUserID.equals(otherEdge.getSecondUserID()) && this.secondUserID.equals(otherEdge.getFirstUserID()));
    }

    public String toString() {
        return this.firstUserID + "," + this.secondUserID;
    }
}
