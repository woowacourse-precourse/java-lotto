package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Enum.Constant.*;
import static lotto.Enum.Error.*;

public class Clerk {


    public static List<Lotto> sellLotto(String purchaseAmount) {

        validatePurchaseAmount(purchaseAmount);

        int lotto_amount = getLottoAmount(purchaseAmount);

        return makeLottoGroup(lotto_amount);
    }

    private static List<Lotto> makeLottoGroup(int lotto_amount) {
        List<Lotto> lotto_group = new ArrayList<>();

        for (int i = ZERO.getIntValue(); i < lotto_amount; i++) {
            Lotto new_lotto = makeLotto(lotto_group);
            lotto_group.add(new_lotto);
        }
        return lotto_group;
    }

    private static Lotto makeLotto(List<Lotto> lotto_group) {
        List<Integer> random_lotto_num = pickUniqueNumbersInRange(
                ZERO.getIntValue(), FOURTY_FIVE.getIntValue(), SIX.getIntValue()
        );
        return new Lotto(random_lotto_num);
    }

    private static int getLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % THOUSAND.getIntValue();
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
        if (purchaseAmount == ZERO.getIntValue() || purchaseAmount > HUNDRED_THOUSAND.getIntValue()) {
            throw new IllegalArgumentException(PURCHASE_RANGE_ERROR.getMessage());
        }
    }

    private static void validatePurchaseThousandModular(int purchaseAmount) {
        if (purchaseAmount % THOUSAND.getIntValue() != ZERO.getIntValue()) {
            throw new IllegalArgumentException(PURCHASE_THOUSAND_MODULAR_ERROR.getMessage());
        }
    }
}
