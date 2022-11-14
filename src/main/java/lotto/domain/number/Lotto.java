package lotto.domain.number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.util.number.LottoNumberConst;
import lotto.util.number.LottoNumberFactory;
import lotto.mvc.util.LottoRanking;

public class Lotto {

    private static final String NUMBER_INPUT_SEPARATOR = ",";
    private static final String LOTTO_PRINT_SEPARATOR = ", ";
    private static final String LOTTO_TO_STRING_FORMAT = "[%s]";

    private static final int MIN_INPUT_NUMBER_LENGTH = 11;
    private static final int MAX_INPUT_NUMBER_LENGTH = 17;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> inputNumbers) {
        List<LottoNumber> lottoNumbers = inputNumbers.stream()
                .map(LottoNumberFactory::numberOf)
                .distinct()
                .collect(Collectors.toList());

        validateLottoNumbers(lottoNumbers);

        this.numbers = lottoNumbers;
    }

    public Lotto(String winningNumbers) {
        validateWinningNumbers(winningNumbers);

        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumbers.split(NUMBER_INPUT_SEPARATOR))
                .distinct()
                .map(LottoNumberFactory::numberOf)
                .collect(Collectors.toList());

        validateLottoNumbers(lottoNumbers);

        this.numbers = lottoNumbers;
    }

    private void validateWinningNumbers(String winningNumbers) {
        validateWinningNumbersLength(winningNumbers);
        validateWinningNumbersSeparator(winningNumbers);
    }

    private void validateWinningNumbersLength(String winningNumbers) {
        int inputLength = winningNumbers.length();

        if (!isValidNumberLength(inputLength)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_LENGTH.findExceptionMessage(inputLength));
        }
    }

    private boolean isValidNumberLength(int inputLength) {
        return MIN_INPUT_NUMBER_LENGTH <= inputLength && inputLength <= MAX_INPUT_NUMBER_LENGTH;
    }

    private void validateWinningNumbersSeparator(String winningNumbers) {
        if (!winningNumbers.contains(NUMBER_INPUT_SEPARATOR)) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_SEPARATOR.findExceptionMessage(winningNumbers));
        }
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        int validNumberSize = numbers.size();

        if (validNumberSize != LottoNumberConst.NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    LottoExceptionMessageUtils.INVALID_NUMBER_SIZE.findExceptionMessage(validNumberSize));
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
