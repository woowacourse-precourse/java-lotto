package lotto.domain;

import static lotto.domain.Rank.*;

public class Result {
    private long userMoney;
    private double earningsRate;
    private long resultMoney;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;


    public Result(long userMoney) {
        this.userMoney = userMoney;
    }

    public void checkRanks(Calculator calculator) {
        int count = calculator.getAnswerCount();
        if(count == 6) {
            first += 1;
        } else if(count == 5 && calculator.isBonus()) {
            second += 1;
        } else if(count == 5) {
            third += 1;
        }else if(count == 4) {
            fourth += 1;
        }else if(count == 3) {
            fifth += 1;
        }
    }

    public void calcAllResult(){
        calcResultMoney();
        calcEarningRate();
    }

    public void calcResultMoney(){
        resultMoney = first*FIRST.value() + second*SECOND.value() + third*THIRD.value()
                + fourth*FOURTH.value() + fifth*FIFTH.value();
    }

    public void calcEarningRate(){
        earningsRate = ((double)resultMoney/(double)userMoney) * 100;
    }


    public double getEarningsRate() {
        return earningsRate;
    }

    public long getResultMoney() {
        return resultMoney;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }
}
