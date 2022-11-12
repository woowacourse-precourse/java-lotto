package lotto.domain;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static lotto.utils.Constants.*;

public enum LottoResult implements Comparable<LottoResult> {
    FIFTH(3, 5_000), // 5등
    FOURTH(4, 50_000), // 4등
    THIRD(5, 1_500_000), // 3등
    SECOND(5, 30_000_000), // 2등
    FIRST(6, 2_000_000_000), // 1등
    FAILED(0, 0);

    private static final Map<Integer, LottoResult> BY_COUNT_OF_MATCH = new HashMap<>();

    private final int countOfMatch;
    private final int winningMoney;

    static {
        for (LottoResult lottoResult : values()) {
            BY_COUNT_OF_MATCH.put(lottoResult.countOfMatch, lottoResult);
        }
        BY_COUNT_OF_MATCH.put(THIRD.countOfMatch, THIRD);
    }

    LottoResult(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static LottoResult valueOf(int count, boolean isMatchWithBonusNumber) {
        if (count < WINNING_MIN_COUNT) {
            return FAILED;
        }
        if (count == SECOND.countOfMatch && isMatchWithBonusNumber) {
            return SECOND;
        }

        return BY_COUNT_OF_MATCH.get(count);
    }

    public boolean isNotFailed() {
        return this != LottoResult.FAILED;
    }

    public long calculatePrizeMoney(long numberOfWinningLotto) {
        return (long) this.winningMoney * numberOfWinningLotto;
    }

    private String printBonusMessage() {
        if (this == SECOND) {
            return BONUS_NUMBER_MESSAGE;
        }
        return "";
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat(WINNING_MONEY_FORMAT);
        return countOfMatch + COUNT_UNIT_MESSAGE + EQUALS_MESSAGE + printBonusMessage() + LEFT_PARENTHESIS + formatter.format(winningMoney) + WINNING_MONEY_UNIT_MESSAGE;
    }
}
