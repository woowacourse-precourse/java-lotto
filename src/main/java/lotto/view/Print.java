package lotto.view;

import static lotto.model.LottoRank.NONE;
import static lotto.model.LottoRank.RANK2;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public final class Print {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String DIVIDE_LINE = "---";
    private static final String WINNING_RESULT = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_WINNING_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String YIELD_1 = "총 수익률은 %s";
    private static final String YIELD_2 = "%입니다.";

    public static void requestPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + PURCHASE_QUANTITY);
    }

    public static void printPublishedLottoNumbers(List<Lotto> publishedLotto) {
        for (Lotto lotto : publishedLotto) {
            System.out.println(lotto);
        }
    }

    public static void requestWinningNumbersInput() {
        System.out.println();
        System.out.println(WINNING_NUMBERS);
    }

    public static void requestBonusNumberInput() {
        System.out.println();
        System.out.println(BONUS_NUMBER);
    }

    public static void printLottoResult(Map<LottoRank, Integer> lottoResult) {
        System.out.println();
        System.out.println(WINNING_STATS);
        System.out.println(DIVIDE_LINE);

        for (LottoRank rank : lottoResult.keySet()) {
            Integer count = lottoResult.get(rank);
            int matchingCount = rank.getMatchingCount();
            String winningAmount = convertToComma(rank.getWinningAmount());

            if (rank == NONE) {
                continue;
            }

            if (rank == RANK2) {
                System.out.printf((BONUS_WINNING_RESULT) + "%n", matchingCount, winningAmount, count);
            }

            System.out.printf((WINNING_RESULT) + "%n", matchingCount, winningAmount, count);
        }
    }

    public static void printYield(double lottoYield) {
        String formattedYield = String.format("%,.1f", lottoYield);
        System.out.println(String.format(YIELD_1, formattedYield) + YIELD_2);
    }

    private static String convertToComma(int winningAmount) {
        return NumberFormat.getInstance().format(winningAmount);
    }

    private Print() {
    }
}
