package lotto.domain.number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.game.LottoRanking;
import lotto.utils.consts.LottoConst;
import lotto.utils.message.ExceptionMessageUtil;
import lotto.utils.number.LottoNumberFactory;

public class Lotto {

    private static final String NUMBER_INPUT_SEPARATOR = ",";
    private static final String LOTTO_MESSAGE_SEPARATOR = ", ";

    private static final int MIN_INPUT_NUMBER_LENGTH = 11;
    private static final int MAX_INPUT_NUMBER_LENGTH = 17;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> inputNumbers) {
        List<LottoNumber> lottoNumbers = createPurchaseLottoNumbers(inputNumbers);

        validateLottoNumbers(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public Lotto(String winningNumbers) {
        List<LottoNumber> lottoNumbers = createWinningLottoNumbers(winningNumbers);

        validateLottoNumbers(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private List<LottoNumber> createWinningLottoNumbers(String winningNumbers) {
        validateWinningNumbers(winningNumbers);

        return Arrays.stream(winningNumbers.split(NUMBER_INPUT_SEPARATOR))
                .distinct()
                .map(LottoNumberFactory::numberOf)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> createPurchaseLottoNumbers(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .map(LottoNumberFactory::numberOf)
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String winningNumbers) {
        validateWinningNumbersLength(winningNumbers);
        validateWinningNumbersSeparator(winningNumbers);
    }

    private void validateWinningNumbersLength(String winningNumbers) {
        int inputLength = winningNumbers.length();

        if (!isValidNumberLength(inputLength)) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_NUMBER_LENGTH.findFullMessage());
        }
    }

    private boolean isValidNumberLength(int inputLength) {
        return MIN_INPUT_NUMBER_LENGTH <= inputLength && inputLength <= MAX_INPUT_NUMBER_LENGTH;
    }

    private void validateWinningNumbersSeparator(String winningNumbers) {
        if (!winningNumbers.contains(NUMBER_INPUT_SEPARATOR)) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_SEPARATOR.findFullMessage());
        }
    }

    private void validateLottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LottoConst.NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_NUMBER_SIZE.findFullMessage());
        }
    }

    public LottoRanking calculateLottoRanking(Lotto playerLotto, LottoNumber bonusNumber) {
        long numberOfWins = this.numbers
                .stream()
                .filter(playerLotto.numbers::contains)
                .count();

        return LottoRanking.findLottoRanking(numberOfWins, numbers.contains(bonusNumber));
    }

    public String getSortedLottoNumbers() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .collect(Collectors.joining(LOTTO_MESSAGE_SEPARATOR));
    }
}
