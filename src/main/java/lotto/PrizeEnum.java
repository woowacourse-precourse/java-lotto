package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public enum PrizeEnum {
    fifthWinner_3(5000, 3, false, MESSAGE_RESULT_OF_RANK_5),
    fourthWinner_4(50000, 4, false, MESSAGE_RESULT_OF_RANK_4),
    thirdWinner_5(1500000, 5, false, MESSAGE_RESULT_OF_RANK_3),
    secondWinner_5_bonus(30000000, 5, true, MESSAGE_RESULT_OF_RANK_2),
    firstWinner_6(2000000000, 6, false, MESSAGE_RESULT_OF_RANK_1);

    private int prize;
    private int correctNumber;
    private boolean bonusCorrect;
    private String message;
    private int count;
    private List<Integer> ans = new ArrayList<>(List.of(2, 3, 3, 0, 4));

    PrizeEnum(int prize, int correctNumber, boolean bonusCorrect, String message) {
        this.prize = prize;
        this.correctNumber = correctNumber;
        this.bonusCorrect = bonusCorrect;
        this.message = message;
    }

    public void plusRankCount(List<Integer> ans) {
        for (int i = 0; i < ans.size(); i++) {
            if (this.correctNumber == ans.get(i) && NumberChecker.checkBonus() == this.bonusCorrect) {
                this.count++;
            }
        }
    }

    public int getPrize() {
        return this.prize;
    }

    public int getCount() {
        return this.count;
    }

    public String getMessage() {
        return this.message;
    }
}
