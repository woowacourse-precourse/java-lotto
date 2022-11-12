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

    private int sameNumberCount;
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

        countSameNumber(winningLottoNumbers);
        countBonusNumber();
    }

    private void initializeComparison(Lotto boughtLotto) {
        sameNumberCount = 0;
        bonusCount = 0;
        this.boughtLotto = boughtLotto;
    }

    private void countSameNumber(Set<Integer> winningLottoNumbers) {
        boughtLotto.getNumbers().forEach(number -> {
            if (winningLottoNumbers.contains(number)) {
                sameNumberCount++;
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

        for(PrizeDivision division : prizeDivisions){
            if(division.getSameNumberCount() == sameNumberCount && division.getBonusCount() == bonusCount){
                return division.getDivision();
            }
        }

        return PrizeDivision.NO_DIVISION.getDivision();
    }
}
