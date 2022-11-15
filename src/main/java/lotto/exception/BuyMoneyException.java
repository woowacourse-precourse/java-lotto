package lotto.exception;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class BuyMoneyException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[0-9]*?");
    private static final String NOT_NUMBER = "[ERROR] 숫자 외의 값이 입력되었습니다.";
    private static final String NOT_DIVIDE = "[ERROR] 1000 단위 입력이 아닙니다.";

    public void notNumber(String money) {
        if (!IsOnlyNumber.matcher(money).matches()) {
            System.out.println(NOT_NUMBER);
            throw new NoSuchElementException(NOT_NUMBER);
        }
    }

    public void notDivideThousands(String money) {
        if ((Integer.parseInt(money) % 1000) != 0) {
            throw new IllegalArgumentException(NOT_DIVIDE);
        }
    }

    public void fullException(String money) {
        notNumber(money);
        notDivideThousands(money);
    }
}
