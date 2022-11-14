package lotto.UI;

import lotto.UI.message.UIMessage;
import lotto.Lotto;
import lotto.config.LottoConfig;

import java.util.List;
import java.util.Map;

public class OutputManager {
    public static void printLottoBought(int num) {
        UIPrinter.printMessage(num + UIMessage.LOTTO_BUY_NUM.getMessage());
    }

    public static void printLottoList(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            UIPrinter.printLotto(lotto);
        }
        UIPrinter.printEmptyLine();
    }

    public static void printRanks(Map<Integer, Integer> ranks, int profit, int spent) {
        UIPrinter.printMessage(UIMessage.LOTTO_RESULT.getMessage());

        for(int rank = 4; rank >= 0; rank--) {
            UIPrinter.printRank(
                    getRankMessage(rank),
                    LottoConfig.awards.get(rank),
                    ranks.getOrDefault(rank, 0));
        }

        UIPrinter.printProfit(UIMessage.PROFIT.getMessage(), 100.0 * profit / spent);
    }

    private static String getRankMessage(int idx) {
        return UIMessage.valueOf("RANK_"+idx).getMessage();
    }
}
