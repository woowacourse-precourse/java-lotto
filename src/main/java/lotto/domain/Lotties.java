package lotto.domain;

import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public final class Lotties {

    private static final String REG_XP_DIGITS = "^[0-9]+$";

    private final List<Lotto> lotties = new ArrayList<>();

    private final int purchaseAmount;

    private Lotties(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        addLottoToList(getLottoPublishCount());
    }

    public static Lotties create(String purchase) {
        validate(purchase);
        return new Lotties(Integer.parseInt(purchase));
    }

    private static void validate(String purchase) {
        hasDigitsOnly(purchase);
        isDividedByLottoAmount(Integer.parseInt(purchase));
    }

    private static void hasDigitsOnly(String purchaseAmount) {
        if (!purchaseAmount.matches(REG_XP_DIGITS)) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIGIT.message());
        }
    }

    private static void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
    }

    public int getLottoPublishCount() {
        return purchaseAmount / 1000;
    }


    private void addLottoToList(int lottoCount) {
        for (int i = 0 ; i < lottoCount ; i++) {
            lotties.add(Lotto.create());
        }
    }

    public int getLottiesSize() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return new ArrayList<>(lotties);
    }
}
