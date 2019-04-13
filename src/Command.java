public abstract class Command {
    static Player player;
    static Graph game;

    public Command(Player player, Graph game) {
        this.player = player;
        this.game = game;
    }

    public static Command parseCommand(String response, Player p, Graph g) {
        player = p;
        game = g;

        String commandWord = getFirstWordIn(response);

        if (commandWord.equalsIgnoreCase("look")) return new LookCommand();
        else if (commandWord.equalsIgnoreCase("goto")) {
            String nodeName = getLastWordIn(response);
            return new GoCommand(nodeName);
        } else if (commandWord.equalsIgnoreCase("take")) {
            String itemName = getLastWordIn(response);
            return new TakeCommand(itemName);
        } else if (commandWord.equalsIgnoreCase("drop")) {
            String itemName = getLastWordIn(response);
            return new DropCommand(itemName);
        } else if (commandWord.equalsIgnoreCase("getdescription")) {
            String itemName = getLastWordIn(response);
            return new GetDescriptionCommand(itemName);
        } else if (commandWord.equalsIgnoreCase("inventory")) {
            return new ViewInventoryCommand();
        } else if (commandWord.equalsIgnoreCase("add")) {
            String nodeName = getLastWordIn(response);
            return new AddNodeCommand(nodeName);
        }

        return null;
    }

    private static String getLastWordIn(String response) {
        String[] words = response.split(" ");
        if (!response.isEmpty()) return words[words.length - 1];
        else return null;
    }

    private static String getFirstWordIn(String response) {
        String[] words = response.split(" ");
        if (!response.isEmpty()) return words[0];
        else return null;
    }

    abstract void execute();

}
