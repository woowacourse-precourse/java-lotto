package lotto.console;

import lotto.Hit;
import lotto.domain.lotto.Lotto;
import lotto.message.MessageGenerator;

import java.util.HashMap;
import java.util.List;

public class ConsoleOut {
    private ConsoleOut() {
    }

    public static void printLottos(List<Lotto> lottos) {
        String purchaseCountMessage = MessageGenerator.getPurchaseConfirmMessage(lottos.size());
        System.out.println(purchaseCountMessage);

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(HashMap<Hit, Integer> result) {
        for (Hit hit : result.keySet()) {
            System.out.println(MessageGenerator.getLottoResultMessage(hit, result.get(hit)));
        }
    }

    public static void printEarningRate(float earningRate) {
        System.out.println(MessageGenerator.getEarningRateMessage(earningRate));
    }
}
