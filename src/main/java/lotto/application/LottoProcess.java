package lotto.application;

import lotto.common.message.ConsoleOut;
import lotto.domain.Generator;
import lotto.domain.entity.LottoMachine;
import lotto.domain.entity.User;
import lotto.infrastructure.GeneratorImpl;

public class LottoProcess {

    private static Generator generator = new GeneratorImpl();

    public static void run() {
        System.out.println(ConsoleOut.INPUT_COST_MASSAGE);
        int money = generator.generateMoney();//

        User user = User.of(money, generator);

        System.out.println(user.printCurrentTime() + ConsoleOut.AMOUNT_OF_LOTTOS_MESSAGE);
        user.printUserLottosNumbers();

        System.out.println(ConsoleOut.INPUT_WINNING_NUMBER_MESSAGE);
        String lottoNumber = generator.generateLotto();
        generator.numberSeparator(lottoNumber);
        
    }
}
