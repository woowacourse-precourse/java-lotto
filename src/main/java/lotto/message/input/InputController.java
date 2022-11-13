package lotto.message.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.PrintController;

public abstract class InputController {

    static final int LOTTO_PER_PRICE = 1000;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final int LOTTO_NUMBER_LENGTH = 6;
    PrintController printController = new PrintController();


    public String readLine() {
        return Console.readLine();
    }

    public abstract String input();

    public abstract void validate(Object input);
}
