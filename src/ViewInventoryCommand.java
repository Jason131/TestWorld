public class ViewInventoryCommand extends Command {
    public ViewInventoryCommand() {
        super(player, game);
    }

    @Override
    void execute() {
        for (Item i:player.getItems()) {
            System.out.println(i.getName() + " ");
        }
    }
}
