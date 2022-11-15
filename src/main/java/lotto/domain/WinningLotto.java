package lotto.domain;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(Lotto lotto) {
        int winningNumberCount = (int) winningNumbers.getLotto()
                .stream()
                .filter(number -> lotto.getLotto()
                        .contains(number))
                .count();
        boolean isHasBonusNumber = lotto.getLotto().contains(bonusNumber);

        return Rank.valueOf(winningNumberCount, isHasBonusNumber);
    }
}
