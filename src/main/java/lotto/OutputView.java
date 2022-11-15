package lotto;

import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

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




}
