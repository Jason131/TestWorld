public class GoCommand extends Command {
    String nodeName;

    public GoCommand(String node) {
        super(player, game);
        nodeName = node;
    }

    @Override
    void execute() {
        player.setCurrentRoom(player.getCurrentRoom().getNeighbor(nodeName));
        for (Creature c : game.getAllCreatures()) {
            c.move(player);
            System.out.println(c.getType() + " is in " + c.getLocation().getName());
        }
    }
}
