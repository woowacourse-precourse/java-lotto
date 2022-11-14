package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoSimulator.run();
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
