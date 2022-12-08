package lotto.lotto;

import java.text.NumberFormat;

public enum LottoRank {
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int money;
    private final int matchedCount;
    private String commaMoney;
    private int result = 0;

    LottoRank(int money, int matchedCount) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String str = numberFormat.format(money);
        this.money = money;
        this.matchedCount = matchedCount;
        this.commaMoney = str;
    }

    public void plus() {
        this.result++;
    }

    public int getMoney() {
        return money;
    }

    public int getResult() {
        return result;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    @Override
    public String toString() {
        if(this.money == 30_000_000) {
            return matchedCount + "개 일치, 보너스 볼 일치 " + "(" + commaMoney + "원)" + " - " + result + "개";
        }
        return matchedCount + "개 일치 " + "(" + commaMoney + "원)" + " - " + result + "개";
    }
}


