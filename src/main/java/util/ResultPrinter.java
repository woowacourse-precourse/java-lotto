package util;

import java.util.List;

public class ResultPrinter {
    private List<Integer> resultList;
    private int money;
    private final int FIRST_INCOME = 2000000000;
    private final int SECCOND_INCOME = 30000000;
    private final int THIRD_INCOME = 1500000;
    private final int FOURTH_INCOME = 50000;
    private final int FIFTH_INCOME = 5000;

    public ResultPrinter(List<Integer> resultList, int money) {
        this.resultList = resultList;
        this.money = money;
    }

    public void printResult() {
        System.out.printf("당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) : %d개\n" +
                "4개 일치 (50,000원) : %d개\n" +
                "5개 일치 (1,500,000원) : %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) : %d개\n" +
                "6개 일치 (2,000,000,000원) : %d개\n" +
                "총 수익률은 %lf.1% 입니다.", resultList.get(RankType.FIFTH.ordinal()),
                resultList.get(RankType.FOURTH.ordinal()),
                resultList.get(RankType.THIRD.ordinal()),
                resultList.get(RankType.SECCOND.ordinal()),
                resultList.get(RankType.FIRST.ordinal()), calculateIncomeRate()
                );
    }

    private double calculateIncomeRate() {
        int sumofincome = resultList.get(RankType.FIFTH.ordinal())*FIFTH_INCOME+
                resultList.get(RankType.FOURTH.ordinal())*FOURTH_INCOME+
                resultList.get(RankType.THIRD.ordinal())*THIRD_INCOME+
                resultList.get(RankType.SECCOND.ordinal())*SECCOND_INCOME+
                resultList.get(RankType.FIRST.ordinal())*FIRST_INCOME;
        return (double)sumofincome / money;
    }
}
