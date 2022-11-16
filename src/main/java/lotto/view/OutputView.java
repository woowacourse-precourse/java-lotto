package lotto.view;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.RankingResult;

public class OutputView {
    private static final String PRINT_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";

    public static void printPurchaseLotto(int lottoCount){
        System.out.printf(PRINT_LOTTO_COUNT,lottoCount);
    }

    public static void printResult(RankingResult rankingResult, Money money){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(rankingResult.result()+"\n");
        double profit = rankingResult.getProfit(money);

        System.out.print("총 수익률은 " + profit + "%입니다.");
    }

    public static void printLottoPaper(LottoTickets lottoTickets){
        List<List<Integer>> Tickets = lottoTickets.getLottoTicket();
        for(int i=0; i<Tickets.size(); i++){
            System.out.println(Tickets.get(i));
        }
    }
}
