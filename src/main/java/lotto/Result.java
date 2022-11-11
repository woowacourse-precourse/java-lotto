package lotto;

import static lotto.Rank.*;

public class Result {
    private double earningsRate;
    private long resultMoney;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;

    public void checkRanks(Comparator comparator) {
        int count = comparator.getAnswerCount();
        if(count == 6) {
            first += 1;
        } else if(count == 5 && comparator.isBonus()) {
            second += 1;
        } else if(count == 4) {
            third += 1;
        }else if(count == 3) {
            fourth += 1;
        }else if(count == 2) {
            fifth += 1;
        }
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

    public void showResult(){
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        System.out.println("총 수익률은 " + Math.round(earningsRate*10)/10.0 + "%입니다.");
    }

    public void calcResultMoney(){
        resultMoney = first*FIRST.money() + second*SECOND.money() + third*THIRD.money()
                + fourth*FOURTH.money() + fifth*FIFTH.money();
    }

    public void calcEarningRate(int userMoney, int resultMoney){
        earningsRate = ((double)resultMoney/(double)userMoney) * 100;
    }
}
