package lotto.view;

import lotto.model.Reward;
import lotto.model.WinningRecord;

import java.util.List;

public class RecordView {
    private static void printWinningHistoryByOneLine(List<Integer> history, Reward reward) {
        String condition = reward.getCondition();
        String amount = reward.getAmount();
        int place = reward.getPlace();
        System.out.println(condition + " " + "(" + amount + "원) - " + history.get(place) + "개");
    }

    public static void printWinningRecord(WinningRecord winningRecord, Reward[] rewards) {
        List<Integer> history = winningRecord.getWinningHistory();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Reward reward : rewards) {
            printWinningHistoryByOneLine(history, reward);
        }
    }

    public static void printYield(WinningRecord winningRecord) {
        double yield = winningRecord.getYield();
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}
