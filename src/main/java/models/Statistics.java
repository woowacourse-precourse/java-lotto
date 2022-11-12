package models;

import constants.LottoConstant;
import constants.PrizeDivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {
    List<Integer> divisionsCount;

    public Statistics() {
        this.divisionsCount = new ArrayList<>(Collections.nCopies(PrizeDivision.values().length, 0));
    }
    public void countDivisions(int division) {
        if (division != PrizeDivision.NO_DIVISION.getDivision()) {
            divisionsCount.set(division, divisionsCount.get(division) + 1);
        }
    }

    public List<Integer> getDivisionsCount() {
        return divisionsCount;
    }

}
