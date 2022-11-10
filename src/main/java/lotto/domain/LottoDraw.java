package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDraw {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    private Lotto drawWinningNumbers(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (String s : numbers.trim().split(",")) {
            list.add(stringToInteger(s));
        }
        return new Lotto(list);
    }

    private Integer stringToInteger(String s) {
        Integer number = null;
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 각 로또 번호는 숫자이어야 합니다.");
        }
        return number;
    }
}