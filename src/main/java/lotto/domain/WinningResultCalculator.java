package lotto.domain;

import java.util.List;
import java.util.Map;

public interface WinningResultCalculator {
    Map<Rank, Integer> generateWinningStatus(List<Lotto> lottos, WinningNumbersImple winningNumbers);
    double generateReturnRatio(double expenses, Map<Rank, Integer> winningStatus);
}
