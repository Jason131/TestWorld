import java.util.ArrayList;

public class Wumpus extends Creature {
    public Wumpus(Graph.Node currentNode) {
        super(currentNode);
        this.currentRoom = currentNode;
    }

    @Override
    void move(Player p) {
        ArrayList<Graph.Node> possiblePaths = currentRoom.getNeighbors();
        for (Graph.Node wumpus:currentRoom.getNeighbors()) {
            for(Graph.Node player:p.getCurrentRoom().getNeighbors()) {
                if(wumpus == player) {
                    possiblePaths.remove(wumpus);
                }
            }
        }

        currentRoom = possiblePaths.get((int)(Math.random()*possiblePaths.size()));
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
