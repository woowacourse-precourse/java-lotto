package lotto.domain;

import java.util.Map;

public interface ReturnRatioCalculator {
    double calculateReturnRatio(double expenses, Map<Rank, Integer> winningStatus );
}
