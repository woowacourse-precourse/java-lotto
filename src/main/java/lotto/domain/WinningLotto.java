package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;
    private final List<Integer> lottoRank;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
        this.lottoRank = Arrays.asList(0, 0, 0, 0, 0, 0);
    }

    public int lottoContainsCount(List<Integer> lotto) {
        int count = 0;
        for (Integer number : lotto) {
            if (this.lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getLottoRank() {
        return lottoRank;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int lottoRankIndexConvertByLottoCount(List<Integer> lotto, int count) {
        if (count == LottoRank.ONE.getCorrectNumberCount()) {
            return LottoRank.ONE.ordinal();
        }
        if (count == LottoRank.TWO.getCorrectNumberCount()) {
            if (lotto.contains(bonusNumber)) {
                return LottoRank.TWO.ordinal();
            }
            return LottoRank.THREE.ordinal();
        }
        if (count == LottoRank.FOUR.getCorrectNumberCount()) {
            return LottoRank.FOUR.ordinal();
        }
        if (count == LottoRank.FIVE.getCorrectNumberCount()) {
            return LottoRank.FIVE.ordinal();
        }

        return 5;
    }
}
