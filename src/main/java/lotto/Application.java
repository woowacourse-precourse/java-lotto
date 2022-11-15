package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Game game = new Game();
            game.start();
        }catch(IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
