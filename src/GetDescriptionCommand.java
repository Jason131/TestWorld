public class GetDescriptionCommand extends Command {
    String itemName;

    public GetDescriptionCommand(String itemName) {
        super(player, game);
        this.itemName = itemName;
    }

    @Override
    void execute() {
        System.out.println(player.getItem(itemName).getDescription());
    }
}
