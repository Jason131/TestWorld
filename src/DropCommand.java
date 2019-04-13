public class DropCommand extends Command {
    String itemName;

    public DropCommand(String itemName) {
        super(player,game);
        this.itemName=itemName;
    }

    @Override
    void execute() {
        player.getCurrentRoom().addItem(player.removeItem(itemName));
    }
}
