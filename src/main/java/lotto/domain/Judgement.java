package lotto.domain;

import java.util.List;

public class Judgement {
    public int correctNumbers(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (player.contains(computer.get(i))) {
                result++;
            }
        }
        return result;
    }

    public boolean correctBonus(List<Integer> computer, int number) {
        if (computer.contains(number)) {
            return true;
        }
        return false;
    }
}
