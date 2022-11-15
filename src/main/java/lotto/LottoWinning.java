package lotto;

import java.util.List;

public class LottoWinning {

    private final List<Integer> numbers;
    private final Integer bonus;

    public LottoWinning(List<Integer> lotto, Integer bonus, List<List<Integer>> winning, Integer money) {
        this.numbers = lotto;
        this.bonus = bonus;
        if (numbers.contains(bonus))
            throw new IllegalArgumentException("보너스 번호와 당첨 번호는 일치할 수 없습니다.");
    }
}