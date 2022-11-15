package lotto;

import lotto.messages.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Prize raffle(List<Integer> ticketNumbers, int bonus) {
        validateBonusDuplicate(bonus);

        int count = getContainCount(ticketNumbers);

        return getPrize(count, ticketNumbers.contains(bonus));
    }

    private void validateBonusDuplicate(int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATED);
        }
    }

    private Prize getPrize(int count, boolean isBonusCorrect) {
        switch (count) {
            case 6:
                return Prize.FIRST;
            case 5:
                return bonusPrize(isBonusCorrect);
            case 4:
                return Prize.FOURTH;
            case 3:
                return Prize.FIFTH;
            default:
                return Prize.NOTHING;
        }
    }

    private Prize bonusPrize(boolean isBonusCorrect) {
        if (isBonusCorrect) {
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

    private int getContainCount(List<Integer> ticketNumbers) {
        int count = 0;
        for (int number : ticketNumbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SHOULD_BE_SIX);
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

}
