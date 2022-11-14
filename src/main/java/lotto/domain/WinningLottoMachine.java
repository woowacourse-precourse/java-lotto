package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants;

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

    private void validateLottoNumberLength(List<Integer> numberList) {
        if (numberList.size() != Constants.LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException("6 개의 숫자가 아닙니다.");
        }
    }

    private void validateLottoNumberRange(List<Integer> numberList) {
        boolean rangeOverFlag = numberList.stream()
                .anyMatch(number -> number < Constants.MIN_LOTTO_NUMBER_RANGE.getValue()
                        || number > Constants.MAX_LOTTO_NUMBER_RANGE.getValue());

        if (rangeOverFlag) {
            throw new IllegalArgumentException("로또 숫자중 범위 밖의 숫자가 있습니다.");
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
            throw new IllegalArgumentException("분할될 수 없는 입력입니다.");
        }
    }

    private int validateNumeric(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수가 아닌 입력이 있습니다.");
        }
        return number;
    }

    private void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }
}

