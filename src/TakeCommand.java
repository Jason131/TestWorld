public class TakeCommand extends Command {
    String item;

    public TakeCommand(String itemName) {
        super(player,game);
        item = itemName;
    }

    @Override
    void execute() {
        player.addItem(player.getCurrentRoom().removeItem(item));
    }
}
