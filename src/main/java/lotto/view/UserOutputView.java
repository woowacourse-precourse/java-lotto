package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.constant.LottoWinningRanking;
import lotto.constant.UserOutputMessage;

public class UserOutputView {

    public static void printPurchaseQuantity(int numberOfPurchasedLottos) {
        System.out.println(numberOfPurchasedLottos + UserOutputMessage.POSTFIX_NUMBER_OF_PURCHASES.getMessage());
    }

    public static void printPurchasedLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printWinningResult(Map<LottoWinningRanking, Integer> winningResult) {
        System.out.println(UserOutputMessage.PREFIX_WINNING_RESULT.getMessage());
        for (LottoWinningRanking ranking : LottoWinningRanking.values()) {
            if (ranking == LottoWinningRanking.NOTHING) {
                continue;
            }

            if (ranking.isMatchesOfBonusNumber()) {
                printWinningResultWithBonusMatches(ranking, winningResult.get(ranking));
                continue;
            }
            printWinningResult(ranking, winningResult.get(ranking));
        }
    }

    public static void printRateOfReturn(double userRateOfReturn) {
        System.out.printf(UserOutputMessage.RATE_OF_RETURN.getMessage(), userRateOfReturn);
    }

    private static void printWinningResultWithBonusMatches(LottoWinningRanking winningRanking, int quantity) {
        System.out.printf(
                UserOutputMessage.WINNIGN_RESULT_WITH_BONUS_MATCHES.getMessage(),
                winningRanking.getNumberOfMatches(),
                integerToStringWithCommas(winningRanking.getWinningAmount()),
                quantity
        );
    }

    private static void printWinningResult(LottoWinningRanking winningRanking, int quantity) {
        System.out.printf(
                UserOutputMessage.WINNING_RESULT.getMessage(),
                winningRanking.getNumberOfMatches(),
                integerToStringWithCommas(winningRanking.getWinningAmount()),
                quantity
        );
    }

    private static String integerToStringWithCommas(int number) {
        return NumberFormat.getNumberInstance(Locale.US).format(number);
    }
}
