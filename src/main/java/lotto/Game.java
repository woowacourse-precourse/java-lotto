package lotto;

import io.Input;
import io.Output;
import java.util.ArrayList;
import java.util.List;

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
        Lotto bonus = Bonus.inputBonus(input, output, answer);


        //TotalResultMaker totalResultMaker = new TotalResultMaker(answer, output);
        //당첨 통계
        List<Integer> answerCompareResult =  lottoBox.getAnswerCompareResult(answer);
        List<Integer> bonusCompareResult = lottoBox.getBonusCompareResult(bonus);

        //TotalResultMaker.

        System.out.println("!!!   :   " + answerCompareResult);
        System.out.println("!!!   :   " + bonusCompareResult);



        System.out.println("GOOOOOOOOD");
    }
}
