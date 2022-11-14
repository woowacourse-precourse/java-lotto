package lotto;

import lotto.io.Input;
import lotto.io.Output;
import lotto.io.View;

public class Application {
    public static void main(String[] args) {
        new LottoProgram(new View(new Input(), new Output()), new LottoService()).run();
    }
}

