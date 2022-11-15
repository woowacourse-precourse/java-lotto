package lotto.domain;

import java.util.List;
import java.util.Map;

public interface WinningStatusCalculator {
    Map<Rank, Integer> createWinningStatus(List<Lotto> lottos, WinningNumbersImple winningNumbers);
}
