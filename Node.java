package ArcoConsistentes;

import java.util.ArrayList;

public class Node {
	
	int id;
	ArrayList<Node> adj;
	ArrayList<Tipos> types;


	public Node(int id) {
		this.id = id;
		adj = new ArrayList<Node>();
		types = new ArrayList<Tipos>();

	}

	
	public boolean equals(Node arg0) {
		return (this.id == arg0.getId())?true:false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Node> getAdj() {
		return adj;
	}

	public void setAdj(ArrayList<Node> adj) {
		this.adj = adj;
	}

	public ArrayList<Tipos> getTypes() {
		return types;
	}


	public void setTypes(ArrayList<Tipos> types) {
		this.types = types;
	}
	
	
	

	
	
}
