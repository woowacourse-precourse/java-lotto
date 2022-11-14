package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.message.ExceptionMessage;

public class WinnerNumber {
    public static final String LOTTO_NUMBER_CHECK = "^([0-9]*,){5}[0-9]*$";
    public static final String BONUS_NUMBER_CHECK = "^[0-9]*$";

    public static final String COMMA = ",";
    public static final int LOTTO_NUMBER = 0;
    public static final int BONUS_NUMBER = 1;
    public static final int MAX_NUMBER = 6;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int MINIMUM_NUMBER = 1;


    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinnerNumber(List<String> winnerNumber) {
        validateLottoNumber(winnerNumber.get(LOTTO_NUMBER));
        validateBonusNumber(winnerNumber.get(BONUS_NUMBER));
        this.numbers = creatNumberList(winnerNumber.get(LOTTO_NUMBER));
        this.bonusNumber = Integer.parseInt(winnerNumber.get(BONUS_NUMBER));
    }

    private List<Integer> creatNumberList(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(COMMA))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public void validateLottoNumber(String inputLottoNumber) {
        if (!inputLottoNumber.matches(LOTTO_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.WINNING_FORMAT_ERROR);
        }
        if (isDuplicatedNumber(List.of(inputLottoNumber.split(COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER);
        }
        if (isOutOfBounds(List.of(inputLottoNumber.split(COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS);
        }
    }

    private boolean isOutOfBounds(List<String> splitInputWinningNumber) {
        return getMaximumNumber(splitInputWinningNumber) > MAXIMUM_NUMBER
                || getMinimumNumber(splitInputWinningNumber) < MINIMUM_NUMBER;
    }

    private int getMinimumNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .map(Integer::parseInt)
                .min(Integer::compareTo)
                .get();
    }

    private int getMaximumNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .map(Integer::parseInt)
                .max(Integer::compareTo)
                .get();
    }

    private boolean isDuplicatedNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .distinct()
                .count() != MAX_NUMBER;
    }

    public void validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT);
        }
        if (Integer.parseInt(bonusNumber) < MINIMUM_NUMBER || Integer.parseInt(bonusNumber) > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDS);
        }
    }
}
