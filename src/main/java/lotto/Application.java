package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame game = new GameContext().lottoGame();
        
        game.start();
    }
}
