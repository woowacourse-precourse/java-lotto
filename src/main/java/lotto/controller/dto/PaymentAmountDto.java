package lotto.controller.dto;

public class PaymentAmountDto {

    private final int paymentAmount;

    public PaymentAmountDto(String paymentAmount) {
        this.paymentAmount = checkPaymentAmount(paymentAmount);
    }

    private int checkPaymentAmount(String paymentAmount) {
        validInteger(paymentAmount);
        return 0;
    }

    private void validInteger(String paymentAmount) {
        boolean isInteger = paymentAmount.chars()
                .allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 지불금액에 정수값이 아닌 값이 포함되어 있습니다.");
        }
    }

}
