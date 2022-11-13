package lotto.utils;

import lotto.domain.*;

public final class Output {

    private Output() {}

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printPurchasedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(StringParser.parseLottoToString(lotto));
        }
    }
}
