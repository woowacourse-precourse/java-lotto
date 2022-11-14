package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoReward {
    CORRECT_THREE(0, 5000),
    CORRECT_FOUR(1, 50000),
    CORRECT_FIVE(2, 1500000),
    CORRECT_5_BONUS(3, 30000000),
    CORRECT_SIX(4, 2000000000);

    private final int reward;
    private final int correct;

    public int getReward() {
        return reward;
    }

    public int getCorrect() {
        return correct;
    }

    LottoReward(int correct, int reward) {
        this.reward = reward;
        this.correct = correct;
    }

    public static LottoReward withCorrectNum(int correct) {
        for (LottoReward lottoReward : LottoReward.values()) {
            if (lottoReward.correct == correct) {
                return lottoReward;
            }
        }
        throw new IllegalArgumentException();
    }

}
