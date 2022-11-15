package lotto;

import java.util.List;

public class WinningNumber extends Lotto {
    final static String INFORMATION_ERROR_TYPE_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final Integer bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);

        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int compareLotteryNumber(Lotto lotteryTicket) {
        int count = super.compare(lotteryTicket);

        return count;
    }

    public boolean compareBonusNumber(Lotto lotteryTicket) {
        return lotteryTicket.contain(this.bonusNumber);
    }

    private void validate(List<Integer> numbers, Integer number) {
        boolean validateNumber = numbers.contains(number);
        validateNumber = ( 1 > number ) || validateNumber;
        validateNumber = ( 45 < number ) || validateNumber;

        if ( validateNumber ) {
            throw new IllegalArgumentException(INFORMATION_ERROR_TYPE_NUMBER);
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INFORMATION_ERROR_INPUT_SIZE);
        }
    }
}
