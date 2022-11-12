package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.output.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLottoGenerate {
    private final int LOTTO_SIZE = 6;

    private void bonusValidate(String bonus) {
        if (!bonus.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private void winNumberValidate(String[] winNumber) {
        isDigit(winNumber);
    }

    private void isDigit(String[] winNumber) {
        for (String number : winNumber) {
            if (!number.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public WinLotto generate() {
        Output.askWinNumber();
        String[] winNumber = Console.readLine().split(",");
        winNumberValidate(winNumber);
        Output.askBonusNumber();
        String bonus = Console.readLine();
        bonusValidate(bonus);
        List<Integer> numbers = Arrays.stream(winNumber).map(Integer::parseInt).collect(Collectors.toList());
        Integer bonusInteger = Integer.parseInt(bonus);
        return new WinLotto(new Lotto(numbers), bonusInteger);
    }

}
