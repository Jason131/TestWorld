public class GoCommand extends Command {
    String nodeName;

    public GoCommand(Player player, String node) {
        super(player);
        nodeName = node;
    }

    @Override
    void execute() {
        player.setCurrentRoom(player.getCurrentRoom().getNeighbor(nodeName));
    }
}
