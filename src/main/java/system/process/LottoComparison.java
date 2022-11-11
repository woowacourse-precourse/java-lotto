package system.process;

import constants.LottoConstant;
import constants.PrizeDivision;
import models.Lotto;
import models.WinningLotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoComparison {
    private Lotto boughtLotto;
    private WinningLotto winningLotto;

    private int sameNumberCount;
    private int bonusCount;

    public LottoComparison(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void compareLotto(Lotto boughtLotto) {

        setBoughtLotto(boughtLotto);

        List<Integer> boughtLottoNumbers = new ArrayList<>(boughtLotto.getNumbers());
        Set<Integer> winningLottoNumbers = new HashSet<>(winningLotto.getLotto().getNumbers());

        countSameNumber(boughtLottoNumbers, winningLottoNumbers);
        countBonusNumber(boughtLottoNumbers, winningLotto.getBonusNumber());
    }

    private void setBoughtLotto(Lotto boughtLotto) {
        sameNumberCount = 0;
        bonusCount = 0;     // init
        this.boughtLotto = boughtLotto;
    }

    private void countSameNumber(List<Integer> boughtLottoNumbers, Set<Integer> winningLottoNumbers) {
        boughtLottoNumbers.forEach(number -> {
            if (winningLottoNumbers.contains(number)) {
                sameNumberCount++;
            }
        });
    }

    private void countBonusNumber(List<Integer> boughtLottoNumbers, int bonusNumber) {
        if (boughtLottoNumbers.contains(bonusNumber)) {
            bonusCount++;
        }
    }

    public int rank() {
        if (sameNumberCount == 6) {
            return PrizeDivision.FIRST.getDivision();
        }
        if (sameNumberCount == 5 && bonusCount == 1) {
            return PrizeDivision.SECOND.getDivision();
        }
        if (sameNumberCount == 5) {
            return PrizeDivision.THIRD.getDivision();
        }
        if (sameNumberCount == 4) {
            return PrizeDivision.FOURTH.getDivision();
        }
        if (sameNumberCount == 3) {
            return PrizeDivision.FIFTH.getDivision();
        }

        return PrizeDivision.NO_DIVISION.getDivision();
    }
}
