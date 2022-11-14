package lotto.screen;

import camp.nextstep.edu.missionutils.Console;

import java.util.function.Function;

public class ConsoleInput implements Input {

    private static ConsoleInput consoleInput = new ConsoleInput();

    private ConsoleInput() {
    }

    public static ConsoleInput getInstance() {
        return consoleInput;
    }
    @Override
    public String inputValue() {
        String input = Console.readLine();
        return input;
    }

    @Override
    public Object input(String prompt, Function<String, Object> function) {
        System.out.println(prompt);
        return function.apply(inputValue());
    }
}
