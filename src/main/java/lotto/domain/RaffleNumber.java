package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RaffleNumber {
    private static final String NUMERIC_PATTERN = "[\\d+,]";
    private static final String NUMERIC = "\\d+";
    private static final String BLANK = "";
    private static final String DELIMITER = ",";
    private static final String ENTER_WRONG_LETTERS_MESSAGE = "[ERROR] 금액을 잘못 입력하셨습니다. 프로그램을 종료합니다.";
    private static final int PROPER_QUANTITY = 6;
    private static final String WRONG_QUANTITY_ERROR_MESSAGE = "[ERROR] 추첨 번호가 6개가 아닙니다. 프로그램을 종료합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 숫자가 중복되었습니다. 프로그램을 종료합니다.";
    private List<Integer> raffleNumbers = new ArrayList<>();
    private int bonusNumber;

    public RaffleNumber() {
        this.bonusNumber = 0;
    }

    public void createRaffleNumber(String raffleNumber) {
        validateProperRaffleNumber(raffleNumber, NUMERIC_PATTERN);
        List<String> separatedRaffleNumber = separateRaffleNumberByComma(raffleNumber);
        validateProperQuantity(separatedRaffleNumber);
        validateDuplicatedNumbers(separatedRaffleNumber);
        this.raffleNumbers = transform(separatedRaffleNumber, Integer::parseInt);
    }

    public void createBonusNumber(String bonusNumber) {
        validateProperRaffleNumber(bonusNumber, NUMERIC);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public void create(String raffleNumber, String bonusNumber) {
        createRaffleNumber(raffleNumber);
        createBonusNumber(bonusNumber);
    }

    public List<Integer> getRaffleNumbers() {
        return raffleNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateProperQuantity(List<String> raffleNumbers) {
        if (raffleNumbers.size() != PROPER_QUANTITY) {
            System.out.println(WRONG_QUANTITY_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<String> numbers) {
        int numberOfUniqueNumbers;
        Stream<String> lottoNumbers = numbers.stream();
        numberOfUniqueNumbers = (int) lottoNumbers.distinct().count();
        if (numberOfUniqueNumbers != PROPER_QUANTITY) {
            System.out.println(DUPLICATE_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public List<String> separateRaffleNumberByComma(String raffleNumber) {
        return List.of(raffleNumber.split(DELIMITER));
    }

    private <T, U> List<U> transform(List<T> list, Function<T, U> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    private void validateProperRaffleNumber(String givenNumber, String pattern) {
        String numberRemovedLetters = givenNumber.replaceAll(pattern, BLANK);
        if (!numberRemovedLetters.equals(BLANK)) {
            System.out.println(ENTER_WRONG_LETTERS_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

}