package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.view.UserInput;
import lotto.view.UserOutput;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGameController {
    public void run() {
        final Lottos boughtLottos = buyLottos();
        UserOutput.outputBuyLottos(boughtLottos);

        final Lotto winLotto = new Lotto(UserInput.inputLottoWinNumber());
        final BonusNumber bonusNumber = new BonusNumber(UserInput.inputBonusNumber(), winLotto);

        UserOutput.outputResultStatistics(
                new Result(boughtLottos, winLotto, bonusNumber),
                boughtLottos.getPriceOfLottos());
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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = numbers.stream().sorted().collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
