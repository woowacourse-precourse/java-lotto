package lotto.domain;

public enum LottoResult {

    FIFTH("3개 일치 (5,000원) - ", 5_000),
    FOURTH("4개 일치 (50,000원) - ", 50_000),
    THIRD("5개 일치 (1,500,000원) - ", 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000),
    FIRST("6개 일치 (2,000,000,000원) - ", 2_000_000_000);


    String result;
    int prize;
    int count;
    int profit;

    LottoResult(String result, int prize) {
        this.result = result;
        this.prize = prize;
    }

    public void init() {
        this.count = 0;
        this.profit = 0;
    }

    public String getName() {
        return result;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public int getProfit() {
        profit = prize*count;
        return profit;
    }
}
