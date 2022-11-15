package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        try {
            gameController.gameStarter();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]");
        }
    }
}
