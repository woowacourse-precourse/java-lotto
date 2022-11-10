package lotto.console;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public abstract class Console {
    private final String NO_SUCH_ELEMENT_EXCEPTION_MESSAGE = "입력값이 비었습니다.";

    public String getUserInput() {
        try {
            String input = readLine();
            checkInput(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new InvalidInputException(NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
        }
    }

    protected abstract void checkInput(String input);
}
