package models;

import constants.LottoConstant;
import constants.PrizeDivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    List<Integer> divisionCount;

    public Statistics() {
        this.divisionCount = new ArrayList<>(Collections.nCopies(LottoConstant.NUMBERS_SIZE, 0));
    }

    public void countDivision(int division) {
        if (division != PrizeDivision.NO_DIVISION.getDivision()) {
            divisionCount.set(division, divisionCount.get(division) + 1);
        }
    }

    public List<Integer> getDivisionCount() {
        return divisionCount;
    }

}
