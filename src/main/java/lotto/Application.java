package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController.lottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
