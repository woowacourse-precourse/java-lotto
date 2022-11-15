package models;

import constants.PrizeDivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {
    private List<Integer> divisionsCount;
    private long prizeAmountSummation;
    private double rateOfReturn;

    public Statistics() {
        divisionsCount = new ArrayList<>(Collections.nCopies(PrizeDivision.values().length, 0));
    }

    public void setPrizeAmountSummationAndRateOfReturn(long prizeAmountSummation, double rateOfReturn) {
        this.prizeAmountSummation = prizeAmountSummation;
        this.rateOfReturn = rateOfReturn;
    }

    public List<Integer> getDivisionsCount() {
        return divisionsCount;
    }

    public long getPrizeAmountSummation() {
        return prizeAmountSummation;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
