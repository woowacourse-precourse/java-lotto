package lotto.aspect;

public class Validator {

    public static void checkDivisiblePayment(final int payment, final int price) {
        if (payment <= 0) {
            throw new IllegalArgumentException(String.format("[ERROR] Lotto는 개당 %d원 입니다. 금액이 부족합니다.", price));
        }

        if (payment % price != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] Lotto는 개당 %d원 입니다. 정확한 금액을 지불해주세요.", price));
        }
    }

}
