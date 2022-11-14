package lotto.utils;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.type.Rank;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.type.Rank.RANK_NONE;
import static lotto.type.Rank.RANK_TWO;

public class View {
    private static final String REQUEST_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private static final String PUBLISH_LOTTO_MESSAGE = "개를 구매했습니다.";

    private static final String RESULT_STATISTICS_MESSAGE = "당첨 통계";
    private static final String RESULT_STATISTICS_LINE = "---";
    private static final String RESULT_CORRECT_COUNT = "개 일치";
    private static final String RESULT_CORRECT_BONUS_COUT = "개 일치, 보너스 볼 일치";
    private static final String RESULT_EARNING_RATIO_FRONT = "총 수익률은";
    private static final String RESULT_EARNING_RATIO_BACK = "입니다.";

    public static void printPriceMessage() {
        System.out.println(REQUEST_PRICE_MESSAGE);
    }

    public static void printWinningLottoMessage() {
        System.out.println("\n" + REQUEST_WINNING_LOTTO_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println("\n" + REQUEST_BONUS_NUMBER);
    }

    public static void printPublishedLottos(List<Lotto> playerLottos) {
        System.out.printf("\n%d" + PUBLISH_LOTTO_MESSAGE + "\n", playerLottos.size());
        for (Lotto lotto : playerLottos) {
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(LottoResult result, Integer buyPrice) {
        System.out.printf("\n" + RESULT_STATISTICS_MESSAGE + "\n" + RESULT_STATISTICS_LINE + "\n");
        for (Rank rank : Rank.values()) {
            printRankResult(rank, result);
        }
        System.out.printf(RESULT_EARNING_RATIO_FRONT + " %.1f%%" + RESULT_EARNING_RATIO_BACK, result.calculateEarningRatio(buyPrice));
    }

    private static void printRankResult(Rank rank, LottoResult result) {
        DecimalFormat priceForm = new DecimalFormat("###,###");
        DecimalFormat numberForm = new DecimalFormat();

        if (rank != RANK_NONE && rank != RANK_TWO) {
            System.out.println(numberForm.format(rank.getCorrectCount()) + RESULT_CORRECT_COUNT + " ("+priceForm.format(rank.getWinningMoney())+"원) - "
                    + numberForm.format(result.getWinningCount(rank)) + "개");
        }
        if (rank == RANK_TWO) {
            System.out.println(numberForm.format(rank.getCorrectCount()) + RESULT_CORRECT_BONUS_COUT + " ("+priceForm.format(rank.getWinningMoney())+"원) - "
                    + numberForm.format(result.getWinningCount(rank)) + "개");
        }
    }
}
