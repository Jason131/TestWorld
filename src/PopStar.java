public class PopStar extends Creature {
    public PopStar(Graph.Node currentNode) {
        super(currentNode);
        this.currentRoom = currentNode;
    }

    @Override
    void move(Player p) {
        boolean hasMoved = false;
        for (Graph.Node pop : currentRoom.getNeighbors()) {
            if (pop == p.getCurrentRoom()) {
                currentRoom = pop;
                hasMoved = true;
            }
        }

        if (!hasMoved)
            currentRoom = currentRoom.getNeighbors().get((int) (Math.random() * currentRoom.getNeighbors().size()));

    }

    @Override
    String getType() {
        return "PopStar";
    }

    @Override
    Graph.Node getLocation() {
        return currentRoom;
    }
}
