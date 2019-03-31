import java.util.ArrayList;

public class Player {
    private String name, desription;
    private ArrayList<Item> items;
    private Graph.Node currentRoom;

    public Player(String name, String description) {
        this.name = name;
        this.desription = description;
        items = new ArrayList<Item>();
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public Item removeItem(String name) {
        for (Item i:items) {
            if(i.getName().equalsIgnoreCase(name)) {
                Item out = i;
                items.remove(i);
                return out;
            }
        }

        return null;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Graph.Node getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Graph.Node newroom) {
        this.currentRoom = newroom;
    }
}
