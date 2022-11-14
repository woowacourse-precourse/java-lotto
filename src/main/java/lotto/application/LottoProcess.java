package lotto.application;

import static lotto.common.message.ConsoleOut.*;
import static lotto.common.message.ExceptionMessage.ERROR_CODE;
import static lotto.common.message.ExceptionMessage.GAME_MONEY_TYPE_EXCEPTION_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.common.message.ConsoleOut;
import lotto.domain.Generator;
import lotto.domain.entity.LottoMachine;
import lotto.domain.entity.Lottos;
import lotto.domain.entity.Money;
import lotto.domain.entity.LottoNumberMatcher;
import lotto.domain.entity.Report;
import lotto.domain.entity.User;
import lotto.domain.vo.MatchReport;
import lotto.domain.wrapper.Rank;
import lotto.infrastructure.GeneratorImpl;

public class LottoProcess {

    private static Generator generator = new GeneratorImpl();

    public static void run() {
        System.out.println(INPUT_COST_MASSAGE);
        Integer moneyInput = getMoneyInput();

        Money money = Money.from(moneyInput);
        Lottos lottos = Lottos.from(money.currentTime());

        User user = User.of(money, lottos);
        System.out.println(user.printCurrentTime() + AMOUNT_OF_LOTTOS_MESSAGE);
        user.printUserLottosNumbers();

        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String lottoNumber = generator.generateLotto();
        String[] numberSeparator = generator.numberSeparator(lottoNumber);

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusLottoNumber = generator.generateBonusLottoNumber();
        LottoMachine lottoMachine = LottoMachine.of(numberSeparator,
            Integer.valueOf(bonusLottoNumber));

        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(THREE_DASHES_AFTER_WINNING_RESULT_MESSAGE);

        LottoNumberMatcher matcher = new LottoNumberMatcher();

        List<MatchReport> reportList = matcher.match(user.currentUserLottos(), lottoMachine);

        Report printReport = new Report();
        printWholePrizes(reportList, printReport);
        String interest = printReport.TotalInterest(money.currentMoney());

        System.out.println(ConsoleOut.TOTAL_PRIZE_MESSAGE_PRE + interest
            + ConsoleOut.TOTAL_PRIZE_MESSAGE_POST);
    }

    private static void printWholePrizes(List<MatchReport> reportList, Report printReport) {
        Map<Rank, Integer> rankIntegerMap = printReport.printEachPrize(reportList);
        for (Rank rank : rankIntegerMap.keySet()) {
            System.out.println(rank.currentWinningMessage() + rankIntegerMap.get(rank) + AMOUNT);
        }
    }

    private static Integer getMoneyInput() {
        Integer moneyInput = 0;
        try {
            String str = Console.readLine();
            moneyInput = Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_CODE + GAME_MONEY_TYPE_EXCEPTION_MESSAGE);
        }
        return moneyInput;
    }
}
