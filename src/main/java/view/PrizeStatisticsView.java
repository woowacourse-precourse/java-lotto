package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Prize;

public class PrizeStatisticsView {

    public static final int PRIZE_NUMBER = 5;

    private final List<Integer> prizeStatistics;

    public PrizeStatisticsView(List<Integer> prizeStatistics) {
        this.prizeStatistics = prizeStatistics;
    }

    public void show() {
        System.out.println("당첨 통계\n---");
        List<Prize> prizes = new ArrayList<Prize>(List.of(Prize.values()));
        Collections.reverse(prizes);
        int index = 1;
        for (Prize prize : prizes) {
            showPrize(index, prize);
            index++;
        }
    }

    private void showPrize(int index, Prize prize) {
        if (index == 4) {
            System.out.println(
                    prize.getMatch() + "개 일치, 보너스 볼 일치 (" + prize.getStringMoney() + "원) - " + prizeStatistics.get(
                            PRIZE_NUMBER - index) + "개");
            return;
        }
        System.out.println(prize.getMatch() + "개 일치 (" + prize.getStringMoney() + "원) - " + prizeStatistics.get(
                PRIZE_NUMBER - index) + "개");
    }
}
