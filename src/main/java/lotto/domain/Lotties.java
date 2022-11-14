package lotto.domain;

import lotto.common.Constant;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;

public final class Lotties {

    private final List<Lotto> lotties = new ArrayList<>();

    private final int purchaseAmount;

    private Lotties(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        addLottoToList(getLottoPublishCount());
    }

    public static Lotties create(int purchase) {
        isDividedByLottoAmount(purchase);
        return new Lotties(purchase);
    }

    public int getLottoPublishCount() {
        return purchaseAmount / Constant.LOTTO_PRICE;
    }


    private static void isDividedByLottoAmount(int purchaseAmount) {
        if (purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(InputException.MONEY_NOT_DIVIDE_BY_LOTTO_UNIT.message());
        }
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
