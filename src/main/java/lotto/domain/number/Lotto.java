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
        validateBonusNumber(playerLotto, bonusNumber);

        long numberOfWins = this.numbers
                .stream()
                .filter(playerLotto.numbers::contains)
                .count();

        return LottoRanking.findLottoRanking(numberOfWins, numbers.contains(bonusNumber));
    }

    private void validateBonusNumber(Lotto playerLotto, LottoNumber bonusNumber) {
        if (playerLotto.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessageUtil.WRONG_BONUS_NUMBER.findFullMessage());
        }
    }

    public String getSortedLottoNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted(Comparator.naturalOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_MESSAGE_SEPARATOR));
    }
}
