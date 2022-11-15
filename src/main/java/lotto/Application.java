package lotto;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        try {
            LottoRunner.getLottoRunner().run();
        } catch (IllegalArgumentException exception) {
            System.out.println(ERROR_PREFIX + exception.getMessage());
        }
    }
}
