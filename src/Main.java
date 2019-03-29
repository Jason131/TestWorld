import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", "a long dank hallway");
        g.addNode("closet", "where the corpses are kept");
        g.addNode("dungeon", "");

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

            if (response.substring(0, 4).equals("goTo")) {
                if (g.getNode(response.substring(5)) == null) {
                    System.out.println("Room does not exist");
                } else {
                    current = g.getNode(response.substring(5));
                }

            } else if (response.equals("look")) {
                if (current.getNeighborNames() == null) System.out.println("No further rooms");
                else System.out.println(current.getNeighborNames());

            } else if (response.substring(0, 3).equals("add")) {
                g.addNode(response.substring(8),"");
                current = g.getNode(response.substring(8));

            } else
                System.out.println("Possible commands: \"goTo <roomname>\"; \"look\"; \"addRoom <roomname>\"; \"quit\"");

        } while (!response.equals("quit"));
    }
}
