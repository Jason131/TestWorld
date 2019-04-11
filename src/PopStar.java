import java.util.ArrayList;

public class PopStar extends Creature {
    ArrayList<Graph.Node> path;
    boolean isNotInitialized = true;

    public PopStar(Graph.Node currentNode){
        super(currentNode);
        this.currentRoom = currentNode;
    }
    @Override
    void move(Player p) {
        if(isNotInitialized) {
            path = getPathToPlayer(currentRoom, p);
        }
        else {
            path = updatePathToPlayer(path, p);
        }
        currentRoom =
    }

    private ArrayList<Graph.Node> updatePathToPlayer(ArrayList<Graph.Node> path, Player p) {
        ArrayList<Graph.Node> updatedPath = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            updatedPath.add(path.get(i));

            if (path.get(i) == p.getCurrentRoom()) {
                return updatedPath;
            }
            for(Graph.Node node: path.get(i).getNeighbors()){
                if(node == p.getCurrentRoom()){
                    updatedPath.add(node);
                    return updatedPath;
                }
            }
        }
        return updatedPath;
    }
    private ArrayList<Graph.Node> getPathToPlayer(Graph.Node currentRoom, Player p) {
        ArrayList<Graph.Node> nodesToSearch = new ArrayList<>();
        nodesToSearch.add(currentRoom);
        ArrayList<Graph.Node> pathToPlayer = new ArrayList<>();
        pathToPlayer.add(currentRoom);

        Graph.findPathToPlayer(nodesToSearch, pathToPlayer, currentRoom);

        return pathToPlayer;
    }

    @Override
    String getType() {
        return null;
    }

    @Override
    Graph.Node getLocation() {
        return null;
    }
}
