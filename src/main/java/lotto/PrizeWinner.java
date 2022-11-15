package lotto;

import java.text.DecimalFormat;

public enum PrizeWinner {

    FIFTHPLACE("3개 일치", 5000,0),
    FOURTHPLACE("4개 일치", 50000,0),
    THIRDPLACE("5개 일치", 1500000,0),
    SECONDPLACE("5개 일치, 보너스 볼 일치", 30000000,0),
    FIRSTPLACE("6개 일치", 2000000000,0);

    private final String matchingHistory;
    private final Integer prizeMoney;
    private final String monetaryUnit = "원";
    private final DecimalFormat prizeMoneyFormatter = new DecimalFormat("###,###");
    private Integer count;

    PrizeWinner(String matchingHistory, Integer prizeMoney, Integer count) {
        this.matchingHistory = matchingHistory;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public void addCount() {
        this.count += 1;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  matchingHistory +
                " (" + prizeMoneyFormatter.format(prizeMoney) + monetaryUnit + ")" +
                " - " + count + "개";
    }
}
