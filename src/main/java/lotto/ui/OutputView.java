package lotto.ui;

import lotto.domain.LottoMachine;

public enum OutputView {
    INSTANCE;
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다";

    public static void printPurchasedLottoCount(int purchasedLottoCount) {
        System.out.println(purchasedLottoCount + PURCHASE_LOTTO_MESSAGE);
    }
}
