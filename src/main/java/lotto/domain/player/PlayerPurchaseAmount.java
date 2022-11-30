package lotto.domain.player;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;

public class PlayerPurchaseAmount {

    private static final BigDecimal PRICE_OF_ONE = new BigDecimal(LottoConst.PURCHASE_AMOUNT);
    private static final BigDecimal PERCENT_UNIT = new BigDecimal("100");
    private static final int PERCENT_SCALE = 1;

    private final BigDecimal playerPurchaseAmount;

    public PlayerPurchaseAmount(BigDecimal amountInput) {
        validatePlayerInputAmount(amountInput);

        this.playerPurchaseAmount = amountInput;
    }

    private void validatePlayerInputAmount(BigDecimal playerPurchaseAmount) {
        validateMinAmount(playerPurchaseAmount);
        validateAmountUnit(playerPurchaseAmount);
    }

    private void validateMinAmount(BigDecimal playerPurchaseAmount) {
        if (playerPurchaseAmount.compareTo(PRICE_OF_ONE) < 0) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_PURCHASE_AMOUNT_VALUE.findFullMessage());
        }
    }

    private void validateAmountUnit(BigDecimal playerPurchaseAmount) {
        if (playerPurchaseAmount.remainder(PRICE_OF_ONE).compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_PURCHASE_AMOUNT_UNIT.findFullMessage());
        }
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
