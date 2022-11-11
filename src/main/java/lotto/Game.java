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
        Money.inputMoneyForLotto(input, output);
        long lottoCnt = Money.printHowManyLottos(output);   //구매한 로또의 개수

        //SixDigitGenerator.generateLottoDigits(lottoCnt);
        // n개의 6개 짜리 로또 만드는 과정 있어야함.


        System.out.println(Answer.InputAnswer(input, output));
        Lotto answer = new Lotto(Answer.InputAnswer(input, output));

        //Bonus 를 입력받고, Lotto 에 있는지 확인해야 한다.
        //bonus가 몇개인지는 정하기 나름이기 때문에 bunus도 lotto에 담을 것이다.
        Bonus.InputBonus(input, output, answer);


    }
}
