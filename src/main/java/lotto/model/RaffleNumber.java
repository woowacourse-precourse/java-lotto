package lotto.model;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaffleNumber {
    private final List<Integer> raffleNumbers;
    private static final String NUMERIC_PATTERN = "[\\d+,]";
    private static final String BLANK = "";
    private static final String DELIMITER=",";
    private static final String ENTER_WRONG_LETTERS_MESSAGE = "[ERROR] 금액을 잘못 입력하셨습니다. 프로그램을 종료합니다.";
    private static final int PROPER_QUANTITY=6;
    private static final String WRONG_QUANTITY_ERROR_MESSAGE="[ERROR] 추첨 번호가 6개가 아닙니다. 프로그램을 종료합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE="[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";
    public RaffleNumber(List<Integer> raffleNumbers) {
        validateProperQuantity(raffleNumbers);
        validateDuplicatedNumbers(raffleNumbers);
        this.raffleNumbers = raffleNumbers;
    }
    private void validateProperQuantity(List<Integer> raffleNumbers) {
        if (raffleNumbers.size() != PROPER_QUANTITY) {
            throw new IllegalArgumentException(WRONG_QUANTITY_ERROR_MESSAGE);
        }
    }
    private void validateDuplicatedNumbers(List<Integer> numbers) {
        int numberOfUniqueNumbers;
        Stream<Integer> lottoNumbers = numbers.stream();
        numberOfUniqueNumbers= (int)lottoNumbers.distinct().count();
        if (numberOfUniqueNumbers != PROPER_QUANTITY) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
    private void validateProperRaffleNumber(String givenNumber) {
        String numberRemovedLetters=givenNumber.replaceAll(NUMERIC_PATTERN, BLANK);
        if (!numberRemovedLetters.equals(BLANK)) {
            throw new IllegalArgumentException(ENTER_WRONG_LETTERS_MESSAGE);
        }
    }fear(RaffleNumber.java): 숫자 다음 콤마 순으로 입력되었는지 확인하는 기능 구현

}