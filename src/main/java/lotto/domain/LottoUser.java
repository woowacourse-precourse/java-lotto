package lotto.domain;

import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.domain.Lotto.createRandomLotto;
import static lotto.domain.LottoUser.LottoPurchaseValidator.validate;
import static lotto.exception.ExceptionType.LACK_OF_MONEY_TO_PURCHASE;
import static lotto.exception.ExceptionType.WRONG_UNIT_OF_MONEY_TO_PURCHASE;
import static lotto.util.ConstValue.LottoConst.LOTTO_BASIC_COST;

public class LottoUser {

    private final List<Lotto> randomLottos;
    private final int purchaseCost;

    public LottoUser(final int purchaseCost) {
        randomLottos = new ArrayList<>();
        validate(purchaseCost);
        
        this.purchaseCost = purchaseCost;
        purchaseRandomLottos(purchaseCost);
    }

    private void purchaseRandomLottos(final int purchaseCost) {
        final int purchaseLottoCount = purchaseCost / LOTTO_BASIC_COST;
        for (int i = 0; i < purchaseLottoCount; i++) {
            randomLottos.add(createRandomLotto());
        }
    }

    public enum LottoPurchaseValidator {
        LOTTO_PURCHASE_MINIMUM_COST((Integer cost) -> {
            if (cost < LOTTO_BASIC_COST) {
                throw new IllegalArgumentException(LACK_OF_MONEY_TO_PURCHASE.getMessage());
            }
        }),

        LOTTO_PURCHASE_UNIT((Integer cost) -> {
            if (cost % LOTTO_BASIC_COST != 0) {
                throw new IllegalArgumentException(WRONG_UNIT_OF_MONEY_TO_PURCHASE.getMessage());
            }
        });

        private final Validator<Integer> validator;

        LottoPurchaseValidator(final Validator<Integer> validator) {
            this.validator = validator;
        }

        public static void validate(final int purchaseCost) {
            Arrays.stream(values()).forEach(v -> v.validator.validate(purchaseCost));
        }
    }
}
