package lotto.exception;

import java.util.regex.Pattern;

public class BuyMoneyException {
    private static final Pattern IsOnlyNumber = Pattern.compile("^[0-9]*?");

    public void notNumber(String money) {
        try {
            if (money.isEmpty() || !IsOnlyNumber.matcher(money).matches()) {
                throw new IllegalArgumentException("[ERROR] 숫자 외의 값이 입력되었습니다.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void notDivideThousands(String money) {
        try {
            if ((Integer.parseInt(money) % 1000) != 0) {
                throw new IllegalArgumentException("[ERROR] 1000 단위 입력이 아닙니다.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

            e.printStackTrace();
            throw e;
        }
    }

    public void fullException(String money) {
        notNumber(money);
        notDivideThousands(money);
    }
}
