package lotto.view;

import lotto.view.View;

import java.util.List;

public class PrizeStatisticsView implements View {
    private List<Long> prizeCounts;
    private Double statistics;

    public PrizeStatisticsView(List<Long> prizeCounts, Double statistics) {
        this.prizeCounts = prizeCounts;
        this.statistics = statistics;
    }

    @Override
    public void print() {
        System.out.println(String.format("3개 일치 (5,000원) - %d개", prizeCounts.get(0)));
        System.out.println(String.format("4개 일치 (50,000원) - %d개", prizeCounts.get(1)));
        System.out.println(String.format("5개 일치 (1,500,000원) - %d개", prizeCounts.get(2)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", prizeCounts.get(3)));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %d개", prizeCounts.get(4)));
        System.out.println("총 수익률은 " + String.format("%.1f", statistics) + "%입니다.");
    }
}
