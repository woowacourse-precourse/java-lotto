package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame.run();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
