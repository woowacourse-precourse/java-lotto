package lotto.Utils;

import java.util.List;

import static lotto.Enum.ErrorMessage.OUT_OF_LENGTH;
import static lotto.Enum.LottoProperty.*;

public class Validation {

    private List<Integer> numbers;
    private List<Integer> winningNumbers;

    public void validateMoney(String inputMoney) {

    }

    public void validateLottoNumberList(List<Integer> numbers) {
        this.numbers = numbers;

        checkLengthOfLottoNumbers();
        checkRangeOfLottoNumbers();
        checkDuplicationOfLottoNumbers();
    }

    public void validateWinningNumbers(String inputWinningNumbers) {
    }

    public void validateBonusNumber(String inputBonusNumber) {
    }


    private void checkLengthOfLottoNumbers() {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.toMessage());
        }
    }

    private void checkRangeOfLottoNumbers() {
    }

    private void checkRangeOfLottoNumbers(int lottoNumber) {
        if (MIN_LOTTO_NUMBER.getValue() > lottoNumber || lottoNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.toMessage());
        }
    }

    private void checkDuplicationOfLottoNumbers() {
    }


}
