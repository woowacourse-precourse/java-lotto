package lotto;

public class Application {
    private static final int LOTTO_BUY_CURRENCY = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    /**
     * 예외 처리를 위한 편의 기능
     */
    public static boolean isValidMoney(int money) {
        return money % LOTTO_BUY_CURRENCY == 0;
    }
}
