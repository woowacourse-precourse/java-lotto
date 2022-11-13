package lotto;

public class Application {
    private final int moneyUnit = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public void getLotto(int money) {

    }

    private void validMoney(int money) {
        if (money < moneyUnit || money % moneyUnit != 0) {
            throw new IllegalArgumentException();
        }
    }
}
