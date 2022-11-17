package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        try {
            game.run();
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
