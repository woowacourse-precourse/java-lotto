package lotto;

public enum Correct {

    CORRECT_THREE(3, false, 5000L , 5),
    CORRECT_FOUR(4, false, 50000L, 4),
    CORRECT_FIVE(5, false, 1500000L, 3),
    CORRECT_FIVE_BONUS(5, true, 30000000L, 2),
    CORRECT_SIX(6, false, 2000000000L, 1);

    final int correct;
    final boolean isBonusCorrect;
    final long prize;
    final int place;

    Correct(int correct, boolean isBonusCorrect, long prize, int place) {
        this.correct = correct;
        this.isBonusCorrect = isBonusCorrect;
        this.prize = prize;
        this.place = place;
    }
}
