package lotto.type;

import java.util.Set;
import lotto.data.entity.Lotto;
import lotto.data.entity.WinNumber;
import utils.DecimalFormatter;

public enum LottoResultType {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean needBonusMatch;
    private final int amount;
    private final String viewMessage;

    LottoResultType(int matchCount, boolean needBonusMatch, int amount) {
        this.matchCount = matchCount;
        this.needBonusMatch = needBonusMatch;
        this.amount = amount;
        String conditionAdder = "";
        if (needBonusMatch) {
            conditionAdder = MessageType.BONUS_MATCH.getMessage();
        }
        this.viewMessage = String.format(MessageType.RESULT_COUNT.getMessage(),
                matchCount, conditionAdder, DecimalFormatter.formatNumber((double) amount), "%d");
    }

    public int getAmount() {
        return this.amount;
    }

    public String getViewMessage() {
        return viewMessage;
    }

    public boolean isAcquired(Lotto lotto, WinNumber winNumber) {
        boolean checkWinNumber = getMatches(lotto, winNumber.getWinNumbers()) >= matchCount;
        boolean checkBonusNumber = !needBonusMatch || hasBonusNumber(lotto, winNumber.getBonusNumber());
        return checkWinNumber && checkBonusNumber;
    }

    private static int getMatches(Lotto lotto, Set<Integer> winNumbers) {
        return (int) lotto.getNumbers()
                .stream()
                .filter(winNumbers::contains)
                .count();
    }

    private static boolean hasBonusNumber(Lotto lotto, Integer bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
