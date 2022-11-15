package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.RandomLotto;
import lotto.domain.Winning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.sort;

public class LottoService {


    public RandomLotto makeRandomLottoNumbers(Money money) {
        int numberOfLottoGame = money.getNumberOfLottoGame();
        List<List<Integer>> randomLottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottoGame; i++) {
            List<Integer> randomNumbers = new ArrayList<>(generateRandomLottoNumbers());
            sort(randomNumbers);
            randomLottos.add(randomNumbers);
        }
        return new RandomLotto(randomLottos, numberOfLottoGame);
    }

    public HashMap<Winning, Integer> confirmWinningResult(RandomLotto randomLotto, Lotto lotto) {
        HashMap<Winning, Integer> winningResultMap = initWinningResultMap();
        for (List<Integer> randomLottoNums : randomLotto.getRandomLottos()) {
            calcWinningRankAndWinningNum(lotto, winningResultMap, randomLottoNums);
        }
        return winningResultMap;
    }

    private void calcWinningRankAndWinningNum(Lotto lotto, HashMap<Winning, Integer> winningResultMap, List<Integer> randomLottoNums) {
        int matchCnt = calcMatchNumber(lotto, randomLottoNums);
        for (Winning winning : Winning.values()) {
            if (matchCnt == winning.getMatchNum()) {
                winningResultMap.put(winning, winningResultMap.get(winning) + 1);
            }
        }
    }

    private int calcMatchNumber(Lotto lotto, List<Integer> randomLottoNums) {
        int matchCnt = 0;
        for (Integer winningNum : lotto.getWinningNumbers()) {
            if (randomLottoNums.contains(winningNum)) {
                matchCnt++;
            }
        }
        return matchCnt;
    }

    private HashMap<Winning, Integer> initWinningResultMap() {
        HashMap<Winning, Integer> map = new HashMap<>();
        for (Winning winning : Winning.values()) {
            map.put(winning, 0);
        }
        return map;
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_MIN_NUM, Lotto.LOTTO_MAX_NUM, Lotto.MAX_LOTTO_SIZE);
    }
}
