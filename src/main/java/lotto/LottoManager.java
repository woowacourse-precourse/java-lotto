package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoManager {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int LOTTO_COUNT = 6;

    public List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_COUNT);
    }

    public int compareSameNumberBetweenTwoLotto(Lotto left, Lotto right) {
        Set<Integer> leftSet = left.getSetOfLottoNumbers();
        Set<Integer> rightSet = right.getSetOfLottoNumbers();

        leftSet.retainAll(rightSet);
        return leftSet.size();
    }

    public Map<Integer, Integer> getScore(List<Lotto> myLottoList, Lotto answerLotto, int bonusNumber) {
        Map<Integer, Integer> score = new HashMap<>();

        for (Lotto myLotto : myLottoList) {
            int eachScore = compareSameNumberBetweenTwoLotto(myLotto, answerLotto);
            if (myLotto.getSetOfLottoNumbers().contains(bonusNumber)) {
                eachScore = eachScore + 10;
            }

            score.put(eachScore, score.getOrDefault(eachScore, 0) + 1);
        }

        return score;
    }
}
