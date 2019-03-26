import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<Node>();
    }

    public void addNode(String n) {
        nodes.add(new Node(n));
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n2.getNeighbor(name1));
    }

    public Node getNode(String name) {
        for (Node n : nodes) {
            if (n.getName().equals(name)) return n;
        }
        return null;
    }

    public class Node {
        private String name;
        private ArrayList<Node> neighbors;

        private Node(String name) {
            neighbors = new ArrayList<Node>();
            this.name = name;
        }

        private void addNeighbor(Node n) {
            neighbors.add(n);
        }

        public String getNeighborNames() {
            String output = "";
            for (Node n : neighbors) {
                output += n.getName();
                output += ", ";
            }
            if (!output.isEmpty()) return output.substring(0, output.length() - 2);
            else return null;
        }

        public Node getNeighbor(String name) {
            for (Node n : neighbors) {
                if (n.getName().equals(name)) return n;
            }

            return null;
        }

        public String getName() {
            return name;
        }
    }
}
