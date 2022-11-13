package lotto.domain;

import lotto.domain.Lotto;
import lotto.exception.InvalidInputException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumber {
    private static final String INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE = "잘못된 형식의 입력입니다.";
    private static final String NO_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "중복된 복권번호가 있습니다.";
    private static final String OVER_RANGE_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int LOTTO_LOWER_NUMBER = 1;
    private static final int LOTTO_UPPER_NUMBER = 45;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumber(String winningLotto, String bonusNumber) {
        this.winningLotto = convertStringToWinningLotto(winningLotto);
        this.bonusNumber = convertStringToBonusNumber(bonusNumber);
    }

    private Lotto convertStringToWinningLotto(String input) {
        try {
            return new Lotto(Arrays.stream(input.split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private int convertStringToBonusNumber(String input){
        return validate(input);
    }

    private int validate(String input){
        int number = inputToInt(input);
        validateDuplicatedNumber(number);
        validateNumberRange(number);
        return number;
    }

    private int inputToInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(NO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(int number){
        if(winningLotto.containNumber(number))
            throw new InvalidInputException(DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
    }

    private void validateNumberRange(int number){
        if((number < LOTTO_LOWER_NUMBER) || (number > LOTTO_UPPER_NUMBER))
            throw new InvalidInputException(String.format(OVER_RANGE_NUMBER_EXCEPTION_MESSAGE,
                    LOTTO_LOWER_NUMBER, LOTTO_UPPER_NUMBER));
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
