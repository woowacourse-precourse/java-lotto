package lotto.domain;

import lotto.domain.chart.RankChart;

import java.util.Collections;
import java.util.List;

public class Counter {
    public static int countFirst(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FirstPlace.getValue());
    }

    public static int countSecond(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.SecondPlace.getValue());
    }

    public static int countThird(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.ThirdPlace.getValue());
    }

    public static int countFourth(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FourthPlace.getValue());
    }

    public static int countFifth(List<Integer> ranking) {
        return Collections.frequency(ranking, RankChart.FifthPlace.getValue());
    }
}
