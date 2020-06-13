package ArcoConsistentes;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	
	public static void main(String[] Args) {
		
		ArrayList<Node> disp = new ArrayList<Node>();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);


		
		disp.add(n1);
		disp.add(n2);
		disp.add(n3);
		disp.add(n4);
		disp.add(n4);

		
		
		n1.getTypes().add(Tipos.dos);
		n1.getTypes().add(Tipos.tres);
		n1.getTypes().add(Tipos.cuatro);
		
		n2.getTypes().add(Tipos.dos);
		
		n3.getTypes().add(Tipos.tres);
		n3.getTypes().add(Tipos.cuatro);
		
		n4.getTypes().add(Tipos.dos);
		n4.getTypes().add(Tipos.tres);
		n4.getTypes().add(Tipos.cuatro);
		
		n5.getTypes().add(Tipos.uno);

		
		Queue<Edge> cola = new LinkedBlockingQueue<Edge>();
		Edge e;
		Tipos t;

		cola.add(new Edge(n1, n2));
		cola.add(new Edge(n2, n1));
		
		cola.add(new Edge(n1, n4));
		cola.add(new Edge(n4, n1));
		
		cola.add(new Edge(n2, n3));
		cola.add(new Edge(n3, n2));
		
		cola.add(new Edge(n2, n4));
		cola.add(new Edge(n4, n2));
		
		
		cola.add(new Edge(n3, n4));
		cola.add(new Edge(n4, n3));
		

		
		while(!cola.isEmpty()) {
			e = cola.poll();
			System.out.println("Evaluando: " +  e.getN1().getId() + " y " + e.getN2().getId());
			if((t = consistentes(e.getN1(), e.getN2())) != null) {
				System.out.println("\t\tEliminnamos " + t.toString());
				e.getN1().getTypes().remove(Tipos.valueOf(t.toString()));
				for(Node n : disp) {
					if(n.getAdj().contains(e.getN1()) && n.equals(e.getN2()))
					cola.add(new Edge(n, e.getN1()));
				}
			}
			System.out.println();
			mostrarTipos(disp);
			System.out.println("/////////////////////////////////////////////////////////////////////////////\n");
		}
		
		mostrarTipos(disp);
		
	}
	
	public static Tipos consistentes(Node n1, Node n2) {
		boolean b = true;
		for(Tipos t : n1.getTypes()) {	
			b = false;
			for(Tipos t2 : n2.getTypes()) {
				System.out.println("\tEstudiamos " + t.toString() + " con "+ t2.toString());
				if(!t2.toString().equals(t.toString()) && restriccion(n1, n2)) {
					b=true;
					break;
				}
			}
			if(!b) {
				return Tipos.valueOf(t.toString());
			}
		}
		return null;	
	}

	public static boolean restriccion(Node n1, Node n2) {
		return true;
	}
	
	public static void mostrarTipos(ArrayList<Node> disp) {
		for(Node n : disp)
			System.out.println("X" + n.getId() + ": " + n.getTypes().toString());

	}
}
