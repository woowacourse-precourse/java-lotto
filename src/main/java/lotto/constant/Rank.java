package lotto.constant;

import java.text.NumberFormat;

public enum Rank {
    FIRST(2000000000, 6, null, null),
    SECOND(30000000, 5, 5, true),
    THIRD(1500000, 5, 5, false),
    FOURTH(50000, 4, 4, null),
    FIFTH(5000, 3, 3, null),
    SIXTH(0, null, null, null);

    final private Integer winning;
    final private Integer minMatchNum;
    final private Integer maxMatchNum;
    final private Boolean isBonusRequired;

    Rank(Integer winning, Integer minMatchNum, Integer maxMatchNum, Boolean isBonusRequired) {
        this.winning = winning;
        this.minMatchNum = minMatchNum;
        this.maxMatchNum = maxMatchNum;
        this.isBonusRequired = isBonusRequired;
    }

    public String getOutputMessage() {
        StringBuilder sb = new StringBuilder();
        if (minMatchNum == null) {
            return null;
        }
        if (minMatchNum >= 0) {
            sb.append(String.format(PrintMessage.LOTTO_MATCH_COUNT.getString(), minMatchNum));
        }
        if (isBonusRequired != null && isBonusRequired) {
            sb.append(PrintMessage.LOTTO_MATCH_BONUS.getString());
        }
        String commaWinning = NumberFormat.getInstance().format(winning);
        sb.append(String.format(PrintMessage.LOTTO_MATCH_RESULT.getString(), commaWinning));
        return sb.toString();
    }

    public Integer getWinning(int correctNumberCount, boolean isBonusCorrect) {
        if (minMatchNum != null && correctNumberCount < minMatchNum) {
            return null;
        }
        if (maxMatchNum != null && correctNumberCount > maxMatchNum) {
            return null;
        }
        if (isBonusRequired != null && isBonusCorrect != isBonusRequired) {
            return null;
        }
        return winning;
    }

}
