package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.LottoWinNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.exception.ViewExceptionMessage.INPUT_DIGIT_EXCEPTION;
import static lotto.util.CharacterUnits.COMMA;
import static lotto.view.InputViewMessage.*;

public class InputView {
    public Cash inputCash() {
        System.out.print(INPUT_CASH_MESSAGE.getMessage());
        String cash = Console.readLine();
        validateDigit(cash);
        return new Cash(Integer.parseInt(cash));
    }

    public LottoWinNumber inputWinNumber() {
        System.out.println(INPUT_LOTTO_WIN_NUMBER.getMessage());
        Set<Integer> winNumbers = getWinNumbers(Console.readLine());
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        validateDigit(bonusNumber);
        return new LottoWinNumber(winNumbers, Integer.parseInt(bonusNumber));
    }

    private static Set<Integer> getWinNumbers(String winNumbers) {
        return Arrays.stream(winNumbers.split(COMMA.getUnit()))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());
    }

    private void validateDigit(String cash) {
        if (!cash.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INPUT_DIGIT_EXCEPTION.getMessage());
        }
    }
}
