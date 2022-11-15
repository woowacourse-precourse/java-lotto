package lotto;

public class Application {
    public static LottoApplication lottoApplication = new LottoApplication();

    public static void main(String[] args) {
        try {
            lottoApplication.lottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
