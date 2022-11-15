package lotto.model.resources;

import lotto.ExceptionHandle;

public class Money {

    private static final int CURRENCY = 1000;

    private final long money;

    public Money(String money) {
        validateMoney(money);
        this.money = Long.parseLong(money);
    }

    public long moneyDivide1000() {
        return money / CURRENCY;
    }

    private void validateMoney(String money) {
        long realMoney;
        try {
            realMoney = Long.parseLong(money);
        } catch (NumberFormatException e) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException ex) {
                throw new ExceptionHandle("[ERROR] 숫자를 입력해야 합니다. - Money");
            }
        }
        validateOverZero(realMoney);
        validateDivide1000(realMoney);
    }

    private void validateDivide1000(long realMoney) {
        try {
            if (dividableThousand(realMoney)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionHandle("[ERROR] 1000원 단위의 금액을 입력해야 합니다. - Money");
        }
    }

    private static boolean dividableThousand(long realMoney) {
        return realMoney % CURRENCY != 0;
    }

    private void validateOverZero(long realMoney) {
        try {
            if (realMoney < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new ExceptionHandle("[ERROR] 알맞은 금액을 입력하세요. - Money");
        }
    }
}
