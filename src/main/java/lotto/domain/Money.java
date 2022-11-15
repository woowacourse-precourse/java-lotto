package lotto.domain;

public class Money {
    private final int amount;

    public Money(String amount) {
        this.amount = validate(amount);
    }

    private int validate(String stringAmount) {
        try {
            int amount = Integer.parseInt(stringAmount);
            if (amount % LottoSettings.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(String.format(ErrorMessage.NOT_DEVIDED_BY_LOTTO_PIRCE_ERROR_MESSAGE, LottoSettings.LOTTO_PRICE));
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_IS_NOT_INT_ERROR_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }
}
