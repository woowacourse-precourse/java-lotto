package lotto.Model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final String BONUS_NUMBER_DUPLICATION_ERROR_SENTENCE = " 보너스 번호는 당첨번호와 중복 되지 않습니다.";
    private static final String RANGE_ERROR_SENTENCE = " 로또 번호는 1부터 45사이의 숫자여야 합니다.";
    private static final String LENGTH_ERROR_SENTENCE = " 숫자의 길이는 6자리로 제한 됩니다.";
    private static final String DUPLICATION_ERROR_SENTENCE = " 로또 번호는 겹치면 안됩니다.";
    private static final String CHAR_EXCEPTION_SENTENCE = " 입력에 문자열이 포함되었습니다.";
    private static final String BONUS_WITH_CHAR_EXCEPTION = " 숫자만 입력 해야 합니다.";
    private static final String NEGATIVE_BONUS_ERROR = " 양수만 입력 가능합니다.";

    private static List<Integer> winningNumbers;
    private static int bonusNumber;

    public Lotto(List<Integer> numbers) {
        checkValidation(numbers);
        winningNumbers = numbers;
    }

    public static void checkValidation(List<Integer> numbers) {
        checkRange(numbers);
        checkLength(numbers);
        checkDuplicate(numbers);
    }

    private static void checkRange(List<Integer> numbers) {
        for(int each : numbers) {
            if(each < MIN_NUMBER || each > MAX_NUMBER) throw new IllegalArgumentException(ERROR_MESSAGE + RANGE_ERROR_SENTENCE);
        }
    }

    private static void checkLength(List<Integer> numbers) {
        if(numbers.size() != 6) throw new IllegalArgumentException(ERROR_MESSAGE + LENGTH_ERROR_SENTENCE);
    }

    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != numbers.size())
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATION_ERROR_SENTENCE);
    }

    public static List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public static int getBonusNumber() {
        return bonusNumber;
    }

    public static void setBonusNumber(int bonusNumber) {
        checkDuplicateBonusNumber(bonusNumber);
        checkNegativeBonus(bonusNumber);
        Lotto.bonusNumber = bonusNumber;
    }

    private static void checkDuplicateBonusNumber(int bonusNumber) {
        if(winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_ERROR_SENTENCE);
    }

    private static void checkNegativeBonus(int bonusNumber) {
        if(bonusNumber < 0)
            throw new IllegalArgumentException(NEGATIVE_BONUS_ERROR);
    }

    public static List<Integer> stringToList(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(","));
        return convertTypeStringToInteger(numbers);
    }

    private static List<Integer> convertTypeStringToInteger(List<String> numbers) {
        try{
            return numbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHAR_EXCEPTION_SENTENCE);
        }
    }

    public static int stringToInt(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_WITH_CHAR_EXCEPTION);
        }
    }

}
