package lotto.view;

import static lotto.LottoPrize.FIFTH_PRIZE;
import static lotto.LottoPrize.FIRST_PRIZE;
import static lotto.LottoPrize.FOURTH_PRIZE;
import static lotto.LottoPrize.SECOND_PRIZE;
import static lotto.LottoPrize.THIRD_PRIZE;

import java.util.List;
import java.util.Map;
import lotto.Buyer;
import lotto.Lotto;
import lotto.LottoPrize;

public class OutputView {
    public void printLottoNumbers(Buyer buyer) {
        System.out.println("\n" + buyer.getLottoTicketAmount() + "개를 구매했습니다.");
        for (Lotto lotto : buyer.getHoldingLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStats(Map<LottoPrize, Integer> result) {
        System.out.println("\n당첨 통계\n---");
        for (LottoPrize prize : List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE)) {
            System.out.println(prize.ofDescription() + " - " + result.get(prize) + "개");
        }
    }

    public void printRate(int sumPrize, int countHoldingLotto) {
        System.out.printf("총 수익률은 %.1f%%입니다.", (float) sumPrize / (countHoldingLotto * 1000) * 100);

    }
}
