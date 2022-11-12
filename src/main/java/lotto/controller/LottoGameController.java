package lotto.controller;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.UserInput;
import lotto.view.UserOutput;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGameController {
    public void run() {
        final Lottos boughtLottos = buyLottos();
        UserOutput.outputBuyLottos(boughtLottos);

        final Lotto winLotto = getWinLotto();
        final Integer bonusNumber = getBonusNumber(winLotto);
    }

    private Integer getBonusNumber(Lotto winLotto) {
        final Integer bonusNumber = UserInput.inputBonusNumber();
        if (winLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private Lotto getWinLotto() {
        return UserInput.inputLottoWinNumber();
    }

    private Lottos buyLottos() {
        final Integer money = UserInput.inputMoney();
        final Integer numberOfLottos = money / 1000;

        return publishLottos(numberOfLottos);
    }

    private Lottos publishLottos(Integer numberOfLottos) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.addLotto(publishLotto());
        }

        return lottos;
    }

    private Lotto publishLotto() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
