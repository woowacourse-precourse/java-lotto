package lotto.dto;

import java.util.List;

public class LottoStatsDTO {
    private final Integer matchThreeNumbers;
    private final Integer matchFourNumbers;
    private final Integer matchFiveNumbers;
    private final Integer matchFiveNumbersAndBonus;
    private final Integer matchSixNumbers;
    private final double yieldPercent;

    public LottoStatsDTO(Integer matchThreeNumbers, Integer matchFourNumbers, Integer matchFiveNumbers,
	Integer matchFiveNumbersAndBonus, Integer matchSixNumbers, double yieldPercent) {
	this.matchThreeNumbers = matchThreeNumbers;
	this.matchFourNumbers = matchFourNumbers;
	this.matchFiveNumbers = matchFiveNumbers;
	this.matchFiveNumbersAndBonus = matchFiveNumbersAndBonus;
	this.matchSixNumbers = matchSixNumbers;
	this.yieldPercent = yieldPercent;
    }

    public Integer getMatchThreeNumbers() {
	return matchThreeNumbers;
    }

    public Integer getMatchFourNumbers() {
	return matchFourNumbers;
    }

    public Integer getMatchFiveNumbers() {
	return matchFiveNumbers;
    }

    public Integer getMatchFiveNumbersAndBonus() {
	return matchFiveNumbersAndBonus;
    }

    public Integer getMatchSixNumbers() {
	return matchSixNumbers;
    }

    public double getYieldPercent() {
	return yieldPercent;
    }
}
