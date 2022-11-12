package lotto.domain;

import java.util.List;

public class Judgement {
    public int compareNumbers(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (player.contains(computer.get(i))) {
                result++;
            }
        }
        return result;
    }

    public int compareBonus(List<Integer> computer, int number) {
        int bonus = 0;
        if(computer.contains(number)){
            bonus++;
        }
        return bonus;
    }
}
