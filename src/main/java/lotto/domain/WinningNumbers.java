package lotto.domain;

import lotto.utils.Constant;
import lotto.utils.ExceptionMessages;
import lotto.utils.LottoNumberRange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final String LOTTO_NUMBER_REGEX = "^[0-9]{1,2}";
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        this.winningNumbers = validateWinningNumbers(winningNumbers);
        this.bonusNumber = validateBonusNumber(bonusNumber);
    }

    public boolean contains(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean hasBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }

    private List<Integer> validateWinningNumbers(String winningNumbers) {
        List<String> winning = convertStringToListByRest(winningNumbers);
        validateWinningNumberSixElement(winning);
        winning.forEach(this::validateLottoNumberHasCharacter);
        List<Integer> winningLottoNumbers = convertWinningNumbersToInteger(winning);
        winningLottoNumbers.forEach(LottoNumberRange::validateLottoNumberRage);
        return winningLottoNumbers;
    }

    private List<String> convertStringToListByRest(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","));
    }

    private void validateWinningNumberSixElement(List<String> winningNumbers) {
        if (winningNumbers.size() != Constant.CORRECT_LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessages.WINNING_NUMBER_HAS_SIX_ELEMENT);
        }
    }

    private void validateLottoNumberHasCharacter(String lottoNumber) {
        if (!lottoNumber.matches(LOTTO_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.LOTTO_ONLY_NUMBERS);
        }
    }

    private List<Integer> convertWinningNumbersToInteger(List<String> winningNumbers) {
        return winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int validateBonusNumber(String bonusNumber) {
        validateLottoNumberHasCharacter(bonusNumber);
        LottoNumberRange.validateLottoNumberRage(Integer.parseInt(bonusNumber));
        validateBonusNumberDuplicate(Integer.parseInt(bonusNumber));
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumberDuplicate(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessages.BONUS_NUMBER_DUPLICATE);
        }
    }
}
