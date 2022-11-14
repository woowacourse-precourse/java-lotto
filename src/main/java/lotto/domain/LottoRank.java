package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST( 6,  0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(4, 0, 50000),
    FIFTH(3, 0, 5000);

    private final int matchCount;

    private final int bonusCount;

    private final int winMoney;

    LottoRank(int matchCount, int bonusCount, int winMoney) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.winMoney = winMoney;
    }

    public static LottoRank of(int result, int bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == result)
                .filter(lottoRank -> lottoRank.bonusCount == bonus)
                .findAny()
                .orElseThrow();
    }

    public int findTotalMoney (int cnt) {
        return winMoney * cnt;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치%s (%s원)", matchCount, isBonus(), splitByComma(winMoney));
    }

    private String splitByComma(Integer winMoney) {
        StringBuilder result = new StringBuilder();
        result.append(winMoney.toString());

        int cnt = 1;
        for(int i = result.length() - 1; i >= 0 ; i--) {
            if (cnt % 3 == 0) {
                result.insert(i, ",");
            }
            cnt += 1;
        }
        return result.toString();
    }

    private String isBonus() {
        if (bonusCount == 1) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public int matchCount() {
        return matchCount;
    }

    public int bonusCount() {
        return bonusCount;
    }
}
