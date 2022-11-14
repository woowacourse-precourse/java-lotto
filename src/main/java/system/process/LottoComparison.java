package system.process;

import constants.PrizeDivision;
import models.Lotto;
import models.WinningLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoComparison {
    private Lotto boughtLotto;
    private WinningLotto winningLotto;

    private int matchingCount;
    private int bonusCount;

    public LottoComparison(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void startComparison(Lotto boughtLotto) {
        initializeComparison(boughtLotto);
        compareLotto();
    }

    private void compareLotto() {
        Set<Integer> winningLottoNumbers = new HashSet<>(winningLotto.getLotto().getNumbers());

        countMatchingNumber(winningLottoNumbers);
        countBonusNumber();
    }

    private void initializeComparison(Lotto boughtLotto) {
        matchingCount = 0;
        bonusCount = 0;
        this.boughtLotto = boughtLotto;
    }

    private void countMatchingNumber(Set<Integer> winningLottoNumbers) {
        boughtLotto.getNumbers().forEach(number -> {
            if (winningLottoNumbers.contains(number)) {
                matchingCount++;
            }
        });
    }

    private void countBonusNumber() {
        if (boughtLotto.getNumbers().contains(winningLotto.getBonusNumber())) {
            bonusCount++;
        }
    }

    public int rank() {
        List<PrizeDivision> prizeDivisions = Arrays.asList(PrizeDivision.values());

        for (PrizeDivision division : prizeDivisions) {
            if (division.getMatchingCount() == matchingCount && division.getBonusCount() == bonusCount) {
                return division.ordinal();
            }
        }

        return PrizeDivision.NO_DIVISION.ordinal();
    }
}
