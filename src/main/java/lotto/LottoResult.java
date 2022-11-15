package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Integer> prizeCounts = new ArrayList<>();
    private Integer bonusCount;
    private double yield;

    public LottoResult() {
        bonusCount = 0;
        for(int i = 0; i < 4; i++) prizeCounts.add(0);
    }

    public void calculateResult(List<Lotto> usersLottos, Lotto prizeLotto, int bonusNum) {
        for (Lotto userLotto : usersLottos) {
            int prizeIndex = -1 * (prizeLotto.countNumMatch(userLotto) - 6);
            if(prizeIndex > 3) continue;
            prizeCounts.set(prizeIndex, prizeCounts.get(prizeIndex) + 1);
            if (prizeIndex == 1 && userLotto.hasContain(bonusNum)) {
                prizeCounts.set(prizeIndex, prizeCounts.get(prizeIndex) - 1);
                bonusCount++;
            }
        }
    }

    public double getYield() {
        return yield;
    }

    public void calYield(int money) {
        double totalPrize = prizeCounts.get(0) * PrizeMoney.FIRST.value
                + bonusCount * PrizeMoney.SECOND.value
                + prizeCounts.get(1) * PrizeMoney.THIRD.value
                + prizeCounts.get(2) * PrizeMoney.FOURTH.value
                + prizeCounts.get(3) * PrizeMoney.FIFTH.value;
        yield = totalPrize / money * 100;
    }

    @Override
    public String toString() {
        String s = "당첨 통계\n---\n";
        s += String.format("3개 일치 (%s원) - %d개\n", PrizeMoney.FIFTH, prizeCounts.get(3));
        s += String.format("4개 일치 (%s원) - %d개\n", PrizeMoney.FOURTH, prizeCounts.get(1));
        s += String.format("5개 일치 (%s원) - %d개\n", PrizeMoney.THIRD, prizeCounts.get(2));
        s += String.format("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", PrizeMoney.SECOND, bonusCount);
        s += String.format("6개 일치 (%s원) - %d개\n", PrizeMoney.FIRST, prizeCounts.get(0));
        s += String.format("총 수익률은 %.1f%%입니다.", yield);
        return s;
    }
}
