package lotto.model;

import lotto.TryCatchException;

public class Money {

    private static final int THOUSAND_WON = 1_000;
    private final Long money;

    public Money(String moneyStr){
        isNumeric(moneyStr);
        Long money = Long.parseLong(moneyStr);
        validateSign(money);
        validateThousand(money);
        this.money = money;
    }

    private void validateSign(Long money) {
        try {
            if (isNegative(money)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The money must be positive.");
        }
    }

    private void validateThousand(Long money) {
        try {
            if (!isThousands(money)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TryCatchException("[ERROR] The money must be divided by a thousand");
        }
    }

    private void isNumeric(String moneyStr) {
        try {
            Long.parseLong(moneyStr);
        } catch (NumberFormatException ignored) {
            try{
                throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                throw new TryCatchException("[ERROR] The money must be numeric.");
            }
        }
    }

    private static boolean isNegative(Long money) {
        return money < 0;
    }

    private static boolean isThousands(Long money) {
        return money % THOUSAND_WON == 0;
    }

    public Long countInThousands() {
        return this.money / THOUSAND_WON;
    }

    public Float toFloat() {
        return Float.valueOf(this.money);
    }
}
