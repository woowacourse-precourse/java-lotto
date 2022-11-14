package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.CalculatedLotto;
import lotto.domain.Lotto;
import lotto.domain.UserLottoInfo;
import lotto.domain.WinningLotto;

public class LottoCalculator {
    private final UserLottoInfo userLottoInfo;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    private List<CalculatedLotto> calculatedLottos;

    public LottoCalculator(UserLottoInfo userLottoInfo, WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.userLottoInfo = userLottoInfo;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void calculate() {
        calculatedLottos = new ArrayList<>();
        for (Lotto userLotto :
                userLottoInfo.getUserLotto()) {
            compareSingleLotto(userLotto);
        }
    }

    private void compareSingleLotto(Lotto userLotto) {
        CalculatedLotto calculatedLotto = new CalculatedLotto();

        List<Integer> winningLottoNumbers = winningLotto.getWinningLottoNumbers().getNumbers();
        for (Integer number : userLotto.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                calculatedLotto.increaseWinningLottoCount();
            }
        }
        if (winningLottoNumbers.contains(bonusNumber.getNumber())) {
            calculatedLotto.switchToTrue();
        }

        calculatedLottos.add(calculatedLotto);
    }
}
