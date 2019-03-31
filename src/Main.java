import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode("hall", "a long dank hallway");
        g.addNode("closet", "where the corpses are kept");
        g.addNode("dungeon", "a waste of real estate");

        g.addDirectedEdge("hall", "closet");
        g.addDirectedEdge("hall", "dungeon");

        g.getNode("hall").getNeighbor("closet").addItem(new Item("corpse", "can be used as fertilizer"));

        Player p = new Player("Bob", "Noob");
        p.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Possible commands: \"goTo <roomname>\"; \"look\"; \"addRoom <roomname>\"; \"take <itemname>\"; \"drop <itemname>\"; \"quit\"");
            System.out.println("You are currently in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do? >");
            response = s.nextLine();

            if (response.substring(0, 4).equalsIgnoreCase("goto")) {
                String room = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                p.setCurrentRoom(g.getNode(room));

            } else if (response.equalsIgnoreCase("look")) {
                ArrayList<Item> itemList = p.getCurrentRoom().getItems();
                String out = "";
                for (Item i : itemList) {
                    out += i.getName() + " ";
                }
                if(out.isEmpty()) System.out.println("There are no items in this room");
                else System.out.println(out);

            } else if (response.substring(0, 3).equalsIgnoreCase("add")) {
                String room = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                g.addNode(room, "");
                g.addDirectedEdge(p.getCurrentRoom().getName(), room);
                p.setCurrentRoom(g.getNode(room));

            } else if (response.substring(0, 4).equalsIgnoreCase("take")) {
                String item = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                p.addItem(p.getCurrentRoom().removeItem(item));

            } else if (response.substring(0, 4).equalsIgnoreCase("drop")) {
                String item = response.substring(response.indexOf("<") + 1, response.indexOf(">"));
                p.getCurrentRoom().addItem(p.removeItem(item));

            }
        } while (!response.equals("quit"));
    }
}
