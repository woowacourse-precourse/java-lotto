package lotto.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lotto.util.message.LottoExceptionMessageUtils;

public class LottoPurchaseAmount {

    private static final BigDecimal PRICE_OF_ONE = new BigDecimal("1000");
    private static final char VALID_NUMBER_START_CHARACTER = '0';
    private static final char VALID_NUMBER_END_CHARACTER = '9';

    private final BigDecimal playerPurchaseAmount;

    public LottoPurchaseAmount(String amountInput) {
        validatePlayerInputAmount(amountInput);

        this.playerPurchaseAmount = new BigDecimal(amountInput);
    }

    private void validatePlayerInputAmount(String amountInput) {
        validateNumber(amountInput);
        validateAmountUnit(amountInput);
    }

    private void validateAmountUnit(String playerInputAmount) {
        BigDecimal playerPurchaseAmount = new BigDecimal(playerInputAmount);

        if (playerPurchaseAmount.remainder(PRICE_OF_ONE).compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_PURCHASE_AMOUNT_UNIT
                            .findExceptionMessage(playerInputAmount));
        }
    }

    private void validateNumber(String playerInputAmount) {
        playerInputAmount
                .chars()
                .mapToObj(chars -> (char) chars)
                .filter(chars -> !isNumber(chars))
                .findAny()
                .ifPresent(input -> {
                    throw new IllegalArgumentException(
                            LottoExceptionMessageUtils.INVALID_NUMBER_FORMAT
                                    .findExceptionMessage(String.valueOf(input)));
                });
    }

    private boolean isNumber(char charInt) {
        return VALID_NUMBER_START_CHARACTER <= charInt && charInt <= VALID_NUMBER_END_CHARACTER;
    }

    public BigInteger calculatePurchaseLottoAmount() {
        return playerPurchaseAmount.divide(PRICE_OF_ONE, RoundingMode.FLOOR).toBigInteger();
    }
}
