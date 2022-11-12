package lotto.model;

import java.util.List;

public class RaffleNumber {
    private final List<Integer> raffleNumbers;
    private static final int PROPER_QUANTITY=6;
    private static final String WRONG_QUANTITY_ERROR_MESSAGE="[ERROR] 추첨 번호가 6개가 아닙니다. 프로그램을 종료합니다.";
    public RaffleNumber(List<Integer> raffleNumbers) {
        validateProperQuantity(raffleNumbers);
        this.raffleNumbers = raffleNumbers;
    }
    private void validateProperQuantity(List<Integer> raffleNumbers) {
        if (raffleNumbers.size() != PROPER_QUANTITY) {
            throw new IllegalArgumentException(WRONG_QUANTITY_ERROR_MESSAGE);
        }
    }
}
