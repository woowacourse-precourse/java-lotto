package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
