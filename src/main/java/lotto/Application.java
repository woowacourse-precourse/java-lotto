package lotto;

import java.util.List;

public class Application {
    private final int moneyUnit = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public List<Integer> createLotto(int money) {
        return null;
    }

    private void validMoney(int money) {
        if (money < moneyUnit || money % moneyUnit != 0) {
            throw new IllegalArgumentException();
        }
    }
}
