package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Return {

    FIFTH(5000,0),
    FOURTH(50000, 1),
    THIRD(1500000, 2),
    SECOND(30000000, 4),
    FIRST(2000000000, 3);

    private final int winningAmount;
    private final int gradeCountIndexNum;

    Return(int winningAmount, int gradeCountIndexNum) {
        this.winningAmount = winningAmount;
        this.gradeCountIndexNum = gradeCountIndexNum;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getGradeCountIndexNum() {
        return gradeCountIndexNum;
    }
}
