public class Chicken extends Creature {
    public Chicken(Graph.Node currentNode) {
        super(currentNode);
        this.currentRoom = currentNode;
    }

    @Override
    void move(Player player) {
        int n = (int) (Math.random() * currentRoom.getNeighbors().size());
        currentRoom = currentRoom.getNeighbors().get(n);
    }

    @Override
    String getType() {
        return "chicken";
    }

    @Override
    Graph.Node getLocation() {
        return currentRoom;
    }
}
