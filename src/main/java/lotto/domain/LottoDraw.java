package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDraw {
    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public LottoDraw(String numbers, String number) {
        winningNumbers = drawWinningNumbers(numbers);
        bonusNumber = stringToInteger(number);
        validateBonusNumber();
    }

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

    private void validateBonusNumber() {
        if (winningNumbers.get().contains(bonusNumber)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}