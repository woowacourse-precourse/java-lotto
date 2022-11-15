package lotto.domain.console;

import lotto.Hit;
import lotto.domain.lotto.Lotto;
import lotto.message.ResultMessageGenerator;

import java.util.HashMap;
import java.util.List;

public class ConsoleOut {
    private ConsoleOut() {
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(ResultMessageGenerator.getPurchaseConfirmMessage(lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(HashMap<Hit, Integer> result) {
        for (Hit hit : result.keySet()) {
            System.out.println(ResultMessageGenerator.getLottoResultMessage(hit, result.get(hit)));
        }
    }

    public static void printEarningRate(float earningRate) {
        System.out.println(ResultMessageGenerator.getEarningRateMessage(earningRate));
    }
}
