package lotto.service;

import lotto.domain.Rank;
import lotto.dto.ResponseRankAggregation;

public class YieldService {
    public void calculate(ResponseRankAggregation responseRankAggregation, String pay) {
        double firstRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getFirstRankCount(), Rank.FIRST);
        double secondRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getSecondRankCount(), Rank.SECOND);
        double thirdRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getThirdRankCount(), Rank.THIRD);
        double fourthRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getFourthRankCount(), Rank.FOURTH);
        double fifthRankMoney = Calculator.MULTIPLICATION.apply(responseRankAggregation.getFifthRankCount(), Rank.FIFTH);

        double totalRankMoney = Calculator.PLUS.sum(firstRankMoney, secondRankMoney, thirdRankMoney, fourthRankMoney, fifthRankMoney);

        int payment = Integer.parseInt(pay);

        double result = (totalRankMoney / payment) * 100;
        System.out.println("총 수익률은 " + result + "%");
    }
}
