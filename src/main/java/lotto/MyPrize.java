package lotto;

public class MyPrize {
    // 총 5등까지 있으므로 크기 6짜리 배열
    // 1등은 인덱스 1, 5등은 인덱스 5를 가진다
    private int [] rankArr;
    private long profitAmount;

    private long [] fixedPrizeMoneyByRanking = {0, 2000000000, 30000000, 1500000, 50000, 5000};

    public MyPrize(int[] rankArr) {
        this.rankArr = rankArr;
        calculateProfitAmount(rankArr);
    }

    private void calculateProfitAmount(int [] rankArr) {
        for(int i=1 ; i<6 ; i++) {
            if(rankArr[i] > 0) {
                profitAmount = profitAmount + fixedPrizeMoneyByRanking[i] * rankArr[i];
            }
        }
    }
}
