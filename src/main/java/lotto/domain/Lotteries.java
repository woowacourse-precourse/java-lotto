package lotto.domain;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class Lotteries {
    private final List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    @Override
    public String toString() {
        return lotteries.stream()
                .map(Lotto::toString)
                .collect(joining("\n"));
    }
}
