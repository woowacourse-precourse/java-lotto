package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
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

    public List<LottoRank> getRanks(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::getRank)
                .collect(Collectors.toList());
    }
}
