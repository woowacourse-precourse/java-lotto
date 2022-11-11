package lotto;

import io.Input;
import io.Output;
import io.Sentence;

public class game {

    public static void run(Input input, Output output) {

       // output.printOutput(Sentence.INPUTMONEY);
        //String moneyInput = input.getInput();
        Money.InputMoneyForLotto(input, output);
        int lottoCnt = Money.printHowManyLottos(output);
        for (int i = 0; i < lottoCnt; i++) {
            SixDigitGenerator.generateLottoDigits();
        }

    }
}
