package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Utils.CommonUtil;
import lotto.Utils.Error;
import lotto.Utils.Print;

import java.util.*;
import java.util.stream.Collectors;

public class LottoCompany {
    private final List<Integer> numbers;
    private int bonus;

    public LottoCompany() {
        numbers = inputNumbers();
        bonus = inputBonus();
    }

    private List<Integer> inputNumbers() {
        Print.askWinningNumber();
        String input = Console.readLine();

        return CommonUtil.stringToNumbers(input);
    }

    private int inputBonus() {
        Print.askBonusNumber();
        String input = Console.readLine();

        return CommonUtil.stringToNumber(input);
    }
    private void validate(int bonusNumber) {
        Error error = new Error();
        if (bonusNumber == 0) {
            error.outOfRange();
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            error.outOfRange();
        }
        if (this.numbers.contains(bonusNumber)) {
            error.duplicated();
        }
    }
    public void processLotto(Lotto lotto) {
        lotto.drawLotto(numbers, bonus);
    }
}

