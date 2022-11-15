package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.LottoConstants;
import lotto.constants.InputExceptionConstants;
import lotto.constants.LottoExceptionConstants;

public class WinningLottoMachine {

    public List<Integer> giveWinningLottoNumber(String input) {
        validateNumberCanSplit(input);
        List<Integer> winningNumberList = makeNumberList(input);
        validateLottoNumberLength(winningNumberList);
        validateLottoNumberRange(winningNumberList);

        return winningNumberList;
    }

    public int giveWinningLottoBonusNumber(String input) {
        validateBlank(input);
        int bonusNumber = validateNumeric(input);
        return bonusNumber;
    }

    public WinningLotto makeWinningLotto(List<Integer> winningLottoNumber, int winningLottoBonusNumber) {
        return new WinningLotto(winningLottoNumber, winningLottoBonusNumber);
    }
    private void validateLottoNumberLength(List<Integer> numberList) {
        if (numberList.size() != LottoConstants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException(LottoExceptionConstants.LOTTO_NUMBER_LENGTH.getValue());
        }
    }

    private void validateLottoNumberRange(List<Integer> numberList) {
        boolean rangeOverFlag = numberList.stream()
                .anyMatch(number -> number < LottoConstants.MIN_LOTTO_NUMBER_RANGE.getValue()
                        || number > LottoConstants.MAX_LOTTO_NUMBER_RANGE.getValue());

        if (rangeOverFlag) {
            throw new IllegalArgumentException(LottoExceptionConstants.LOTTO_NUMBER_RANGE.getValue());
        }
    }

    private List<Integer> makeNumberList(String input) {
        List<Integer> numberList = new ArrayList<>();

        for (String element : input.split(",")) {
            int number = validateNumeric(element);
            numberList.add(number);
        }

        return numberList;
    }

    private void validateNumberCanSplit(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_NONE_SPLIT.getValue());
        }
    }

    private int validateNumeric(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_NONE_NUMERIC.getValue());
        }
        return number;
    }

    private void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_BLANK.getValue());
        }
    }
}

