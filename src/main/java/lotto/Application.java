package lotto;

import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;
import lotto.io.View;

public class Application {
    public static void main(String[] args) {
        new LottoProgram(new View(new ConsoleInput(), new ConsoleOutput()), new LottoService()).run();
    }
}

