package lotto;

import static lotto.Config.LOTTO_LENGTH;

public class Score implements Comparable<Score> {
    public final int winningNumberCount;
    public final int bonusNumberCount;

    public Score(int winningNumberCount, int bonusNumberCount) {
        this.winningNumberCount = winningNumberCount;
        this.bonusNumberCount = bonusNumberCount;
    }

    @Override
    public int compareTo(Score score) {
        if(this.winningNumberCount != score.winningNumberCount){
            return this.winningNumberCount - score.winningNumberCount;
        }
        if(this.winningNumberCount == LOTTO_LENGTH - 1) {
            return this.bonusNumberCount - score.bonusNumberCount;
        }
        return 0;
    }
}
