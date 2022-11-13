package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.RandomLotto;
import lotto.domain.Winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.*;

public class LottoService {

    public RandomLotto makeRandomLottoNumbers(Money money) {
        int numberOfLottoGame = money.getNumberOfLottoGame();
        RandomLotto randomLotto = new RandomLotto(numberOfLottoGame);

        for (int i = 0; i < numberOfLottoGame; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sort(randomNumbers);
            randomLotto.getRandomLottoNumbers().add(randomNumbers);
        }
        return randomLotto;
    }

    public HashMap<Winning, Integer> confirmWinningResult(RandomLotto randomLotto, Lotto lotto) {
        HashMap<Winning, Integer> winningResultMap = initWinningResultMap();
        for (List<Integer> randomLottoNums : randomLotto.getRandomLottoNumbers()) {
            calcWinningRankAndWinningNum(lotto, winningResultMap, randomLottoNums);
        }
        return winningResultMap;
    }

    private void calcWinningRankAndWinningNum(Lotto lotto, HashMap<Winning, Integer> winningResultMap, List<Integer> randomLottoNums) {
        int temp = 0;
        for (Integer winningNum : lotto.getWinningNumbers()) {
            if (randomLottoNums.contains(winningNum)) {
                temp++;
            }
        }
        for (Winning winning : Winning.values()) {
            if (temp == winning.getMatchNum()) {
                winningResultMap.put(winning, winningResultMap.get(winning) + 1);
            }
        }
    }

    private HashMap<Winning, Integer> initWinningResultMap() {
        HashMap<Winning, Integer> map = new HashMap<>();
        for (Winning winning : Winning.values()) {
            map.put(winning, 0);
        }
        return map;
    }


}
