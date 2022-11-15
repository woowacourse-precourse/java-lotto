package lotto;

import lotto.io.Input;
import lotto.io.InputConsole;
import lotto.io.Output;
import lotto.io.OutputConsole;

import lotto.model.Game;

public class Application {

    public static void main(String[] args) {
        Input input = new InputConsole();
        Output output = new OutputConsole();
        try {
            new Game(input, output).run();
        } catch (TryCatchException e) {
            output.print(e.getMessage());
        }
    }
}
