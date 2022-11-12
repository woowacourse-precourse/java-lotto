package lotto.setting;

public enum WinningNumberSetting {
    NORMAL(45, 6, 1);

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER;
    private final int NUMBER_OF_DRAWS;
    private final int BONUS_DRAWS;

    WinningNumberSetting(int maxNumber, int numberOfDraws, int bonusDraws) {
        this.MAX_NUMBER = maxNumber;
        this.NUMBER_OF_DRAWS = numberOfDraws;
        this.BONUS_DRAWS = bonusDraws;
    }
}
