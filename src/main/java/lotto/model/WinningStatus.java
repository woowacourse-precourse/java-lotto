package lotto.model;

import java.math.BigDecimal;
import java.util.List;

public class WinningStatus {
    private final List<Winning> winnings;
    private final int count;

    public WinningStatus(List<Winning> winnings, int count) {
        this.winnings = winnings;
        this.count = count;
    }

    public BigDecimal getYield() {
        double purchase = count * 1000;
        double revenue = winnings.stream()
                .mapToDouble(Winning::getWinningPrice)
                .sum();
        double yield = revenue / purchase * 100.0;

        return BigDecimal.valueOf(Math.round(yield * 100) / 100.0);
    }

    public int countThree() {
        return (int) winnings.stream()
                .filter(w -> w.equals(Winning.THREE))
                .count();
    }

    public int countFour() {
        return (int) winnings.stream()
                .filter(w -> w.equals(Winning.FOUR))
                .count();
    }

    public int countFive() {
        return (int) winnings.stream()
                .filter(w -> w.equals(Winning.FIVE))
                .count();
    }

    public int countFiveBonus() {
        return (int) winnings.stream()
                .filter(w -> w.equals(Winning.FIVE_BONUS))
                .count();
    }

    public int countSix() {
        return (int) winnings.stream()
                .filter(w -> w.equals(Winning.SIX))
                .count();
    }

    @Override
    public String toString() {
        return "3개 일치 (5,000원) - " + countThree() + "개\n"
                + "4개 일치 (50,000원) - " + countFour() + "개\n"
                + "5개 일치 (1,500,000원) - " + countFive() + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + countFiveBonus() + "개\n"
                + "6개 일치 (2,000,000,000원) - " + countSix() + "개\n"
                + "총 수익률은 " + getYield().toPlainString() + "%입니다.";
    }
}
