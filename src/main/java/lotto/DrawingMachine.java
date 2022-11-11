package lotto;

import java.util.Arrays;
import java.util.List;

public class DrawingMachine {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public DrawingMachine(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getHitCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    public boolean isHitBonusNumber(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }

    public LottoRank getRank(Lotto lotto) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.equal(getHitCount(lotto), isHitBonusNumber(lotto)))
                .findAny().orElse(LottoRank.NOTHING);
    }
}
