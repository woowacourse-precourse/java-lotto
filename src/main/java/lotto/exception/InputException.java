package lotto.exception;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.exception.ErrorMessage.*;

public class InputException extends IllegalArgumentException {

    private static final int NUMBERS_SIZE = 6;

    /**
     * 입력받은 문자열이 숫자가 아니면 예외를 던짐
     *
     * @param inputString 입력받은 문자열
     */
    public void notDigitException(String inputString) {
        if (inputString.chars().allMatch(Character::isDigit)) {
            return;
        }
        throw new IllegalArgumentException(NOT_DIGIT.getMessage());
    }

    /**
     * 금액이 1,000단위가 아니면 예외를 던짐
     *
     * @param money 금액
     */
    public void notThousandMoneys(int money) {
        if (money % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException(NOT_THOUSAND_MONEY.getMessage());
    }

    /**
     * 잘못된 로또 번호 형식으로 입력하면 예외를 던짐
     *
     * @param inputNumbers 입력한 로또 번호
     */
    public void invalidNumbers(String inputNumbers) {
        int count = 0;
        Pattern pattern = Pattern.compile("(\\d{1,2})(,+)?");
        Matcher matcher = pattern.matcher(inputNumbers);
        while (matcher.find()) {
            count++;
            if (count == NUMBERS_SIZE && matcher.find()) {
                throw new IllegalArgumentException(INVALID_NUMBERS_INPUT.getMessage());
            } else if (count == NUMBERS_SIZE) {
                break;
            }
            if (matcher.group(2) == null) {
                throw new IllegalArgumentException(INVALID_NUMBERS_INPUT.getMessage());
            }
        }
    }

    /**
     * 로또 번호중 중복 숫자가 존재하면 예외를 던짐
     *
     * @param numbers 로또 번호
     */
    public void duplicateNumberException(List<Integer> numbers) {
        boolean[] checkNumbers = new boolean[46];
        for (Integer number : numbers) {
            if (checkNumbers[number]) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
            }
            checkNumbers[number] = true;
        }
    }

    /**
     * 보너스 번호가 중복되면 예뢰를 던짐
     *
     * @param numbers     로또 번호
     * @param bonusNumber 보너스 번호
     */
    public void duplicateBonusNumberException(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    /**
     * 로또 숫자가 1부터 45의 범위를 벗어나면 예외를 던짐
     *
     * @param numbers 로또 숫자
     */
    public void numbersRangeException(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (1 > number || number > 45) {
                throw new IllegalArgumentException(NOT_RANGE.getMessage());
            }
        }
    }
}
