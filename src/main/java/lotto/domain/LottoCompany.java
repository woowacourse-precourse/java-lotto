package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.Utils.CommonUtil;
import lotto.Utils.Error;
import lotto.Utils.Print;

import java.util.*;

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

        int number = CommonUtil.stringToNumber(input);
        validate(number);
        return number;
    }
    private void validate(int bonus) {
        if (bonus == 0) {
            Error.outOfRange();
        }
        if (bonus < 1 || bonus > 45) {
            Error.outOfRange();
        }
        if (numbers.contains(bonus)) {
            Error.duplicated();
        }
    }
    public void processLotto(Lotto lotto) {
        lotto.drawLotto(numbers, bonus);
    }
}

