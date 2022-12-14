package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.dto.TotalWinningLottoDto;
import lotto.domain.enums.WinResultStatus;

public class WinningResults {
    public static final int NOTHING = -1;
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
                .map(winningResults::indexOf)
                .collect(Collectors.toList())
                .stream()
                .filter(index -> index != NOTHING)
                .collect(Collectors.toList());
    }
}
