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
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n2.getNeighbor(name1));
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public class Node {
        private String name;
        private ArrayList<Node> neighbors;
        private ArrayList<Entity> items, creatures;
        private String description;

        private Node(String name, String description) {
            neighbors = new ArrayList<Node>();
            items = new ArrayList<Entity>();
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
                if (n.getName().equals(name)) return n;
            }

            return null;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Entity> getItems() {
            return items;
        }

        public void addItem(Item i) {
            items.add(i);
        }

        public void addEntity(Entity x) {
            creatures.add(x);
        }

        public Entity removeItem(String name) {
            for (Entity i : items) {
                if (i.getName().equalsIgnoreCase(name)) {
                    Entity out = i;
                    items.remove(i);
                    return out;
                }
            }

            return null;
        }
    }
}
