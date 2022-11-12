package lotto;

public class Score implements Comparable<Score> {
    private final int winningNumberCount;
    private final int bonusNumberCount;

    public Score(int winningNumberCount, int bonusNumberCount) {
        this.winningNumberCount = winningNumberCount;
        this.bonusNumberCount = bonusNumberCount;
    }

    @Override
    public int compareTo(Score score) {
        return 0;
    }
}
