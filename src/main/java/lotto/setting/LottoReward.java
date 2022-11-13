package lotto.setting;

import java.text.DecimalFormat;

public enum LottoReward {
    FIRST(6,0,2_000_000_000),
    SECOND(5,1,30_000_000),
    THIRD(5,0,1_500_000),
    FOURTH(4,0,50_000),
    FIFTH(3,0,5_000);

    private int countMatch;
    private int bonusMatch;
    private long prize;

    LottoReward(int countMatch, int bonusMatch, long prize) {
        this.countMatch = countMatch;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public String getRewardInfo() {
        // form : 3개 일치 (5,000원)
        return getMatchInfo() + " " + getPriceInfo();
    }

    private String getMatchInfo() {
        return countMatchInfo() + bonusMatchInfo();
    }

    private String countMatchInfo() {
        return countMatch + "개 일치";
    }

    private String bonusMatchInfo() {
        if (bonusMatch == 0) {
            return "";
        }
        if (bonusMatch == 1) {
            return ", 보너스 볼 일치";
        }
        return ", 보너스 볼 " + bonusMatch + "개 일치";
    }

    private String getPriceInfo() {
        return "(" + shipShapedPrice() + "원)";
    }

    private String shipShapedPrice() {
        return new DecimalFormat("###,###").format(prize);
    }
}
