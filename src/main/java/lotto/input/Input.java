package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoException;

public class Input {
    public String request() {
        return Console.readLine();
    }

    public int convertInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new LottoException(this.getClass());
        }
    }
}
