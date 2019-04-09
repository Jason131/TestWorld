public abstract class Command {
    Player player;

    public Command(Player player) {
        this.player = player;
    }

    public Command parseCommand(String response) {
        String commandWord = getFirstWordIn(response);

        if(commandWord.equalsIgnoreCase("look")) return new LookCommand(player);

        else if(commandWord.equalsIgnoreCase("goto")) {
            String node = getLastWord(response);
            return new GoCommand(player,node);
        }

        else if(commandWord.equalsIgnoreCase("take")) {
            String itemName = getLastWord(response);
            return new TakeCommand(player, itemName);
        }

        return null;
    }

    private String getLastWord(String response) {
        String[] words = response.split(" ");
        if(!response.isEmpty()) return words[words.length-1];
        else return null;
    }

    private String getFirstWordIn(String response) {
        String[] words = response.split(" ");
        if(!response.isEmpty()) return words[0];
        else return null;
    }

    abstract void execute();

}
