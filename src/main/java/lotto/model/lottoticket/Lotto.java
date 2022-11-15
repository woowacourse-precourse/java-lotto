package lotto.model.lottoticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.exception.InputException;

import lotto.view.ErrorMessages;

public class Lotto {

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int LOTTO_NUMBER_COUNT = 6;
    private final String DELIMITER = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> autoNumbers) {

        validateAutoTicket(autoNumbers);

        List<Integer> lotto = new ArrayList<>(autoNumbers);
        Collections.sort(lotto);

        this.numbers = lotto;
    }

    private void validateAutoTicket(List<Integer> autoNumbers) {
        validateAutoTicketElement(autoNumbers);
        validateAutoTicketDistinct(autoNumbers);
    }

    private void validateAutoTicketElement(List<Integer> autoNumbers) {
        if (autoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAutoTicketDistinct(List<Integer> autoNumbers) {
        long count = autoNumbers.stream()
                .distinct()
                .count();

        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto(String input) {
        String trimmedInput = input.trim();

        validateInputTicket(trimmedInput);

        this.numbers = Arrays.stream(trimmedInput.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateInputTicket(String trimmedInput) {
        try {
            validateInputTicketElement(trimmedInput);
            validateInputTicketDelimiter(trimmedInput);
        } catch (IllegalArgumentException e) {
            throw new InputException(e.getMessage());
        }
    }

    private void validateInputTicketElement(String trimmedInput) {
        long count = Arrays.stream(trimmedInput.split(DELIMITER))
                .map(Integer::parseInt)
                .filter(i -> i >= START_INCLUSIVE)
                .filter(i -> i <= END_INCLUSIVE)
                .distinct()
                .count();

        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.WINNING_NUMBER.getErrorMessage());
        }

    }

    private void validateInputTicketDelimiter(String trimmedInput) {
        long count = trimmedInput.chars()
                .filter(c -> c == ',')
                .count();

        if (count != LOTTO_NUMBER_COUNT - 1) {
            throw new IllegalArgumentException(ErrorMessages.WINNING_DELIMITER.getErrorMessage());
        }
    }

    public boolean hasLottoNumber(final Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int countMatchWith(Lotto winningNumber) {
        long count = numbers.stream()
                .filter(winningNumber::hasLottoNumber)
                .count();

        return (int) count;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
