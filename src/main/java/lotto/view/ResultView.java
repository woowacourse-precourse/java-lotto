package lotto.view;

import lotto.domain.reward.Reward;
import lotto.domain.reward.RewardTable;

import java.util.List;

public class ResultView {

    RewardTable rewardTable;
    double revenue;

    public ResultView(RewardTable rewardTable, double revenue) {
        this.rewardTable = rewardTable;
        this.revenue = revenue;
    }

    public void print() {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", rewardTable.getCountOfRank(5));
        System.out.printf("4개 일치 (50,000원) - %d개\n", rewardTable.getCountOfRank(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", rewardTable.getCountOfRank(3));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", rewardTable.getCountOfRank(2));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", rewardTable.getCountOfRank(1));
        System.out.printf("총 수익률은 " + revenue + "%s입니다.\n", "%");
    }
}
