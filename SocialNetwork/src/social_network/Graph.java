package social_network;

import java.util.*;

public class Graph {
	private int vertices;
	private int edges;
	private GraphNode[] graphNodes;

	/**
	 * Represents a graph data structure.
	 */
	public Graph() {
		this.vertices = 0;
		this.edges = 0;
		this.graphNodes = new GraphNode[UserList.getInstance().getSize()];
	}

	/**
	 * Returns the number of vertices in the graph.
	 *
	 * @return the number of vertices
	 */
	public int getVertices() {
		return this.vertices;
	}

	/**
	 * Returns the number of edges in the graph.
	 *
	 * @return the number of edges
	 */
	public int getEdges() {
		return this.edges;
	}

	/**
	 * Returns an array of GraphNode objects representing the nodes in the graph.
	 *
	 * @return an array of GraphNode objects
	 */
	public GraphNode[] getGraphNodes() {
		return this.graphNodes;
	}

	/**
	 * Adds a vertex with the given userID to the graph.
	 * 
	 * @param userID the unique identifier for the vertex
	 * @return true if the vertex is successfully added, false otherwise
	 */
	public boolean addVertex(String userID) {
		/* Check if vertex array is full */
		if (this.vertices < this.graphNodes.length) {
			/* Check if vertex already exists */
			for (int i = 0; i < this.vertices; i++) {
				if (this.graphNodes[i].getUserID().equals(userID)) {
					return false;
				}
			}

			/* Add vertex to the array */
			this.graphNodes[this.vertices] = new GraphNode(userID);
			this.vertices++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Adds an edge between two users in the graph.
	 * 
	 * @param firstUserID  the ID of the first user
	 * @param secondUserID the ID of the second user
	 * @return true if the edge was successfully added, false otherwise
	 */
	public boolean addEdge(String firstUserID, String secondUserID) {
		/* Check if vertex array is full */
		if (this.vertices < this.graphNodes.length) {
			/* Create GraphNode objects */
			GraphNode firstGraphNode = null;
			GraphNode secondGraphNode = null;

			/* Find GraphNode objects in array */
			for (int i = 0; i < this.vertices; i++) {
				if (this.graphNodes[i].getUserID().equals(firstUserID)) {
					firstGraphNode = this.graphNodes[i];
				} else if (this.graphNodes[i].getUserID().equals(secondUserID)) {
					secondGraphNode = this.graphNodes[i];
				}
			}

			/* Check if GraphNode objects were found */
			if (firstGraphNode != null && secondGraphNode != null) {
				/* Check if edge already exists */
				if (!firstGraphNode.edgeExists(secondUserID)) {
					firstGraphNode.addEdge(new Edge(firstUserID, secondUserID));
					secondGraphNode.addEdge(new Edge(secondUserID, firstUserID));
					this.edges++;
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Returns the shortest path between two profiles in the social network graph.
	 * The path is represented as a list of profile IDs.
	 * The method uses Breadth-First Search (BFS) algorithm to find the path.
	 *
	 * @param pr1 the starting profile
	 * @param pr2 the target profile
	 * @return the shortest path between the two profiles, or an empty list if no path exists
	 */
	public List<String> getShortestPath(Profile pr1, Profile pr2) {
		// Create a queue for BFS
		LinkedList<List<String>> queue = new LinkedList<>();
	
		// Create a set to store visited profiles
		HashSet<String> visited = new HashSet<>();
	
		// Path for the first profile
		List<String> initialPath = new ArrayList<>();
		initialPath.add(pr1.getID());
	
		// Add the initial path to the queue
		queue.add(initialPath);
	
		// Mark the first profile as visited
		visited.add(pr1.getID());
	
		while (!queue.isEmpty()) {
			// Dequeue a path from the queue
			List<String> path = queue.poll();
		
			// Get the last profile from the path
			String lastProfile = path.get(path.size() - 1);
		
			// If the last profile is the target profile, return the path
			if (lastProfile.equals(pr2.getID())) {
				return path;
			}
		
			// Get all relationships of the last profile
			Relationship[] relationships = RelationshipList.getInstance().getRelationshipsByUser(lastProfile);
			for (Relationship relationship : relationships) {
				if (relationship == null) {
					continue;
				}
		
				// Get the ID of the second user in the relationship
				String secondUserID = relationship.getOtherUser(UserList.getInstance().getProfileByID(lastProfile)).getID();
		
				// If the second user hasn't been visited yet, create a new path and enqueue it
				if (!visited.contains(secondUserID)) {
					List<String> newPath = new ArrayList<>(path);
					newPath.add(secondUserID);
					queue.add(newPath);
		
					// Mark the second user as visited
					visited.add(secondUserID);
				}
			}
		}
	
		// If no path was found, return an empty list
		return new ArrayList<>();
	}

	/**
	 * Returns a list of profiles representing a path from the first profile (pr1) to the second profile (pr2) in the graph.
	 * The method uses Depth-First Search (DFS) algorithm to find the path.
	 *
	 * @param pr1 The first profile.
	 * @param pr2 The second profile.
	 * @return A list of profiles representing the path from pr1 to pr2, or an empty list if no path is found.
	 */
	public List<String> getOtherPath(Profile pr1, Profile pr2) {
		// Create a stack for DFS
		Stack<List<String>> stack = new Stack<>();

		// Create a set to store visited profiles
		HashSet<String> visited = new HashSet<>();

		// Path for the first profile
		List<String> initialPath = new ArrayList<>();
		initialPath.add(pr1.getID());

		// Add the initial path to the stack
		stack.push(initialPath);

		// Mark the first profile as visited
		visited.add(pr1.getID());

		while (!stack.isEmpty()) {
			// Pop a path from the stack
			List<String> path = stack.pop();

			// Get the last profile from the path
			String lastProfile = path.get(path.size() - 1);

			// If the last profile is the target profile, return the path
			if (lastProfile.equals(pr2.getID())) {
				return path;
			}

			// Get all relationships of the last profile
			Relationship[] relationships = RelationshipList.getInstance().getRelationshipsByUser(lastProfile);
			for (Relationship relationship : relationships) {
				if (relationship == null) {
					continue;
				}

				// Get the ID of the second user in the relationship
				String secondUserID = relationship.getOtherUser(UserList.getInstance().getProfileByID(lastProfile)).getID();

				// If the second user hasn't been visited yet, create a new path and push it
				if (!visited.contains(secondUserID)) {
					List<String> newPath = new ArrayList<>(path);
					newPath.add(secondUserID);
					stack.push(newPath);

					// Mark the second user as visited
					visited.add(secondUserID);
				}
			}
		}

		// If no path was found, return an empty list
		return new ArrayList<>();
	}
}
