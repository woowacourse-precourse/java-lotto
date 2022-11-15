package lotto;

import static validation.Validator.ERROR_MESSAGE;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ARE_NOT_VALID_VALUE = "는 유효하지 않은 값입니다.";

    private final int countOfMatchingNumbers;
    private final int winningMoney;

    Rank(int countOfMatchingNumbers, int winningMoney) {
        this.countOfMatchingNumbers = countOfMatchingNumbers;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank of(int countOfMatchingNumbers, boolean includesBonusNumber) {
        if (isLessThanThreeMatches(countOfMatchingNumbers)) {
            return LOSE;
        }

        if (isSecondRank(countOfMatchingNumbers, includesBonusNumber)) {
            return SECOND;
        }

        Rank rank = getRank(countOfMatchingNumbers);
        if (rank != null) {
            return rank;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE + countOfMatchingNumbers + ARE_NOT_VALID_VALUE);
    }

    private static boolean isLessThanThreeMatches(int countOfMatchingNumbers) {
        return countOfMatchingNumbers < WINNING_MIN_COUNT;
    }

    private static boolean isSecondRank(int countOfMatchingNumbers, boolean includesBonusNumber) {
        return SECOND.checkCountOfMatches(countOfMatchingNumbers) && includesBonusNumber;
    }

    private static Rank getRank(int countOfMatchingNumbers) {
        for (Rank rank : values()) {
            if (rank.checkCountOfMatches(countOfMatchingNumbers)) {
                return rank;
            }
        }

        return null;
    }

    private boolean checkCountOfMatches(int countOfMatchingNumbers) {
        return this.countOfMatchingNumbers == countOfMatchingNumbers;
    }
}
