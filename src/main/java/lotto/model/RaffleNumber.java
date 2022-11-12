package lotto.model;

import java.util.List;
import java.util.stream.Stream;

public class RaffleNumber {
    private final List<Integer> raffleNumbers;
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
}
