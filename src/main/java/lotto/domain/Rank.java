package lotto.domain;

import lotto.service.RankChart;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    public List<Integer> rankNumbers(List<Integer> sameNumbers) {
        List<Integer> rankRecord = new ArrayList<>();
        for (int sameNumber : sameNumbers) {
            rankRecord.add(changeRank(sameNumber));

        }
        return rankRecord;
    }

    private int changeRank(int i) {
        if (i == RankChart.FIRST_PLACE.getValue()) {
            return RankChart.FIRST_PLACE.getValue();

        }
        if (i == RankChart.SECOND_PLACE.getValue()) {
            return RankChart.SECOND_PLACE.getValue();

        }
        if (i == RankChart.THIRD_PLACE.getValue()) {
            return RankChart.THIRD_PLACE.getValue();

        }
        if (i == RankChart.FOURTH_PLACE.getValue()) {
            return RankChart.FOURTH_PLACE.getValue();

        }
        if (i == RankChart.FIFTH_PLACE.getValue()) {
            return RankChart.FIFTH_PLACE.getValue();
        }
        return 0;
    }


}



