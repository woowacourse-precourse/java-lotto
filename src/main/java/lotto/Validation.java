package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Validation {

    public void checkNumeric(String input) throws IllegalArgumentException {
        if (!input.matches(Constant.NUMERIC_REGEX)) {
            throw new IllegalArgumentException(Error.NOT_NUMERIC.message());
        }
    }

    public void checkNumberInRange(int number) throws IllegalArgumentException {
        if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.message());
        }
    }

    public void checkDividable(int number) throws IllegalArgumentException {
        if (number % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(Error.NOT_DIVIDABLE.message());
        }
    }

    public void checkNull(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Error.IS_NULL.message());
        }
    }

    public void checkDuplicate(List<Integer> list) throws IllegalArgumentException {
        if (list.stream().distinct().collect(Collectors.toList()).size() != list.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_IN_WINNING.message());
        }
    }

    public void checkBonusDuplicate(Lotto winning, int bonus) {
        if (winning.hasNumber(bonus)) {
            throw new IllegalArgumentException(Error.DUPLICATE_IN_BONUS.message());
        }
    }

    public void checkLottoNumberLength(List<Integer> numbers) {
        if (numbers.size() != Constant.VALID_LOTTO_LENGTH) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_LENGTH.message());
        }
    }

    public void checkWinningFormat(String input) throws IllegalArgumentException {
        try {
            String[] inputSplit = input.split(",");
            List<Integer> lottoFormat = new ArrayList<>();
            for (int i = 0; i < inputSplit.length; i++) {
                lottoFormat.add(Integer.parseInt(inputSplit[i]));
            }
            checkLottoNumberLength(lottoFormat);
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.OUT_OF_WINNING_FORMAT.message());
        }
    }

}
