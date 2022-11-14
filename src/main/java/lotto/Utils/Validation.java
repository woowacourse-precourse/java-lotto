package lotto.Utils;

import java.util.ArrayList;
import java.util.List;

import static lotto.Enum.ErrorMessage.*;
import static lotto.Enum.LottoProperty.*;

public class Validation {

    private List<Integer> numbers;

    public void validateMoney(String inputMoney) {
        checkNumberValues(inputMoney);
        checkPayMoney(inputMoney);
    }

    public void validateLottoNumberList(List<Integer> numbers) {
        this.numbers = numbers;

        checkLengthOfLottoNumbers();
        checkRangeOfLottoNumbers();
        checkDuplicationOfLottoNumbers();
    }

    public void validateWinningNumberArray(String[] winningNumbersArray) {
        List<Integer> winningNumberList = new ArrayList<>();

        for (String winningNumber : winningNumbersArray) {
            winningNumberList.add(checkNumberValues(winningNumber));
        }
        validateLottoNumberList(winningNumberList);
    }

    public void validateBonusNumber(String inputBonusNumber) {
        int parsedNumber = checkNumberValues(inputBonusNumber);
        checkRangeOfLottoNumbers(parsedNumber);
        checkDuplicationOfLottoNumbers(parsedNumber);
    }

    private int checkNumberValues(String stringNumber) {
        int parsedNumber;

        try {
            parsedNumber = Integer.parseInt(stringNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INPUT_INTEGER_VALUE.toMessage());
        }

        return parsedNumber;
    }

    private void checkPayMoney(String inputMoney) {
        int intMoney = Integer.parseInt(inputMoney);
        if (intMoney % ONE_LOTTO_COST.getValue() != 0) {
            throw new IllegalArgumentException(NOT_PROPER_PAY_MONEY.toMessage());
        }
    }

    private void checkLengthOfLottoNumbers() {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getValue()) {
            throw new IllegalArgumentException(NOT_PROPER_WINNING_NUMBER_LENGTH.toMessage());
        }
    }

    private void checkRangeOfLottoNumbers() {
        for (int number : numbers) {
            if (MIN_LOTTO_NUMBER.getValue() > number || number > MAX_LOTTO_NUMBER.getValue()) {
                throw new IllegalArgumentException(OUT_OF_LENGTH.toMessage());
            }
        }
    }

    private void checkRangeOfLottoNumbers(int lottoNumber) {
        if (MIN_LOTTO_NUMBER.getValue() > lottoNumber || lottoNumber > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_LENGTH.toMessage());
        }
    }

    private void checkDuplicationOfLottoNumbers() {
        List<Integer> checkDuplicatedNumberList = new ArrayList<>();

        for (int number : numbers) {
            if (checkDuplicatedNumberList.contains(number)) {
                throw new IllegalArgumentException(DUPLICATED_NUMBERS.toMessage());
            }
            checkDuplicatedNumberList.add(number);
        }
    }

    private void checkDuplicationOfLottoNumbers(int bonusNumber) {
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBERS.toMessage());
        }
    }
}
