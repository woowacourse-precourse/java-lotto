package lotto.domain.getwin;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.getwin.domain.Bonus;
import lotto.domain.getwin.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.PrintMessage.ENTER_BONUS;
import static lotto.constant.PrintMessage.ENTER_LOTTO;

public class WinningNumbers {

    public final List<Integer> lotto;
    public final int bonus;

    public WinningNumbers() {
        List<Integer> tmpLotto = getLotto();
        this.lotto = new Lotto(tmpLotto).numbers;
        int tmpBonus = getBonus();
        this.bonus = new Bonus(tmpBonus).bonus;
        validate(lotto, bonus);

    }

    private List<Integer> getLotto() {
        List<Integer> lotto = new ArrayList<>();
        System.out.println(ENTER_LOTTO);
        String numbers = Console.readLine();
        String[] tmp = numbers.split(",");
        for (int i = 0; i < tmp.length; i++) {
            try {
                lotto.add(Integer.parseInt(tmp[i]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
            }
        }
        return lotto;
    }

    private int getBonus() {
        int bonus;
        System.out.println(ENTER_BONUS);
        String bonusNumber = Console.readLine();
        String[] tmp = bonusNumber.split(",");
        if (tmp.length != 1)
            throw new IllegalArgumentException(ERROR_ONLY_ONE_BONUS);
        try {
            bonus = Integer.parseInt(tmp[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        return bonus;
    }

    private void validate(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_NO_DUPLICATE_BETWEEN_LOTTO_AND_BONUS);
        }
    }
}
