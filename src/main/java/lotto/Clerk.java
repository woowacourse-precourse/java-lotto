package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Enum.ConstantNumber.*;
import static lotto.Enum.ConstantString.REGEX_ONLY_NUMBER;
import static lotto.Enum.Error.*;

public class Clerk {

    public static List<Lotto> sellLotto(String purchaseAmount) {

        validatePurchaseAmount(purchaseAmount);

        int lotto_amount = getLottoAmount(purchaseAmount);

        return makeLottoList(lotto_amount);
    }

    private static List<Lotto> makeLottoList(int lotto_amount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lotto_amount; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    private static int getLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % THOUSAND.getValue();
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        validatePurchaseOnlyNumber(purchaseAmount);

        int purchaseAmountToInt = Integer.parseInt(purchaseAmount);

        validatePurchaseRange(purchaseAmountToInt);

        validatePurchaseThousandModular(purchaseAmountToInt);
    }

    private static void validatePurchaseOnlyNumber(String purchaseAmount) {
        if(!purchaseAmount.matches(REGEX_ONLY_NUMBER.getValue())){
            throw new IllegalArgumentException(PURCHASE_ONLY_NUMBER_ERROR.getMessage());
        }
    }

    private static void validatePurchaseRange(int purchaseAmount) {
        if (purchaseAmount == ZERO.getValue() || purchaseAmount > HUNDRED_THOUSAND.getValue()) {
            throw new IllegalArgumentException(PURCHASE_RANGE_ERROR.getMessage());
        }
    }

    private static void validatePurchaseThousandModular(int purchaseAmount) {
        if (purchaseAmount % THOUSAND.getValue() != ZERO.getValue()) {
            throw new IllegalArgumentException(PURCHASE_THOUSAND_MODULAR_ERROR.getMessage());
        }
    }
}
