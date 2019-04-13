public class ViewInventoryCommand extends Command {
    public ViewInventoryCommand() {
        super(player, game);
    }

    @Override
    void execute() {
        String out = "";
        for (Item i : player.getItems()) {
            out += i.getName() + " ";
        }
        if(out.isEmpty()) System.out.println("You do not have anything in your possession");
        else System.out.println(out);
    }
}
