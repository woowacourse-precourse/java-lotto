package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
