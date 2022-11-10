package lotto.application;

import static lotto.common.message.ConsoleOut.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;
import lotto.domain.Generator;
import lotto.domain.entity.LottoMachine;
import lotto.domain.entity.User;
import lotto.infrastructure.GeneratorImpl;

public class LottoProcess {

    private static Generator generator = new GeneratorImpl();

    public static void run() {
        System.out.println(INPUT_COST_MASSAGE);
        int money = generator.generateMoney();

        User user = User.of(money, generator);
        System.out.println(user.printCurrentTime() + AMOUNT_OF_LOTTOS_MESSAGE);
        user.printUserLottosNumbers();

        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String lottoNumber = generator.generateLotto();
        String[] numberSeparator = generator.numberSeparator(lottoNumber);

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusLottoNumber = generator.generateBonusLottoNumber();
        LottoMachine.of(numberSeparator, Integer.valueOf(bonusLottoNumber));
    }
}
