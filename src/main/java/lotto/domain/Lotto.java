package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.util.number.LottoNumberConst;
import lotto.util.number.LottoNumberFactory;
import lotto.util.ranking.LottoRanking;

public class Lotto {

    private static final String NUMBER_INPUT_SEPARATOR = ",";
    private static final String LOTTO_PRINT_SEPARATOR = ", ";
    private static final String LOTTO_TO_STRING_FORMAT = "[%s]";

    private static final int MIN_INPUT_NUMBER_LENGTH = 11;
    private static final int MAX_INPUT_NUMBER_LENGTH = 17;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> inputNumbers) {
        List<LottoNumber> numbers = inputNumbers.stream()
                .map(LottoNumberFactory::numberOf)
                .distinct()
                .collect(Collectors.toList());

        validateLottoNumbers(numbers);

        this.numbers = numbers;
    }

    public Lotto(String winningNumbers) {
        validateWinningNumbers(winningNumbers);

        List<LottoNumber> numbers = Arrays.stream(winningNumbers.split(NUMBER_INPUT_SEPARATOR))
                .map(Integer::parseInt)
                .distinct()
                .map(LottoNumberFactory::numberOf)
                .collect(Collectors.toList());

        validateLottoNumbers(numbers);

        this.numbers = numbers;
    }

    private void validateWinningNumbers(String winningNumbers) {
        validateWinningNumbersLength(winningNumbers);
        validateWinningNumbersSeparator(winningNumbers);
        validateInputNumbers(winningNumbers);
    }

    private void validateWinningNumbersLength(String winningNumbers) {
        int inputLength = winningNumbers.length();

        if (!(MIN_INPUT_NUMBER_LENGTH <= inputLength && inputLength <= MAX_INPUT_NUMBER_LENGTH)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_LENGTH.findExceptionMessage(inputLength));
        }
    }

    private void validateWinningNumbersSeparator(String winningNumbers) {
        if (!winningNumbers.contains(NUMBER_INPUT_SEPARATOR)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_SEPARATOR.findExceptionMessage(winningNumbers));
        }
    }

    private void validateInputNumbers(String winningNumbers) {
        Arrays.stream(winningNumbers.split(NUMBER_INPUT_SEPARATOR))
                .filter(winningNumber -> !isCorrectNumber(winningNumber))
                .findAny()
                .ifPresent(input -> {
                    throw new IllegalArgumentException(
                            LottoExceptionMessageUtils.INVALID_NUMBER_RANGE.findExceptionMessage(winningNumbers));
                });
    }

    private boolean isCorrectNumber(String playerInputNumber) {
        int playerNumber = castInputNumber(playerInputNumber);

        return (LottoNumberConst.MIN_NUMBER_INT_VALUE <= playerNumber
                && playerNumber <= LottoNumberConst.MAX_NUMBER_INT_VALUE);
    }

    private int castInputNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_FORMAT.findExceptionMessage(inputNumber));
        }
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        int validNumberSize = numbers.size();

        if (validNumberSize != LottoNumberConst.NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_SIZE.findExceptionMessage(validNumberSize)
            );
        }
    }

    public LottoRanking calculateLottoGrade(Lotto playerLotto, LottoNumber bonusNumber) {
        long numberOfWins = this.numbers
                .stream()
                .filter(playerLotto.numbers::contains)
                .count();

        return LottoRanking.findLottoRanking(numberOfWins, numbers.contains(bonusNumber));
    }

    @Override
    public String toString() {
        String lottoPrintMessage = numbers.stream()
                .map(LottoNumber::toString)
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .collect(Collectors.joining(LOTTO_PRINT_SEPARATOR));

        return String.format(LOTTO_TO_STRING_FORMAT, lottoPrintMessage);
    }
}
