package lotto.view;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {

    public void printLottoAmount(Money money) {
        int lottoAmount = money.calculateLottoAmount();
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        for (String lotto : lottoTicket.printLottoTicket()) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(Map<Rank, Integer> lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoResult.remove(Rank.LOSE);
        for (Entry<Rank, Integer> lottoRank : lottoResult.entrySet()) {
            System.out.println(printLottoRank(lottoRank.getKey(), lottoRank.getValue()));
        }
    }

    private String printLottoRank(Rank rank, int amount) {
        if (rank.hasBonus()) {
            return String.format(rank.getCorrectNumberAmount() + "개 일치, 보너스 볼 일치 (" + amount + ") - ",
                    rank.prize() + "개");
        }

        return String.format(rank.getCorrectNumberAmount() + "개 일치 (" + amount + ") - ",
                rank.prize() + "개");

    }

}

