package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidRangeLottoNumberException;

public class InputView {
    protected String inputValue() {
        return Console.readLine();
    }
}
