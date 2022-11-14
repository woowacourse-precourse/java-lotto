package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.resource.message.PrintMessage;

public class OutputView {

    public static void payout() {
        System.out.println(PrintMessage.PAYOUT.getMessage());
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printLottoNumbers(LottoGroup lottoGroup) {
        for (Lotto lotto : lottoGroup.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoCount(int count) {
        System.out.printf(PrintMessage.LOTTO_COUNT.getMessage() + "\n", count);
    }
}
