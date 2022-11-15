package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoStore.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
