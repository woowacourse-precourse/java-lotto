package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class Output {

    private static final String ERROR_TAG = "[ERROR] ";

    public static void purchaseLotto(Integer lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_TAG + message);
    }
}
