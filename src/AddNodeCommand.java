public class AddNodeCommand extends Command {
    String nodeName;

    public AddNodeCommand(String nodeName) {
        super(player, game);
        this.nodeName = nodeName;
    }

    @Override
    void execute() {
        game.addNode(nodeName,"");
        game.addUndirectedEdge(player.getCurrentRoom().getName(),nodeName);
        player.setCurrentRoom(player.getCurrentRoom().getNeighbor(nodeName));
    }
}
