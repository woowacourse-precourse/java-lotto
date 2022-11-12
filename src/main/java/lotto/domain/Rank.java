package lotto.domain;

import lotto.domain.chart.RankChart;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    public static List<Integer> rankNumbers(List<Integer> sameNumbers) {
        List<Integer> rankRecord = new ArrayList<>();
        for (int sameNumber : sameNumbers) {
            rankRecord.add(changeRank(sameNumber));

        }
        return rankRecord;
    }

    public static int changeRank(int i) {
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



