package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Printer {

    private static final DecimalFormat INTEGER_FORMAT = new DecimalFormat("###,###");
    private static final DecimalFormat FLOAT_FORMAT = new DecimalFormat("###,###.#");
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printPurchaseLottosInfo(List<Lotto> playerPurchaseLottos) {
        printMessage(String.format("%d개를 구매했습니다.", playerPurchaseLottos.size()));
        for (Lotto playerPurchaseLotto : playerPurchaseLottos) {
            printMessage(playerPurchaseLotto.getNumbers().toString());
        }
    }

    public static void printResult(List<Rank> lottoResults, int purchasePrice) {
        int totalReward = 0;
        printMessage("당첨 통계");
        printMessage("---");
        for (Rank rank : Rank.values()) {
            printMessage(String.format("%s (%s원) - %d개", rank.getDescriptionMessage(),
                    getFormattedReward(rank.getWinningPrice()), getMatchedRankCount(lottoResults, rank)));
            totalReward += rank.getWinningPrice() * getMatchedRankCount(lottoResults, rank);
        }
        printMessage(String.format("총 수익률은 %s%%입니다.", getFormattedRateOfReturn(totalReward, purchasePrice)));
    }

    private static String getFormattedRateOfReturn(int totalReward, int purchasePrice) {
        return FLOAT_FORMAT.format(totalReward * 100.0 / purchasePrice);
    }

    private static long getMatchedRankCount(List<Rank> lottoResults, Rank matchedRank) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.equals(matchedRank))
                .count();
    }

    private static String getFormattedReward(int winningPrice) {
        return INTEGER_FORMAT.format(winningPrice);
    }
}
