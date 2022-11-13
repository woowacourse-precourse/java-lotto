package lotto;

import java.util.List;
import java.util.Objects;

public class Judgement {
    int matchWinning(List<Integer> winning, List<Integer> user) {
        int result = 0;
        for (int i = 0; i < winning.size(); i++) {
            if (Objects.equals(winning.get(i), user.get(i))) {
                result++;
            }
        }
        return result;
    }

    boolean matchBonus(int bonus, List<Integer> user) {
        return user.contains(bonus);
    }
}
