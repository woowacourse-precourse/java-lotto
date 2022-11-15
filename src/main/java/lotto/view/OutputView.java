package lotto.view;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.domain.Rank;

public class OutputView {
    public static void printLottoAmount(Money money) {
        int lottoAmount = money.calculateLottoAmount();
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public static void printLottoTicket(LottoTicket lottoTicket) {
        for (String lotto : lottoTicket.convertString()) {
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(Map<Rank, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoResult.remove(Rank.LOSE);
        for (Entry<Rank, Integer> lottoRank : lottoResult.entrySet()) {
            System.out.println(printLottoRank(lottoRank.getKey(), lottoRank.getValue()));
        }
    }

    public static void printProfit(Profit profit) {
        System.out.println("총 수익률은 " + profit.getProfit() + "%입니다.");
    }

    private static String printLottoRank(Rank rank, int amount) {
        if (rank.hasBonus()) {
            return String.format(rank.getCorrectNumberAmount() + "개 일치, 보너스 볼 일치 (" + rank.prize() + "원) - " +
                    amount + "개");
        }
        return String.format(rank.getCorrectNumberAmount() + "개 일치 (" + rank.prize() + "원) - " +
                amount + "개");
    }
}

