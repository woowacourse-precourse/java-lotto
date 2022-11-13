package lotto.aspect;

public class PaymentValidator {

    public static void validateNumberFormat(final String payment) {
        for (char current : payment.toCharArray()) {
            if (current < '0' || current > '9') {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 금액이 있습니다.");
            }
        }
    }

    public static void validatePayment(final long payment, final int price) throws IllegalArgumentException {
        validateEnough(payment, price);
        validateDivisiblePayment(payment, price);
    }

    private static void validateEnough(final long payment, final int price) throws IllegalArgumentException {
        if (payment <= price) {
            throw new IllegalArgumentException(String.format("[ERROR] Lotto는 개당 %d원 입니다. 금액이 부족합니다.", price));
        }
    }

    private static void validateDivisiblePayment(final long payment, final int price) throws IllegalArgumentException {
        if (payment % price != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] Lotto는 개당 %d원 입니다. 정확한 금액을 지불해주세요.", price));
        }
    }

}
