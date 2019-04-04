import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", "a long dank hallway");
        g.addNode("closet", "where the corpses are kept");
        g.addNode("dungeon", "a waste of real estate");

        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("hall", "dungeon");

        g.getNode("hall").getNeighbor("closet").addItem(new Item("corpse", "can be used as fertilizer"));
        g.getNode("hall").addItem(new Item("chair", "can sit on it"));

        List<Creature> creatureList = new ArrayList<Creature>();
        Creature a = new Chicken(g.getNode("hall"));
        Creature b = new Chicken(g.getNode("hall"));
        creatureList.add(a);
        creatureList.add(b);

        Player p = new Player("Bob", "Noob");
        p.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("You are currently in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");
            System.out.println("Possible commands: \"look\";  \"view inventory\"; \"goTo <roomname>\"; \"addRoom <roomname>\"; \"take <itemname>\"; \"drop <itemname>\"; \"getDescription <itemname>\"; \"\" ;\"quit\" >");

            response = s.nextLine();

            if (response.substring(0, 4).equalsIgnoreCase("goto")) {
                String room = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                p.setCurrentRoom(g.getNode(room));
                for (Creature c : creatureList) {
                    c.move();
                }

            } else if (response.equalsIgnoreCase("look")) {
                ArrayList<Graph.Node> roomList = p.getCurrentRoom().getNeighbors();
                ArrayList<Item> itemList = p.getCurrentRoom().getItems();

                String out = "";
                for (Graph.Node n :
                        roomList) {
                    out += n.getName() + " ";
                }
                if (out.isEmpty()) System.out.println("You have hit a dead end.");
                else System.out.println("Possible paths: " + out);

                out = "";
                for (Item i : itemList) {
                    out += i.getName() + " ";
                }
                for (Creature c : creatureList) {
                    if(c.getLocation().getName().equalsIgnoreCase(p.getCurrentRoom().getName())) out += c.getType() + " ";
                }
                if (out.isEmpty()) System.out.println("This room appears to be empty.");
                else System.out.println("This room contains: " + out);

            } else if (response.equalsIgnoreCase("view inventory")) {
                String out = "";
                for (Item i : p.getItems()) {
                    out += i.getName() + " ";
                }
                System.out.println(out);

            } else if (response.substring(0, 3).equalsIgnoreCase("add")) {
                String room = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                g.addNode(room, "");
                g.addDirectedEdge(p.getCurrentRoom().getName(), room);
                p.setCurrentRoom(g.getNode(room));

            } else if (response.substring(0, 4).equalsIgnoreCase("take")) {
                String entity = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                p.addItem(p.getCurrentRoom().removeItem(entity));

            } else if (response.substring(0, 4).equalsIgnoreCase("drop")) {
                String item = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                p.getCurrentRoom().addItem(p.removeItem(item));

            } else if (response.substring(0, 14).equalsIgnoreCase("getDescription")) {
                String item = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                System.out.println(p.getItem(item).getDescription());
            }

        } while (!response.equals("quit"));
    }
}
