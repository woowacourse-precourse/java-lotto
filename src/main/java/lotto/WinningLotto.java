package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Validate.*;

public class WinningLotto {
    private Lotto number;
    private Integer bonusNumber;

    public WinningLotto(String winningInput, String bonusInput) {
        findOnlyNumber(winningInput, bonusInput);
        Lotto winningNumber = number(winningInput);
        Integer bonusNumber = isInteger(bonusInput);
        bonusNumberBelongsNumber(winningNumber,bonusNumber);
        inRangeLottoNumber(bonusNumber);
        this.number = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto number(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] split = input.split(",");
        for (String splitNumber : split) {
            int number = Integer.parseInt(splitNumber);
            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getNumber() {
        return number;
    }
}
