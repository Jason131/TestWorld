import java.util.ArrayList;

public class Wumpus extends Creature {
    public Wumpus(Graph.Node currentNode) {
        super(currentNode);
        this.currentRoom = currentNode;
    }

    @Override
    void move(Player p) {
        ArrayList<Graph.Node> possiblePaths = currentRoom.getNeighbors();
        System.out.println(p.getCurrentRoom().getName());
        for (Graph.Node wumpus : currentRoom.getNeighbors()) {
            if (wumpus == p.getCurrentRoom()) {
                possiblePaths.remove(wumpus);
            }
        }

        if (!possiblePaths.isEmpty()) currentRoom = possiblePaths.get((int) (Math.random() * possiblePaths.size()));
        else currentRoom = currentRoom.getNeighbors().get((int) (Math.random() * currentRoom.getNeighbors().size()));

    }

    @Override
    String getType() {
        return "Wumpus";
    }

    @Override
    Graph.Node getLocation() {
        return currentRoom;
    }
}
