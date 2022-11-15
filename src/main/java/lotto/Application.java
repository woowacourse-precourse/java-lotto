package lotto;

import lotto.engine.LottoGenerator;
import lotto.engine.NextstepNumberGenerator;
import lotto.engine.NumberGenerator;
import lotto.io.ConsoleInput;
import lotto.io.ConsoleOutput;
import lotto.io.Input;
import lotto.io.Output;

public class Application {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        NumberGenerator numberGenerator = new NextstepNumberGenerator();
        LottoGenerator lottoGenerator = new LottoGenerator(numberGenerator);

        new LottoMachine(input, output, lottoGenerator).run();
    }
}
