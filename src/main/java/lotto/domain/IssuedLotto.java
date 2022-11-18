package lotto.domain;

import java.util.List;

public class IssuedLotto {
    private static final int BONUS_CHECK_COUNT = 5;
    private final List<Lotto> lottos;

    public IssuedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getTotalCount() {
        return lottos.size();
    }

    public WinningResult compare(List<Integer> basicLottoNumbers, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            int correctCount = lotto.compare(basicLottoNumbers);
            boolean hasBonusNumber = compareBonusNumber(lotto, correctCount, bonusNumber);
            ComparedNumber comparedNumber = new ComparedNumber(correctCount, hasBonusNumber);
            result.addCorrectCount(comparedNumber);
        }
        return result;
    }

    private boolean compareBonusNumber(Lotto lotto, int correctCount, int bonusNumber) {
        if (correctCount == BONUS_CHECK_COUNT) {
            return lotto.hasBonusNumber(bonusNumber);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append("\n");
        }
        return sb.toString();
    }
}
