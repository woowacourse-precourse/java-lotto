package lotto;

import io.Input;
import io.Output;

public class Game {
    private static Input input;
    private static Output output;

    public Game(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public static void run() {
       // output.printOutput(Sentence.INPUTMONEY);
        //String moneyInput = input.getInput();
        Money.InputMoneyForLotto(input, output);
        long lottoCnt = Money.printHowManyLottos(output);
        //SixDigitGenerator.generateLottoDigits(lottoCnt);
        // n개의 6개 짜리 로또 만드는 과정 있어야함.
        Answer.InputAnswer(input, output);

    }
}
