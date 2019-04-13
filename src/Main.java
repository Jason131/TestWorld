import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();

        //adding nodes
        g.addNode("hall", "a long dank hallway");
        g.addNode("dungeon", "a waste of real estate");
        g.addUndirectedEdge("hall", "dungeon");
        g.addNode("bedroom", "where the bed is");
        g.addUndirectedEdge("bedroom", "hall");
        g.addNode("bathroom", "it's a bathroom, nothing more");
        g.addUndirectedEdge("bathroom", "bedroom");
        g.addNode("closet", "where the corpses are kept");
        g.addUndirectedEdge("bathroom", "closet");

        //adding items
        g.getNode("closet").addItem(new Item("corpse", "can be used as fertilizer"));
        g.getNode("bedroom").addItem(new Item("chair", "can sit on it"));

        //adding creatures
        g.addCreature(new Chicken(g.getNode("bedroom")));
        g.addCreature(new PopStar(g.getNode("bathroom")));
        g.addCreature(new Wumpus(g.getNode("bathroom")));

        Player p = new Player("Bob", "Noob");
        p.setCurrentRoom(g.getNode("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("You are currently in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");
            System.out.println("Possible commands: \"look\"; \"inventory\"; \"goTo roomName\"; \"add roomName\"; \"take itemName\"; \"drop itemName\"; \"getDescription itemName\"; \"quit\" ");

            Command command;


            response = s.nextLine();
            command = Command.parseCommand(response, p, g);
            if (command != null) command.execute();

        } while (!response.equals("quit"));
    }
}
