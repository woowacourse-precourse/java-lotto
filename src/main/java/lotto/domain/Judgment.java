package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Judgment {
    private static final String NEGATIVE_INTEGER_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 양의 정수여야 합니다.";
    private static final String FAILED_TO_DIVIDE_BY_1000_ERROR_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";
    private static final String NO_5_COMMAS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 , 다섯 개로 구성되어야 합니다.";
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "[ERROR] 유효한 숫자 범위를 벗어났습니다.";
    private static final String NO_6_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호는 숫자 여섯 개로 구성되어야 합니다.";
    private static final String DUPLICATE_NUMBERS_ERROR_MESSAGE = "[ERROR] 당첨 번호가 중복됩니다.";
    private static final String FAILED_TO_CHANGE_TO_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호는 숫자들로 구성되어야 합니다.";
    
    public int countLottos(int money) {
        
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_INTEGER_ERROR_MESSAGE);
        }
        
        if (((money % 1000) != 0) || (money < 1000)) {
            throw new IllegalArgumentException(FAILED_TO_DIVIDE_BY_1000_ERROR_MESSAGE);
        }
        
        return money/1000;
    }
    
    public void check5Commas(String input) {
        int commaCount = 0;
        
        for (int index = 0; index < input.length(); index++) {
            if (',' == input.charAt(index)) {
                commaCount++;
            }
        }

        if (commaCount != 5) {
            throw new IllegalArgumentException(NO_5_COMMAS_ERROR_MESSAGE);
        }
    }

    public void checkRange(int number, int fromNumber, int toNumber) {
        if (number < fromNumber) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }

        if (toNumber < number) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }

    public void checkSize(List<Integer> numbers, int size) {
        if (numbers.size() != size) {
            throw new IllegalArgumentException(NO_6_NUMBERS_ERROR_MESSAGE);
        }
    }

    public void checkNumbersRange(List<Integer> numbers, int fromNumber, int toNumber) {
        for (Integer number : numbers) {
            checkRange(number, fromNumber, toNumber);
        }
    }

    public void duplicateCheck(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<Integer>();

        for (Integer number : numbers) {

            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS_ERROR_MESSAGE);
            }

            uniqueNumbers.add(number);
        }
    }
    
    public List<Integer> changeToInteger(List<String> input) {
        try {
            List<Integer> results = new ArrayList<>();
            
            for (String item : input) {
                Integer result = Integer.parseInt(item);
                results.add(result);
            }
            
            return results;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(FAILED_TO_CHANGE_TO_NUMBER_ERROR_MESSAGE);
        }

    }
    
    public int correctCount(List<Integer> winningNumbers, List<Integer> buyerNumbers) {
        int result = 0;
        
        for (int index = 0; index < buyerNumbers.size(); index++) {
            if (winningNumbers.contains(buyerNumbers.get(index))) {
                result++;
            }
        }
        
        return result;
    }
}
