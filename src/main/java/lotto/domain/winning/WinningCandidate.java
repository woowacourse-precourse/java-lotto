package lotto.domain.winning;

public class WinningCandidate {

    private final int countsOfMatchingNumber;
    private final boolean isMatchedBonusNumber;

    public WinningCandidate(int countsOfMatchingNumber, boolean isMatchedBonusNumber) {
        this.countsOfMatchingNumber = countsOfMatchingNumber;
        this.isMatchedBonusNumber = isMatchedBonusNumber;
    }
}
