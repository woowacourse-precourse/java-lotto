package lotto.constant;

public enum LottoWinningRanking {

    /**
     * 2, 3등을 제외한 모든 등수는 보너스 번호의 매칭과 상관 없기 때문에 false로 지정한다. 5등 보다 당첨 된 수가 적은 경우(NOTHING) 의미가 없기 때문에 하드코딩 하지 않고 0으로
     * 지정한다.
     */
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOTHING(0, false, 0);

    private final int numberOfMatches;
    private final boolean matchesOfBonusNumber;
    private final int winningAmount;

    LottoWinningRanking(int numberOfMatches, boolean matchesOfBonusNumber, int winningAmount) {
        this.numberOfMatches = numberOfMatches;
        this.matchesOfBonusNumber = matchesOfBonusNumber;
        this.winningAmount = winningAmount;
    }
}
