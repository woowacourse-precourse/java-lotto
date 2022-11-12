package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.RandomLotto;

import java.util.Collections;
import java.util.List;

public class LottoService {

    public RandomLotto makeRandomLottoNumbers(Money money) {
        int numberOfLottoGame = money.getNumberOfLottoGame();
        RandomLotto randomLotto = new RandomLotto(numberOfLottoGame);

        for (int i = 0; i < numberOfLottoGame; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            randomLotto.getRandomLottoNumbersList().add(randomNumbers);
        }
        return randomLotto;
    }

    public void makeWinningResult(RandomLotto randomLotto, Lotto lotto) {

    }
}
