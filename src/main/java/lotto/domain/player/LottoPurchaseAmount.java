package lotto.domain.player;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lotto.util.message.LottoExceptionMessageUtils;

public class LottoPurchaseAmount {

    private static final BigDecimal PRICE_OF_ONE = new BigDecimal("1000");
    private static final BigDecimal PERCENT_UNIT = new BigDecimal("100");
    private static final int PERCENT_SCALE = 1;

    private final BigDecimal playerPurchaseAmount;

    public LottoPurchaseAmount(String amountInput) {
        this.playerPurchaseAmount = calculatePlayerPurchaseAmount(amountInput);
    }

    private BigDecimal calculatePlayerPurchaseAmount(String amountInput) {
        BigDecimal inputPurchaseAmount;

        try {
            inputPurchaseAmount = new BigDecimal(amountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_FORMAT
                            .findExceptionMessage(String.valueOf(amountInput)));
        }
        validateAmountUnit(inputPurchaseAmount);

        return inputPurchaseAmount;
    }

    private void validateAmountUnit(BigDecimal inputPurchaseAmount) {
        if (!isValidAmountUnit(inputPurchaseAmount)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_PURCHASE_AMOUNT_UNIT
                            .findExceptionMessage(inputPurchaseAmount));
        }
    }

    private boolean isValidAmountUnit(BigDecimal playerPurchaseAmount) {
        return playerPurchaseAmount.remainder(PRICE_OF_ONE).compareTo(BigDecimal.ZERO) == 0;
    }

    public BigInteger calculatePurchaseLottoAmount() {
        return playerPurchaseAmount.divide(PRICE_OF_ONE, RoundingMode.FLOOR).toBigInteger();
    }

    public BigDecimal calculateRevenuePercent(BigDecimal totalReward) {
        return totalReward
                .multiply(PERCENT_UNIT)
                .divide(playerPurchaseAmount, PERCENT_SCALE, RoundingMode.HALF_UP);
    }
}
