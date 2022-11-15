package lotto;

import static lotto.util.NumberParser.stringArrayToIntegerList;
import static lotto.util.NumberParser.stringToInteger;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoMachine;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            lottoGameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    static void lottoGameStart() {
        View view = new View();
        view.printSpentMoneyMenu();
        String playerNum = Console.readLine();
        LottoMachine lottoMachine = new LottoMachine(stringToInteger(playerNum));
        view.printLottoCnt(lottoMachine.getPurchasedLottoCnt());
        System.out.println(lottoMachine.lottosToString());
        view.printInputWinningNumbersMenu();

        Lotto winningLotto = new Lotto(stringArrayToIntegerList(view.readLine().split(",")));
        view.printInputBonusNumberMenu();

        int bonusNumber = stringToInteger(Console.readLine());
        checkNum(view, winningLotto, bonusNumber, lottoMachine);

    }

    static void checkNum(View view, Lotto winningLotto, int bonusNumber, LottoMachine lottoMachine) {
        winningLotto.validateBonusNumber(bonusNumber);
        lottoMachine.checkLottosRank(winningLotto, bonusNumber);
        view.printRankStatistic(lottoMachine.rankStatisticsToString());
    }
}
