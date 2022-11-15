package lotto.domain;

public class LottoPurchaseAmount {
    private static final int zero = 0;
    private static final int MIN_COST = 1000;
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 천 단위 숫자만 입력 가능합니다.";
    private static final String NOT_DIVISIBLE_BY_THOUSAND_ERROR = "[ERROR] 금액은 " + MIN_COST + "원 단위로 입력해야 합니다.";

    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validateInputMoney(amount);
        this.amount = amount; 
    }

    public int calculateNumberOfLottoTickets() {
        return amount / MIN_COST;
    }

    private void validateInputMoney(int amount) {
        isAmountLessThanZero(amount);
        isDivisibleByThousand(amount);
    }

    private void isAmountLessThanZero(int amount) {
        if (amount <= zero) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }

    private void isDivisibleByThousand(int amount) {
        if (amount % MIN_COST != zero) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND_ERROR);
        }
    }
}
