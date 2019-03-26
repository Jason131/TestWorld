import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall");
        g.addNode("closet");
        g.addNode("dungeon");

        g.addDirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");

        Graph.Node current = g.getNode("hall");

        String response = "";
        Scanner s = new Scanner(System.in);

        System.out.println("Possible commands: \"goTo <roomname>\"; \"look\"; \"addRoom <roomname>\"; \"quit\"");

        do {
            System.out.println("You are currently in the " + current.getName());
            System.out.println("What do you want to do? >");
            response = s.nextLine();

            if (response.substring(0, 4).equals("goTo")) current = g.getNode(response.substring(5));
            else if (response.substring(0, 4).equals("look")) System.out.println(current.getNeighborNames());
            else if (response.substring(0, 3).equals("add")) {
                g.addNode(response.substring(9));
                current = g.getNode(response.substring(8));
            }
            else System.out.println("Possible commands: \"goTo <roomname>\"; \"look\"; \"addRoom <roomname>\"; \"quit\"");

        } while (!response.equals("quit"));
    }
}
