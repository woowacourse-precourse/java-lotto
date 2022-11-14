package lotto;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        try {
            lottoSystem.execute();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
