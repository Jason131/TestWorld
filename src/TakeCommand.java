public class TakeCommand extends Command {
    String item;

    public TakeCommand(Player player, String itemName) {
        super(player);
        item = itemName;
    }

    @Override
    void execute() {
        player.addItem(player.getCurrentRoom().getItem(item));
    }
}
