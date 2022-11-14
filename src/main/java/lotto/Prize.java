package lotto;

import java.text.DecimalFormat;

public enum Prize {
    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FORTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    NOTHING("3개 미만 일치", 0);

    private String matchCount;
    private Integer reward;

    Prize(String matchCount, Integer reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public String getMatchCount() {
        return matchCount;
    }

    public Integer getReward() {
        return reward;
    }

    public void printPrize(int count) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        System.out.println(this.getMatchCount() + " (" + decFormat.format(this.getReward()) + "원) - " + count + "개");
    }

    public long getReturn(int count) {
        return this.reward * count;
    }

}
