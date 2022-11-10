package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private static final String HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE = "개를 구매했습니다.";

    public static void printHowManyLottoUserPurchased(int lottoQuantity) {
        System.out.println(lottoQuantity + HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
}
