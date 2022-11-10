package system.process;

import models.Lotto;
import models.PurchasedLottosData;
import models.WinningLottoData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoComparison {

    private List<Integer> purchasedOneLottoNumbers;
    private Set<Integer> winningLottoNumbers;
    private int bonusNumber;

    private int sameNumberCount;
    private int bonusCount;


    public LottoComparison(WinningLottoData winningLottoData) {
        this.winningLottoNumbers = new HashSet<>(winningLottoData.getLotto().getNumbers());
        this.bonusCount = winningLottoData.getBonusNumber();
    }

    public void setPurchasedOneLotto(Lotto purchasedOneLotto) {
        sameNumberCount = 0;
        bonusCount = 0;// init
        this.purchasedOneLottoNumbers = new ArrayList<>(purchasedOneLotto.getNumbers());
    }

    public int startComparison() {

        purchasedOneLottoNumbers.forEach(number -> {
            if (winningLottoNumbers.contains(number)) {
                sameNumberCount++;
            }
        });

        if (winningLottoNumbers.contains(bonusNumber)) {
            bonusCount++;
        }

        return rank();

    }

    int rank() {

        if (sameNumberCount == 6) {
            return 1;
        }
        if (sameNumberCount == 5 && bonusCount == 1) {
            return 2;
        }
        if (sameNumberCount == 5) {
            return 3;
        }
        if (sameNumberCount == 4) {
            return 4;
        }
        if (sameNumberCount == 3) {
            return 5;
        }

        return -1;
    }


}
