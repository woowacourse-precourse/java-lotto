package lotto.domain;

import lotto.domain.chart.RankChart;

import java.util.ArrayList;
import java.util.List;

public class Compensation {

    public static List<Integer> li(List<Integer> ranking) {
        List<Integer> li = new ArrayList<>();
        for (int i : ranking) {
            li.add(jk(i));

        }
        return li;
    }

    public static int jk(int i) {
        if (i == RankChart.FirstPlace.getValue()) {
            return RankChart.FirstPlace.getValue();

        }
        if (i == RankChart.SecondPlace.getValue()) {
            return RankChart.SecondPlace.getValue();

        }
        if (i == RankChart.ThirdPlace.getValue()) {
            return RankChart.SecondPlace.getValue();

        }
        if (i == RankChart.FourthPlace.getValue()) {
            return RankChart.FourthPlace.getValue();

        }
        if (i == RankChart.FifthPlace.getValue()) {
            return RankChart.FifthPlace.getValue();
        }
        return 0;
    }


}



