package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            new PlayLottoGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
