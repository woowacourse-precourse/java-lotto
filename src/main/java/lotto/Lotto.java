package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Verify.verifyDupNumber(this.numbers);
        Verify.verifyLottoLength(this.numbers);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : numbers) {
            sb.append(number).append(", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");

        return sb.toString();
    }

    public int checkWin(boolean[] goal, int bonusNumber) {
        int numMatch = checkGoal(goal);
        boolean checkBonus = checkBonus(bonusNumber);

        return checkRank(numMatch, checkBonus);
    }

    private int checkGoal(boolean[] goal) {
        int numMatch = 0;
        for (Integer number : numbers) {
            if (goal[number]) {
                numMatch += 1;
            }
        }
        return numMatch;
    }

    private boolean checkBonus(int bonusNumber) {
        for (Integer number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    private int checkRank(int numMatch, boolean checkBonus) {
        int result = 0;
        for (Rank rank : Rank.values()) {
            if (numMatch == rank.getMatch()) {
                result = rank.getRanking();
                break;
            }
        }

        if (checkBonus && result == 1) {
            result = Rank.RANK2.getRanking();
        }
        return result;
    }
}
