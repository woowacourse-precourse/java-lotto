package lotto.UI;

import static lotto.CustomException.throwException;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class InputWinningAndBonusNumbers {
    private Lotto winningNumbers;
    private Integer bonusNumber;

    public Lotto inputWinningNumbers() {
        winningNumbers = drawWinningNumbers(Console.readLine());
        return winningNumbers;
    }

    public Integer inputBonusNumber() {
        bonusNumber = stringToInteger(Console.readLine());
        validateBonusNumber();
        return bonusNumber;
    }

    private Integer stringToInteger(String s) throws IllegalArgumentException {
        Integer number = null;
        try {
            number = Integer.parseInt(s);
        } catch (IllegalArgumentException e) {
            System.out.println("[Error] 각 로또 번호는 숫자이어야 합니다.");
            throw e;
        }
        return number;
    }

    private void validateBonusNumber() throws IllegalArgumentException {
        if (winningNumbers.get().contains(bonusNumber)) {
            throwException("[Error] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throwException("[Error] 보너스 번호는 1~45 사이의 숫자입니다.");
        }
    }

    private Lotto drawWinningNumbers(String numbers) {
        List<Integer> list = new ArrayList<>();
        for (String s : numbers.trim().split(",")) {
            list.add(stringToInteger(s));
        }
        return new Lotto(list);
    }
}
