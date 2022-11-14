package lotto.generate;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
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
    private Lotto askWinNumber() {
        askWinNumberPrint();
        String winNumberInput = Console.readLine();
        String[] winNumber = winNumberInput.split(",");
        List<Integer> numbers = Arrays.stream(winNumber).map(Integer::parseInt).collect(Collectors.toList());
        return new Lotto(numbers);
    }

}
