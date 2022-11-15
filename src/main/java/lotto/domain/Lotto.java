package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> lottoNumbers = convertIntegerList(numbers);
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validate(List<Integer> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateLottoNumber(lottoNumbers);
        validateUnique(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateLottoNumber(List<Integer> winningLottoNumbers) {
        Long incorrectNumberCount = winningLottoNumbers.stream()
                .filter(n -> (n < START_VALUE || n > END_VALUE))
                .count();

        if (incorrectNumberCount > 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateUnique(List<Integer> winningLottoNumbers) {
        for (int i = 0; i < 6; i++) {
            if (!(winningLottoNumbers.indexOf(winningLottoNumbers.get(i)) == i)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
            }
        }
    }

    private void validateLottoSize(List<Integer> winningLottoNumbers) {
        if (winningLottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_SIZE.getMessage());
        }
    }

    private List<Integer> convertIntegerList(String numbers) {
        try {
            return Arrays.stream(numbers.split(","))
                    .mapToInt(number -> Integer.parseInt(number))
                    .boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
}