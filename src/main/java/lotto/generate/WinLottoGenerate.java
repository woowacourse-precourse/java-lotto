package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;
import lotto.enums.StringEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.enums.StringEnum.*;

public class WinLottoGenerate {
    public void askWinNumberPrint() {
        System.out.println(WIN_NUMBER.getMessage());
    }

    public void askBonusNumberPrint() {
        System.out.println(StringEnum.BONUS_NUMBER.getMessage());
    }

    private List<Integer> askWinNumber() {
        askWinNumberPrint();
        String winNumberInput = Console.readLine();
        winNumberValidate(winNumberInput);
        String[] winNumber = winNumberInput.split(",");
        List<Integer> numbers = Arrays.stream(winNumber).map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }

    public void winNumberValidate(String winNumber) {
        String inputValidate = winNumber.replaceAll("[0-9,]", "");
        if (inputValidate.length() > 0) {
            throw new IllegalArgumentException("[ERROR] 입력값이 유효하지 않습니다.");
        }
    }

    private Integer askBonus() {
        askBonusNumberPrint();
        String bonus = Console.readLine();
        bonusValidate(bonus);
        return Integer.parseInt(bonus);
    }

    public void bonusValidate(String bonus) {
        if (!bonus.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    public WinLotto generate() {
        List<Integer> winNumber = askWinNumber();
        Integer bonusInteger = askBonus();
        return new WinLotto(winNumber, bonusInteger);
    }

}
