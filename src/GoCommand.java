public class GoCommand extends Command {
    String nodeName;

    public GoCommand(String node) {
        super(player, game);
        nodeName = node;
    }

    @Override
    void execute() {
        Graph.Node n = player.getCurrentRoom().getNeighbor(nodeName);
        if (n != null) player.setCurrentRoom(n);
        for (Creature c : game.getAllCreatures()) {
            c.move(player);
            System.out.println(c.getType() + " is in " + c.getLocation().getName());
        }
    }
}
