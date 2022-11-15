package lotto;

import java.util.NoSuchElementException;

public class Exeption {
    public static void inputMoneyExeption(String money) {
        if (!money.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("[ERROR]");
            throw new NoSuchElementException("[ERROR] 숫자가 아닙니다.");
        }

        int moneyCheck = Integer.parseInt(money);
        // 1,000 으로 나누어 떨어지지 않을 때
        if (moneyCheck % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000으로 나누어 떨어지지 않습니다.");
        }
        if (money.equals("0")) {
            throw new IllegalArgumentException("[ERROR] 0을 입력하시면 안됩니다.");
        }
    }
}
