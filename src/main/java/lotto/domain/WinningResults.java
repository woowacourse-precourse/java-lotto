package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.TotalWinningLottoDto;
import lotto.domain.enums.WinResultStatus;

public class WinningResults {
    private final List<WinningResult> winningResults;

    public WinningResults(final List<WinningResult> winningResults) {
        this.winningResults = winningResults;
    }

    public void generate(final TotalLotto totalLotto, final TotalWinningLottoDto totalWinningLotto) {
        List<Integer> validWinningIndexes = getValidIndexList(totalLotto.getResult(totalWinningLotto));
        validWinningIndexes.forEach(index -> winningResults.get(index).increaseWinCount());
    }

    private List<Integer> getValidIndexList(final List<WinResultStatus> buyingLottoResults) {
        return buyingLottoResults.stream()
                .map(winResultStatus -> winningResults.indexOf(new WinningResult(winResultStatus)))
                .collect(Collectors.toList());
    }

    public List<WinningResult> getWinningResults() {
        return winningResults;
    }

    public long getTotalWinningPrice() {
        return winningResults.stream()
                .mapToLong(WinningResult::getWinningPrice)
                .sum();
    }
}
