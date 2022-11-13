package lotto;

public enum Correct {

    CORRECT_THREE(3, false, 5000L),
    CORRECT_FOUR(4, false, 50000L),
    CORRECT_FIVE(5, false, 1500000L),
    CORRECT_FIVE_BONUS(5, true, 30000000L),
    CORRECT_SIX(6, false, 2000000000L);

    final int correct;
    final boolean isBonusCorrect;
    final long prize;

    Correct(int correct, boolean isBonusCorrect, long prize) {
        this.correct = correct;
        this.isBonusCorrect = isBonusCorrect;
        this.prize = prize;
    }
}
