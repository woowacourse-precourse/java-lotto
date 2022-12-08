package util;

import java.util.stream.Stream;

public class WinningNumberValidator {

    private static final String ERROR_DIVIDE = "[ERROR] ','로 당첨 번호를 구분해서 입력해야 합니다.";
    private static final String ERROR_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_TYPE = "[ERROR] 당첨 번호는 숫자만 입력해야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 당첨 번호는 1~45 사이의 숫자를 입력해야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 중복되지 않은 숫자를 입력해야 합니다.";
    private static final String DIVIDE = ",";
    private static final String BLANK = "";

    private static final int LENGTH = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    String winningNumbers;

    public WinningNumberValidator(String winningNumbers) {
        this.winningNumbers = winningNumbers;
        validate();
    }

    private void validate() {
        validateDivide();
        validateNumbersCount();
        validateType();
        validateRange();
        validateDuplicate();
    }

    private void validateDuplicate() {
        String [] numbers = winningNumbers.split(DIVIDE);
        long distinctCount = Stream.of(numbers).distinct().count();
        if (numbers.length != distinctCount) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }

    private void validateRange() {
        String[] tmpArray = winningNumbers.split(DIVIDE);
        for(int i=0;i< tmpArray.length;i++){
            validateEachNumbersRange(tmpArray, i);
        }
    }

    private void validateEachNumbersRange(String[] tmpArray, int i) {
        if(Integer.parseInt(tmpArray[i])< MIN_NUM ||Integer.parseInt(tmpArray[i])> MAX_NUM){
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private void validateType() {
        try{
            Integer.parseInt(winningNumbers.replace(DIVIDE, BLANK));
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    private void validateNumbersCount() {
        String[] tmpArray = winningNumbers.split(DIVIDE);
        if (tmpArray.length != LENGTH) {
            throw new IllegalArgumentException(ERROR_COUNT);
        }
    }

    private void validateDivide() {
        if (!winningNumbers.contains(DIVIDE)) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }
}
