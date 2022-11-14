package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController game = new GameController();

        game.buyLotto();
        game.drawLotto();
        game.getResult();


    }
}
