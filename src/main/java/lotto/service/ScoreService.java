package lotto.service;

import lotto.domain.Match;
import lotto.domain.Score;

import java.util.List;

public class ScoreService {

    public void calculateScore(List<Integer> sameNumberCount) {
        initCount();
        for (int i = 0; i < sameNumberCount.size(); i++) {
            compare(sameNumberCount, i);
        }
    }

    private void compare(List<Integer> sameNumberList, int i) {
        for (int j = 0; j < Match.values().length; j++) {

            if (sameNumberList.get(i) == Match.values()[j].getMatch()) {

                increaseCount(j);
            }
        }
    }

    private void increaseCount(int index) {
        Integer num = Score.count.get(index);
        num++;
        Score.count.add(index, num);
        System.out.println(Score.count.get(index));
    }

    private void initCount() {
        for (int i = 0; i < 4; i++) {
            Score.count.add(0);
        }
    }
}
