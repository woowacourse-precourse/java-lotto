package lotto.model.statistics;

import java.text.DecimalFormat;

public enum LottoResult {
    FIRST(1, 6, false, 2000000000),
    SECOND(2, 5, true, 30000000),
    THIRD(3, 5, false, 1500000),
    FOURTH(4, 4, false, 50000),
    FIFTH(5, 3, false, 5000),
    MISS(0, 0, false, 0)
    ;

    private static final DecimalFormat decimalFormatter = new DecimalFormat("###,###");
    private final int grade;
    private final int matchCount;
    private final boolean doesMatchBonusBall;
    private final int prize;

    LottoResult(
            int grade,
            int matchCount,
            boolean doesMatchBonusBall,
            int prize
    ) {
        this.grade = grade;
        this.matchCount = matchCount;
        this.doesMatchBonusBall = doesMatchBonusBall;
        this.prize = prize;
    }

    public int getPrize() {
        // TODO 구현 필요
        return 0;
    }

    public String getDescription() {
        if(this.equals(MISS)) {
            return "꽝";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchCount).append("개 일치");
        if(doesMatchBonusBall) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(decimalFormatter.format(prize)).append("원)");

        return stringBuilder.toString();
    }
}
