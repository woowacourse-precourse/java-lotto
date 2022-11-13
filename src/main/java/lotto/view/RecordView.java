package lotto.view;

import lotto.model.Reward;
import lotto.model.WinningRecord;

import java.util.List;

public class RecordView {
    public static void printWinningRecord(WinningRecord winningRecord, Reward[] rewards) {
        List<Integer> history = winningRecord.getWinningHistory();

        System.out.println("당첨 통계");
        System.out.println("---");

        for (Reward reward : rewards) {
            String condition = reward.getCondition();
            String amount = reward.getAmount();
            int place = reward.getPlace();
            System.out.println(condition + " " + "(" + amount + "원) - " + history.get(place) + "개");
        }
    }

    public static void printYield(WinningRecord winningRecord) {
        double yield = Math.round(winningRecord.getYield());
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
