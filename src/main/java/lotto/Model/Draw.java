package lotto.Model;

import lotto.Model.enums.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Draw {
    private final List<Integer> winning;
    private final int bonus;
    private final List<List<Integer>> lottoes;

    public Draw(List<Integer> winning, int bonus, List<List<Integer>> lottoes) {
        this.winning = winning;
        this.bonus = bonus;
        this.lottoes = lottoes;
        compare();
    }

    void compare() {
        for (List<Integer> lotto : lottoes) {
            int count = (int) lotto.stream()
                    .filter(old -> winning.stream().anyMatch(Predicate.isEqual(old))).count();
            int bonusCount = 0;
            if (lotto.contains(bonus)) bonusCount = 1;

            if(Prize.findNameByValue(count, bonusCount) != null){
                Prize.findNameByValue(count, bonusCount).increaseCount();
            }
        }
    }
}
