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
    public RaffleNumber(String raffleNumbers) {
        validateProperRaffleNumber(raffleNumbers);
        List<String> separatedRaffleNumber = separateRaffleNumberByComma(raffleNumbers);
        validateProperQuantity(separatedRaffleNumber);
        validateDuplicatedNumbers(separatedRaffleNumber);
        this.raffleNumbers = transform(separatedRaffleNumber, Integer::parseInt);
    }
    private void validateProperQuantity(List<String> raffleNumbers) {
        if (raffleNumbers.size() != PROPER_QUANTITY) {
            throw new IllegalArgumentException(WRONG_QUANTITY_ERROR_MESSAGE);
        }
    }
    private void validateDuplicatedNumbers(List<String> numbers) {
        int numberOfUniqueNumbers;
        Stream<String> lottoNumbers = numbers.stream();
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
    }
    public List<String> separateRaffleNumberByComma(String raffleNumber){
        return List.of(raffleNumber.split(DELIMITER));
    }
    private <T, U> List<U> transform(List<T> list, Function<T, U> function){
        return list.stream().map(function).collect(Collectors.toList());
    }
}