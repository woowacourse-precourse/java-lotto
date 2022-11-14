package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.Map;

public class LottoMessage {
    public void printPurchaseMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchasedLotteries(List<Lotto> lotteries) {
        lotteries.forEach(System.out::println);
    }

    public void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningResult(WinningResult winningResult) {
        Map<Rank, Integer> results = winningResult.getResults();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + results.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.getOrDefault(Rank.FIRST, 0) + "개");
    }
}
