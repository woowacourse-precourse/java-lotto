package lotto.view;

import lotto.model.Prize;

import java.util.Map;

public class LottoStatisticsUI {
    public void showOverallMatches(Map<Prize, Integer> prizeTable){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format("%s - %d개", Prize.FIFTH.getMessage(), prizeTable.get(Prize.FIFTH)));
        System.out.println(String.format("%s - %d개", Prize.FOURTH.getMessage(), prizeTable.get(Prize.FOURTH)));
        System.out.println(String.format("%s - %d개", Prize.THIRD.getMessage(), prizeTable.get(Prize.THIRD)));
        System.out.println(String.format("%s - %d개", Prize.SECOND.getMessage(), prizeTable.get(Prize.SECOND)));
        System.out.println(String.format("%s - %d개", Prize.FIRST.getMessage(), prizeTable.get(Prize.FIRST)));
    }

    public void showRate(double rate){
        System.out.println(String.format("총 수익률은 %.1f", rate)+"%입니다.");
    }
}
