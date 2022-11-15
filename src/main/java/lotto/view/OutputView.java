package lotto.view;

import lotto.model.Lotto;
import lotto.model.Ranking;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String SECOND_RANK_RESULT_MESSAGE = "%,d개 일치, 보너스 볼 일치 (%,d원) - %,d개";
    private static final String RANK_RESULT_MESSAGE = "%,d개 일치 (%,d원) - %,d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.1f%c입니다.";

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }


    public void printLottoTickets(List<Lotto> lottos){
        printEmptyLine();
        printMessage(String.format("%d개를 구매했습니다.",lottos.size()));
        lottos.forEach(
                lotto -> {
                    printMessage(lotto.getSortedLottoNumbers().toString());
                }
        );
    }

    public void printResult(Map<Ranking,Integer> result){
        printEmptyLine();
        printMessage("당첨 통계\n---");
        for(Ranking ranking: result.keySet()){
            printMessage(rankingMessage(ranking,result.get(ranking)));
        }



    }

    private String rankingMessage(Ranking ranking, Integer count) {
        if(ranking == Ranking.SECOND){
            return String.format(SECOND_RANK_RESULT_MESSAGE,ranking.getCorrectNums(),ranking.getReward(),count);
        }
        return String.format(RANK_RESULT_MESSAGE,ranking.getCorrectNums(),ranking.getReward(),count);
    }

    public  void printProfitRate(double profitRate){
        printMessage(String.format(PROFIT_RATE_MESSAGE,profitRate,'%'));
    }

}
