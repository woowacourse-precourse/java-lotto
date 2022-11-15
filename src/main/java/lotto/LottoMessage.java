package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.Map;

public class LottoMessage {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COMPLETED = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private static final String WINNING_RESULT = "\n당첨 통계\n" + "---";
    private static final String COMMON_WINNING_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String SECOND_WINNING_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFIT_PERCENTAGE =  "총 수익률은 %.1f%%입니다.";

    private static final String ERROR = "[ERROR] ";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printPurchasedLotteries(List<Lotto> lotteries) {
        System.out.format(PURCHASE_COMPLETED, lotteries.size());
        for (Lotto lotto : lotteries) {
            System.out.println(lotto);
        }
    }

    public void printInputWinningNumber() {
        System.out.println(WINNING_NUMBER);
    }

    public void printInputBonusNumber() {
        System.out.println(BONUS_NUMBER);
    }

    public void printWinningResult(WinningResult winningResult) {
        Map<Rank, Integer> results = winningResult.getResults();

        System.out.println(WINNING_RESULT);
        for (Map.Entry<Rank, Integer> result : results.entrySet()) {
            System.out.println(makeWinningPrint(result));
        }
    }

    private String makeWinningPrint(Map.Entry<Rank, Integer> result) {
        Rank rank = result.getKey();
        String winningFormat = COMMON_WINNING_FORMAT;
        if (rank.equals(Rank.SECOND)) {
            winningFormat = SECOND_WINNING_FORMAT;
        }

        return String.format(winningFormat, rank.getCoincideCount(), rank.getWinningAmount(), result.getValue());
    }

    public void printProfitPercentage(double profitPercentage) {
        System.out.format(PROFIT_PERCENTAGE, profitPercentage);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR + message);
    }
}
