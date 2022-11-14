package lotto.service;

import lotto.domain.Rank;
import lotto.dto.ResponseRankAggregation;

public class YieldService {
    public String calculate(ResponseRankAggregation responseRankAggregation, String pay) {
        double firstRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getFirstRankCount(), Rank.FIRST);
        double secondRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getSecondRankCount(), Rank.SECOND);
        double thirdRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getThirdRankCount(), Rank.THIRD);
        double fourthRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getFourthRankCount(), Rank.FOURTH);
        double fifthRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getFifthRankCount(), Rank.FIFTH);

        double totalRankMoney = Calculator.PLUS.sum(firstRankMoney, secondRankMoney, thirdRankMoney, fourthRankMoney, fifthRankMoney);

        int payment = Integer.parseInt(pay);

        return String.format("%.1f", (totalRankMoney / payment) * 100);
    }
}
