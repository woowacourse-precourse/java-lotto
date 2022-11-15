package lotto.view;

import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class ResultView {

    public void printTotalCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottoTickets(String lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printWinnerStat(List<Rank> ranks) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + Rank.FIFTH.prize() + "원)-" + Collections.frequency(ranks, Rank.FIFTH) + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.prize() + "원)-" + Collections.frequency(ranks, Rank.FOURTH) + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.prize() + "원)-" + Collections.frequency(ranks, Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + Rank.SECOND.prize() + "원)-" + Collections.frequency(ranks, Rank.SECOND) + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.prize() + "원)-" + Collections.frequency(ranks, Rank.FIRST) + "개");

    }

    public void printEarningRatio(double rate) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("총 수익률은 " + df.format(rate) + "입니다.");
    }

}
