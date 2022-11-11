package lotto.domain;

public class NumberOfLottos {

    private static final int MIN_PRICE_AMOUNT = 1000;
    private static final String MONETARY_UNIT_ERR_MESSAGE = "[ERROR] 화폐 단위가 옳지 않습니다.";
    private static final String MIN_PRICE_ERR_MESSAGE = "[ERROR] 금액은 최소 1,000원이어야 합니다.";

    public NumberOfLottos() {
    }

    public int calculateNumberOfLottos(int price) {
        validatePriceAmount(price);
        return price / MIN_PRICE_AMOUNT;
    }

    private void validatePriceAmount(int price) {
        validateDivisible(price);
        validateMinPrice(price);
    }

    private void validateDivisible(int price) {
        if (price % MIN_PRICE_AMOUNT != 0) {
            throw new IllegalArgumentException(MONETARY_UNIT_ERR_MESSAGE);
        }
    }

    private void validateMinPrice(int price) {
        if (price < MIN_PRICE_AMOUNT) {
            throw new IllegalArgumentException(MIN_PRICE_ERR_MESSAGE);
        }
    }
}