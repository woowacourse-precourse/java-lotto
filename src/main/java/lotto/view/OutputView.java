package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void printPurchasedLotto(int lottoCount) {
        System.out.println(lottoCount + PURCHASE_MESSAGE);
    }

    public static void printLottoNumbers(List<Lotto> lotties) {
        for (Lotto lotto : lotties) {
            System.out.println(lotto.getNumbers());
        }
    }
}
