package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Exception {
    protected static void validatePayMoney(String payMoney) {
        emptyException(payMoney);
        numericException(payMoney);
        if (Long.parseLong(payMoney) % 1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1,000 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    protected static void validateBonusBall(String bonus, Lotto lotto) {
        emptyException(bonus);
        numericException(bonus);
        if (lotto.getNumbers().contains(Integer.parseInt(bonus))) {
            System.out.println("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(bonus) < 0 || Integer.parseInt(bonus) > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    protected static void validateComputerLotto(String computerLotto) {
        emptyException(computerLotto);

        String[] numbers = computerLotto.split(",");
        for(String number : numbers) {
            numericException(number);
        }
    }

    private static void emptyException(String input) {
        if ("".equals(input)) {
            System.out.println("[ERROR] 공란입니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void numericException(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("[ERROR] 숫자 형식이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
