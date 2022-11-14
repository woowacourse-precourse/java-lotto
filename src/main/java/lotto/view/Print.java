package lotto.view;

import static lotto.LottoRank.RANK2;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.Lotto;
import lotto.LottoRank;

public final class Print {
    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String DIVIDE_LINE = "---";
    private static final String WINNING_RESULT = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_WINNING_RESULT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String YIELD_BEFORE = "총 수익률은 %s";
    private static final String YIELD_AFTER = "%입니다.";

    public static void printPurchaseMoneyInput() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
    }

    public static void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + PURCHASE_QUANTITY_MESSAGE);
    }

    public static void printPublishedLottoNumbers(List<Lotto> publishedLotto) {
        for (Lotto lotto : publishedLotto) {
            System.out.println(lotto);
        }
    }

    public static void printWinningLottoNumbersInput() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusLottoNumberInput() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printLottoResult(Map<LottoRank, Integer> lottoResult) {
        System.out.println();
        System.out.println(WINNING_STATS);
        System.out.println(DIVIDE_LINE);

        for (Entry<LottoRank, Integer> LottoResults : lottoResult.entrySet()) {
            LottoRank rank = LottoResults.getKey();
            Integer count = LottoResults.getValue();

            int matchingCount = rank.getMatchingCount();
            String winningAmount = convertToComma(rank.getWinningAmount());

            if (rank == RANK2) {
                System.out.printf((BONUS_WINNING_RESULT) + "%n", matchingCount, winningAmount, count);
            }

            System.out.printf((WINNING_RESULT) + "%n", matchingCount, winningAmount, count);
        }
    }

    public static void printYield(String lottoYield) {
        System.out.println(String.format(YIELD_BEFORE, lottoYield) + YIELD_AFTER);
    }

    private static String convertToComma(int winningAmount) {
        return NumberFormat.getInstance().format(winningAmount);
    }

    private Print() {
    }
}
