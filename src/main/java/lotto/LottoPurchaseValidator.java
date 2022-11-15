package lotto;

/**
 * 로또 구매 금액의 유효성 검사
 */
public class LottoPurchaseValidator {

    public void validate(String buyingAMount) {
        try {
            this.validateMaxInteger(buyingAMount);

            int amount = Integer.parseInt(buyingAMount);

            this.validateNaturalNumber(amount);

            this.validateCanDivideByHunderd(amount);

            this.validateBelow1000(amount);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 21억원 이하의 1000 단위의 자연수만 허용됩니다.");
        }
    }

    private void validateMaxInteger(String buyingAMount) {
        // MAX_VALUE 초과 시 NumberFormatException 발생
        Integer.parseInt(buyingAMount);
    }

    private void validateNaturalNumber(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCanDivideByHunderd(int value) {
        if (value % 100 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBelow1000(int value) {
        if (value < 1000) {
            throw new IllegalArgumentException();
        }
    }
}
