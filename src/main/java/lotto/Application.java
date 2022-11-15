package lotto;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.init();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
