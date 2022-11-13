package lotto.template;

import lotto.domain.Statistics;
import lotto.domain.Ticket;

public class Output {
    public static void showTicket(Ticket ticket) {
        System.out.println(ticket.getLottoCount() + "개를 구매했습니다.");
        System.out.println(ticket);
    }

    public static void showWinningStatistics(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(
                "3개 일치 (5,000원) - " + statistics.getCount(3, false) + "개\n" +
                "4개 일치 (50,000원) - " + statistics.getCount(4, false) + "개\n" +
                "5개 일치 (1,500,000원) - " + statistics.getCount(5, false) + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.getCount(5, true) + "개\n" +
                "6개 일치 (2,000,000,000원) - " + statistics.getCount(6, false) + "개\n" +
                "총 수익률은 " + statistics.getReturnRate() + "%입니다."
        );
    }
}