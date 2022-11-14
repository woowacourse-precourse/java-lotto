package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    enum LottoReward {
        MISS(0, 0),
        FIFTH(5, 5_000),
        FOURTH(4, 50_000),
        THIRD(3, 1_500_000),
        SECOND(2, 30_000_000),
        FIRST(1, 2_000_000_000);

        private Integer rank;
        private Integer reward;

        LottoReward(final Integer rank, final Integer reward) {
            this.rank = rank;
            this.reward = reward;
        }

        public static Integer getRewardByRank(Integer rank) {
            for (LottoReward e : LottoReward.values()) {
                if (e.rank == rank) {
                    return e.reward;
                }
            }
            return null;
        }
    }

    public Lotto(List<Integer> numbers) {
        HashSet<Integer> playerNumbers = Model.MakeListToSet(numbers);
        Controller.ValidatePlayerNumber(playerNumbers);
        this.numbers = numbers;
    }
}
