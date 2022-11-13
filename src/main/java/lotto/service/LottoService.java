package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.RandomLotto;
import lotto.domain.Winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LottoService {

    public RandomLotto makeRandomLottoNumbers(Money money) {
        int numberOfLottoGame = money.getNumberOfLottoGame();
        RandomLotto randomLotto = new RandomLotto(numberOfLottoGame);

        for (int i = 0; i < numberOfLottoGame; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            randomLotto.getRandomLottoNumbers().add(randomNumbers);
        }
        return randomLotto;
    }

    public HashMap<Winning, Integer> confirmWinningResult(RandomLotto randomLotto, Lotto lotto) {
        HashMap<Winning, Integer> map = makeHash();
        for (List<Integer> randomLottoNums : randomLotto.getRandomLottoNumbers()) {
            makeResult(lotto, map, randomLottoNums);
        }
        return map;
    }

    private HashMap<Winning, Integer> makeResult(Lotto lotto, HashMap<Winning, Integer> map, List<Integer> randomLottoNums) {
        int temp = 0;
        for (Integer winningNumber : lotto.getWinningNumbers()) {
            if (randomLottoNums.contains(winningNumber)) {
                temp++;
            }
        }
        if (temp == Winning.FIFTH.getMatchNum()) {
            map.put(Winning.FIFTH, map.get(Winning.FIFTH) + 1);
        }
        if (temp == Winning.FOURTH.getMatchNum()) {
            map.put(Winning.FOURTH, map.get(Winning.FOURTH) + 1);
        }
        if (temp == Winning.THIRD.getMatchNum()) {
            map.put(Winning.THIRD, map.get(Winning.THIRD) + 1);
        }
        if (temp == Winning.SECOND.getMatchNum()) {
            map.put(Winning.SECOND, map.get(Winning.SECOND) + 1);
        }
        if (temp == Winning.FIRST.getMatchNum()) {
            map.put(Winning.FIRST, map.get(Winning.FIRST) + 1);
        }
        return map;
    }

    private HashMap<Winning, Integer> makeHash() {
        HashMap<Winning, Integer> map = new HashMap<>();
        for (Winning winning : Winning.values()) {
            map.put(winning, 0);
        }
        return map;
    }


}
