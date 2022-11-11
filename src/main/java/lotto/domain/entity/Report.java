package lotto.domain.entity;

import static lotto.domain.wrapper.Rank.FIFTH;
import static lotto.domain.wrapper.Rank.FIRST;
import static lotto.domain.wrapper.Rank.FOURTH;
import static lotto.domain.wrapper.Rank.SECOND;
import static lotto.domain.wrapper.Rank.THIRD;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.vo.MatchReport;
import lotto.domain.wrapper.Rank;

public class Report {

    private int totalPrize = 0;
    private Map<Rank, Integer> matchResultMap = new LinkedHashMap<>();


    public Map<Rank, Integer> printEachPrize(List<MatchReport> matchReports) {
        matchResultMapSetting();
        // TODO: 2022/11/11 matchReport list를 갖고 점수 계산
        for (MatchReport matchReport : matchReports) {
            // 3개 맞춤 prize
            if (matchReport.currentHitCount() == 3 || (matchReport.currentHitCount() == 2
                && matchReport.currentBonus() == true)) {
                Integer amountOfFifthPrize = matchResultMap.get(FIFTH);
                amountOfFifthPrize += 1;
                matchResultMap.replace(FIFTH, amountOfFifthPrize);
                continue;
            }
            // 4개 맞춤 prize
            if (matchReport.currentHitCount() == 4 || (matchReport.currentHitCount() == 3
                && matchReport.currentBonus() == true)) {
                Integer amountOfFourthPrize = matchResultMap.get(FOURTH);
                amountOfFourthPrize += 1;
                matchResultMap.replace(FOURTH, amountOfFourthPrize);
                continue;
            }
            // 5개의 숫자 맞을 경우
            if (matchReport.currentHitCount() == 5) {
                Integer amountOfThirdPrize = matchResultMap.get(THIRD);
                amountOfThirdPrize += 1;
                matchResultMap.replace(THIRD, amountOfThirdPrize);
                continue;
            }
            // 4개의 숫자와 하나의 보너스가 맞을 경우
            if (matchReport.currentHitCount() == 4 && matchReport.currentBonus() == true) {
                Integer amountOfSecondPrize = matchResultMap.get(SECOND);
                amountOfSecondPrize += 1;
                matchResultMap.replace(SECOND, amountOfSecondPrize);
                continue;
            }
            // 5개의 모든 숫자가 맞을 경우
            if (matchReport.currentHitCount() == 5) {
                Integer amountOfFirstPrize = matchResultMap.get(FIRST);
                amountOfFirstPrize += 1;
                matchResultMap.replace(FIRST, amountOfFirstPrize);
                continue;
            }
        }
        return matchResultMap;
    }

    public String TotalInterest(int userMoney) {
        getTotalPrize();
        double interest = (double) totalPrize / userMoney;
        double roundedInterest = (double) Math.round(interest * 1000) / 10;
        return interestToPrintValue(roundedInterest);
    }

    private void getTotalPrize() {
        for (Rank rank : matchResultMap.keySet()) {
            Integer integer = matchResultMap.get(rank);
            if (integer == 0) {
                continue;
            }
            totalPrize += (rank.currentPrize() * integer);
        }
    }

    private void matchResultMapSetting() {
        matchResultMap.put(FIFTH, 0); // 3개 맞춤 prize : 5000
        matchResultMap.put(FOURTH, 0); // 4개 맞춤 prize : 50,000
        matchResultMap.put(THIRD, 0); // 5개 맞춤 prize : 1,500,000
        matchResultMap.put(SECOND, 0); // 4개 맞추고 보너스 맞춤 : 30,000,000
        matchResultMap.put(FIRST, 0); // 6개 모두 맞춤 : 2,000,000,000
    }

    private String interestToPrintValue(double interest) {
        return String.valueOf(interest);
    }

}
