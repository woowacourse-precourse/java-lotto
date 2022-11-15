package lotto.dto;

import java.util.List;

import lotto.domain.Prize;

public class RoundResult {
    private final List<Prize> prizes;
    private final double rateOfReturn;

    public RoundResult(List<Prize> prizes, double rateOfReturn) {
        this.prizes = prizes;
        this.rateOfReturn = rateOfReturn;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
