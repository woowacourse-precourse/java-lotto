package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.LottoWinNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoSetting.LOTTO_NUMBER_COUNT;
import static lotto.exception.ViewExceptionMessage.*;
import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.CharacterUnits.NO_SPACE;
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
        String inputWinNumbers = Console.readLine();
        validateComma(inputWinNumbers);
        validateWinNumberCount(inputWinNumbers);
        Set<Integer> winNumbers = getWinNumbers(inputWinNumbers);
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

    private void validateComma(String winNumbers) {
        String[] splitedInput = winNumbers.split(NO_SPACE.getUnit());
        int commaCount = (int) Arrays.stream(splitedInput)
                .filter(inputString -> inputString.equals(COMMA.getUnit()))
                .count();
        if (commaCount != LOTTO_NUMBER_COUNT.getSetting() - 1) {
            throw new IllegalArgumentException(INPUT_WIN_NUMBER_COMMA.getMessage());
        }
    }

    private void validateWinNumberCount(String winNumbers) {
        int winNumberCount = winNumbers.split(COMMA.getUnit()).length;
        if (winNumberCount != LOTTO_NUMBER_COUNT.getSetting()) {
            throw new IllegalArgumentException(INPUT_WIN_NUMBER_COUNT.getMessage());
        }
    }
}
