package lotto.domain;

import lotto.constant.Score;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.Score.*;

public class LottoScore {

    private static final Map<Score, Integer> scoreStore = new HashMap<>();

    public static Map<Score, Integer> setInitialSetting() {
        scoreStore.put(THREE, 0);
        scoreStore.put(FOUR, 0);
        scoreStore.put(FIVE, 0);
        scoreStore.put(FIVE_BONUS, 0);
        scoreStore.put(SIX, 0);
        return scoreStore;
    }

    public static void update(List<Integer> lottoNumbers, int score, int bonusNumber) {
        isThree(score);
        isFour(score);
        isFive(lottoNumbers, score, bonusNumber);
        isFiveBonus(lottoNumbers, score, bonusNumber);
        isSix(score);
    }

    private static void isSix(int score) {
        if (score == 6) {
            Integer count = scoreStore.get(SIX);
            scoreStore.put(SIX, ++count);
        }
    }

    private static void isFiveBonus(List<Integer> lottoNumbers, int score, int bonusNumber) {
        if (score == 5 && lottoNumbers.contains(bonusNumber)) {
            Integer count = scoreStore.get(FIVE_BONUS);
            scoreStore.put(FIVE_BONUS, ++count);
        }
    }

    private static void isFive(List<Integer> lottoNumbers, int score, int bonusNumber) {
        if (score == 5 && !lottoNumbers.contains(bonusNumber)) {
            Integer count = scoreStore.get(FIVE);
            scoreStore.put(FIVE, ++count);
        }
    }

    private static void isFour(int score) {
        if (score == 4) {
            Integer count = scoreStore.get(FOUR);
            scoreStore.put(FOUR, ++count);
        }
    }

    private static void isThree(int score) {
        if (score == 3) {
            Integer count = scoreStore.get(THREE);
            scoreStore.put(THREE, ++count);
        }
    }
}
