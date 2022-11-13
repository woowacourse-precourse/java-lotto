package lotto.domain;

import lotto.domain.chart.RankChart;

import java.util.Collections;
import java.util.List;

public class Counter {
    public int countFirst(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FirstPlace.getValue());
    }

    public int countSecond(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.SecondPlace.getValue());
    }

    public int countThird(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.ThirdPlace.getValue());
    }

    public int countFourth(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FourthPlace.getValue());
    }

    public int countFifth(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FifthPlace.getValue());
    }
}
