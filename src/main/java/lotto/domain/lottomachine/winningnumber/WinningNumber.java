package lotto.domain.lottomachine.winningnumber;

import lotto.domain.lottomachine.lottoticket.LottoTicketSystem;
import lotto.domain.lottomachine.lottoticket.LottoTickets;

import java.util.List;
import java.util.Objects;

import static lotto.domain.lottomachine.messages.DomainErrorMessage.WINNING_NUMBER_RANGE;

public class WinningNumber {
    private final static String BONUS_COUNT = "B";
    private final static String NON_BONUS_COUNT = "";
    private final int number;

    private WinningNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static WinningNumber from(int number) {
        return new WinningNumber(number);
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(WINNING_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int number) {
        return number < LottoTicketSystem.START || number > LottoTicketSystem.END;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public boolean isSameValue(int number) {
        return this.number == number;
    }

    public String checkSameValue(List<Integer> numbers) {
        if (numbers.contains(number)) {
            return BONUS_COUNT;
        }
        return NON_BONUS_COUNT;
    }
}
