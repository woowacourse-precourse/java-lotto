package lotto.domain;

import lotto.service.RankChart;

import java.util.Collections;
import java.util.List;

public class Counter {
    public int countFirst(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FIRST_PLACE.getValue());
    }

    public int countSecond(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.SECOND_PLACE.getValue());
    }

    public int countThird(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.THIRD_PLACE.getValue());
    }

    public int countFourth(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FOURTH_PLACE.getValue());
    }

    public int countFifth(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FIFTH_PLACE.getValue());
    }
}
