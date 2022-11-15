package lotto.helper.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import lotto.domain.player.LottoPurchaseAmount;
import lotto.helper.exception.CannotReflectionException;

public final class LottoPurchaseAmountTestUtils {

    private static final String PLAYER_PURCHASE_AMOUNT_FIELD_NAME = "playerPurchaseAmount";

    private LottoPurchaseAmountTestUtils() {
    }

    public static BigDecimal findPlayerPurchaseAmount(LottoPurchaseAmount lottoPurchaseAmount) {
        Field playerPurchaseAmountField = ReflectionFieldUtils
                .processReflectionField(LottoPurchaseAmount.class, PLAYER_PURCHASE_AMOUNT_FIELD_NAME);

        try {
            return (BigDecimal) playerPurchaseAmountField.get(lottoPurchaseAmount);
        } catch (Exception e) {
            throw new CannotReflectionException(e);
        }
    }
}
