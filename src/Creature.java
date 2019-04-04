public abstract class Creature extends Entity {
    public Creature(Graph.Node currentRoom) {
        super(currentRoom);
    }

    abstract void move();

    abstract String getType();
    abstract Graph.Node getLocation();
}
