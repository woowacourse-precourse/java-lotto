package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningInformation {
    private final List<Winning> winnings;

    public WinningInformation(List<Winning> winnings) {
        this.winnings = winnings;
    }

    public double getYield(int count) {
        double purchase = count * 1000;
        double revenue = winnings.stream()
                .mapToDouble(Winning::getWinningPrice)
                .sum();

        return revenue / purchase * 100.0;
    }

    public List<Integer> getWinningCounts() {
        return Arrays.stream(Winning.values())
                .map(v -> (int) winnings.stream()
                        .filter(w -> w == v)
                        .count()
                )
                .collect(Collectors.toList());
    }
}
