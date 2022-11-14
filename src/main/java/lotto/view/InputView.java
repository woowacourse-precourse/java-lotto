package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidRangeLottoNumberException;

public class InputView {
    private static final int MIN_RANGE_NUMBER = 1;
    private static final int MAX_RANGE_NUMBER = 45;

    public String inputValue() {
        return Console.readLine();
    }

    protected void validateRange(int number) {
        if (!(MIN_RANGE_NUMBER <= number && number <= MAX_RANGE_NUMBER)) {
            throw new InvalidRangeLottoNumberException();
        }
    }
}
