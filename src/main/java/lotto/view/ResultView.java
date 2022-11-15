package lotto.view;

import java.text.DecimalFormat;

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
    }

    public void printEarningRatio(double rate) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("총 수익률은 " + df.format(rate) + "입니다.");
    }

}
