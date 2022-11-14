package lotto;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        try {
            lottoSystem.execute();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
    }
}
