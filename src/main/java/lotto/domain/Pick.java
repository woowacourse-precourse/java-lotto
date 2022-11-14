package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Validation;

import java.util.ArrayList;
import java.util.List;


public class Pick {
    private final List<Integer> answer;
    private final int bonus;
    private List<Integer> scores;

    public Pick(List<Integer> answer, int bonus) {
        this.answer = answer;
        this.bonus = bonus;
        this.scores = initScores();
    }

    private List<Integer> initScores() {
        List<Integer> scores = new ArrayList<>();
        int lowestRank = 5;

        for (int rank = 0; rank <= lowestRank; rank++) {
            scores.add(0);
        }

        return scores;
    }
}
