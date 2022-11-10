package lotto.domain;

import java.util.List;

public class Referee {

    public static void compareLotto(List<Integer> computer, List<Integer> player) {
        int correctCount = Judgment.getCorrectCount(computer, player);
    }

    public static boolean compareBonusNumber(int computer, int player) {
        return computer == player;
    }

}
