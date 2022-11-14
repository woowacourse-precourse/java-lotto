package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGameConsole lottoGameConsole = new LottoGameConsole();
            lottoGameConsole.startLottoGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
