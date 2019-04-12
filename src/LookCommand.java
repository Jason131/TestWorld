import java.util.ArrayList;

public class LookCommand extends Command {
    public LookCommand(Player player) {
        super(player);
    }

    @Override
    void execute() {
        ArrayList<Graph.Node> roomList = player.getCurrentRoom().getNeighbors();
        ArrayList<Item> itemList = player.getCurrentRoom().getItems();

        String out = "";
        for (Graph.Node n : roomList) {
            out += n.getName() + " ";
        }
        if (out.isEmpty()) System.out.println("You have hit a dead end.");
        else System.out.println("Possible paths: " + out);

        out = "";
        for (Item i : itemList) {
            out += i.getName() + " ";
        }
        for (Creature c : creatureList) {
            if (c.getLocation().getName().equalsIgnoreCase(player.getCurrentRoom().getName())) out += c.getType() + " ";
        }

        if (out.isEmpty()) System.out.println("This room appears to be empty.");
        else System.out.println("This room contains: " + out);

    }
}
