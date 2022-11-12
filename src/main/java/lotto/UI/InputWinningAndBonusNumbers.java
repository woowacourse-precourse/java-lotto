package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class InputWinningAndBonusNumbers {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public void inputWinningNumbers() {
        winningNumbers = drawWinningNumbers(Console.readLine());

    }

    public void inputBonusNumber() {
        bonusNumber = stringToInteger(Console.readLine());
    }

    private Integer stringToInteger(String s) {
        Integer number = null;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 각 로또 번호는 숫자이어야 합니다.");
        }
        return number;
    }

    private void validateBonusNumber() {
        if (winningNumbers.get().contains(bonusNumber)) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[Error] 보너스 번호는 1~45 사이의 숫자입니다.");
        }
    }

    private Lotto drawWinningNumbers(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (String s : numbers.trim().split(",")) {
            list.add(stringToInteger(s));
        }
        return new Lotto(list);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
