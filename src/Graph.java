import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    //private List<Node> nodes;
    private HashMap<String, Node> nodes;

    public Graph() {
        nodes = new HashMap<String, Node>();
    }

    public void addNode(String n, String description) {
        Node node = new Node(n, description);
        nodes.put(n, node);
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);

    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public class Node {
        private String name;
        private String description;
        private ArrayList<Node> neighbors;
        private ArrayList<Item> items;

        private Node(String name, String description) {
            neighbors = new ArrayList<Node>();
            items = new ArrayList<Item>();
            this.name = name;
            this.description = description;
        }

        private void addNeighbor(Node n) {
            neighbors.add(n);
        }

        public String getNeighborNames() {
            String output = "";
            for (Node n : neighbors) {
                output += n.getName() + " ";
            }

            return output;
        }

        public ArrayList<Node> getNeighbors() {
            return neighbors;
        }

        public Node getNeighbor(String name) {
            for (Node n : neighbors) {
                if (n.getName().equalsIgnoreCase(name)) return n;
            }

            return null;
        }

        public String getName() {
            return name;
        }

        public Item getItem(String name) {
            for (Item i : items) {
                if (i.getName().equalsIgnoreCase(name)) return i;
            }

            return null;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void addItem(Item i) {
            items.add(i);
        }

        public Item removeItem(String name) {
            for (Item i : items) {
                if (i.getName().equalsIgnoreCase(name)) {
                    Item out = i;
                    items.remove(i);
                    return out;
                }
            }

            return null;
        }
    }
}
