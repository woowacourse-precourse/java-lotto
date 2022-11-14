package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.Map;

public class LottoMessage {
    private static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String WINNING_RESULT = "당첨 통계\n" + "---";
    private static final String FIFTH_WINNING = "3개 일치 (5,000원) - ";
    private static final String FOURTH_WINNING = "4개 일치 (50,000원) - ";
    private static final String THIRD_WINNING = "5개 일치 (1,500,000원) - ";
    private static final String SECOND_WINNING = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String FIRST_WINNING = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";


    public void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void printPurchasedLotteries(List<Lotto> lotteries) {
        lotteries.forEach(System.out::println);
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
        System.out.println(FIFTH_WINNING + results.getOrDefault(Rank.FIFTH, 0) + COUNT);
        System.out.println(FOURTH_WINNING + results.getOrDefault(Rank.FOURTH, 0) + COUNT);
        System.out.println(THIRD_WINNING + results.getOrDefault(Rank.THIRD, 0) + COUNT);
        System.out.println(SECOND_WINNING + results.getOrDefault(Rank.SECOND, 0) + COUNT);
        System.out.println(FIRST_WINNING + results.getOrDefault(Rank.FIRST, 0) + COUNT);
    }
}
