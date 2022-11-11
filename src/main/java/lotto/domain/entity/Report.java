package lotto.domain.entity;

import java.util.List;
import lotto.domain.vo.MatchReport;

public class Report {

    private int totalPrize = 0;


    public void printEachPrize(List<MatchReport> matchReports) {

        // TODO: 2022/11/11 matchReport list를 갖고 점수 계산
        for (MatchReport matchReport : matchReports) {

        }
    }

    /*
    *
    * 3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
    * */

    // 5000 / 8000 -> 62.5%
    public String TotalInterest(int userMoney) {
        double interest = (double) 5000 / userMoney;
        double roundedInterest = (double) Math.round(interest * 1000) / 10;
        return interestToPrintValue(roundedInterest);
    }

    private String interestToPrintValue(double interest) {
        return String.valueOf(interest);
    }

}
