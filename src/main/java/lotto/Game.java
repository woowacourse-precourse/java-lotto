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
        Money.inputMoneyForLotto(input, output);
        long lottoCnt = Money.printHowManyLottos(output);   //구매한 로또의 개수

        LottoContainer lottoBox = new LottoContainer(SixDigitGenerator.generateLottoDigits(lottoCnt));
        lottoBox.printLottoBundles(output);
        output.printOutput("\n");

        Lotto answer = new Lotto(Answer.InputAnswer(input, output));
        Bonus.inputBonus(input, output, answer);

        //당첨 통계



        System.out.println("GOOOOOOOOD");
    }
}
