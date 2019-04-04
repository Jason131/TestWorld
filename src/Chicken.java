public class Chicken extends Creature {
    public Chicken(Graph.Node currentNode) {
        super(currentNode);
    }

    @Override
    void move() {
        int n = (int) (Math.random() * currentRoom.getNeighbors().size());
        currentRoom = currentRoom.getNeighbors().get(n);
    }
}
