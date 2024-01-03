package social_network;

public class GraphNode {
    private Edge[] edges;
    private int edgeCount;
    private String userID;

    public GraphNode(String userID) {
        this.userID = userID;
        this.edges = new Edge[RelationshipList.getInstance().getRelationshipsByUser(userID).length];
        this.edgeCount = 0;
    }

    public String getUserID() {
        return this.userID;
    }

    public Edge[] getEdges() {
        return this.edges;
    }

    public int getEdgeCount() {
        return this.edgeCount;
    }

    public void addEdge(Edge edge) {
        this.edges[this.edgeCount] = edge;
        this.edgeCount++;
    }

    public boolean edgeExists(String otherUserID) {
        for (int i = 0; i < this.edgeCount; i++) {
            if (this.edges[i].getSecondUserID().equals(otherUserID)) {
                return true;
            }
        }
        return false;
    }
}
