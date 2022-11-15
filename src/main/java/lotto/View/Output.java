package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Result.Prize;

import java.util.HashMap;
import java.util.List;

public class Output {

    private final static String MESSAGE_LOTTO_AMOUNT_FORMAT = "%d개를 구매했습니다.\n";

    private final static String MESSAGE_LOTTO_RESULT_FORMAT =
                    "당첨 통계\n" +
                    "---\n" +
                    "3개 일치 (5,000원) - %d개\n" +
                    "4개 일치 (50,000원) - %d개\n" +
                    "5개 일치 (1,500,000원) - %d개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                    "6개 일치 (2,000,000,000원) - %d개\n";

    private final static String MESSAGE_PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void printPurchasedLottoAmount(int amount) {
        System.out.printf(MESSAGE_LOTTO_AMOUNT_FORMAT, amount);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    public static void printLottoResult(HashMap<Prize, Integer> result) {
        System.out.printf(
                MESSAGE_LOTTO_RESULT_FORMAT,
                result.get(Prize.FIFTH).intValue(),
                result.get(Prize.FOURTH).intValue(),
                result.get(Prize.THIRD).intValue(),
                result.get(Prize.SECOND).intValue(),
                result.get(Prize.FIRST).intValue()
        );
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(MESSAGE_PROFIT_RATE_FORMAT, profitRate);
    }
}
