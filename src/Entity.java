public abstract class Entity {
    public Graph.Node currentRoom;

    public Entity(Graph.Node currentRoom) {
        this.currentRoom = currentRoom;
    }

    protected Entity() {
    }
}
