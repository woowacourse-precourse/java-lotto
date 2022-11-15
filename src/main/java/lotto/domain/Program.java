package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Program {
    PrintMsg printMsg = new PrintMsg();
    View view = new View();
    LottoGenerator lottoGenerator = new LottoGenerator();
    DrawLotto drawLotto;
    int numOfLottos, bonus, money;
    String moneyString;
    List<Lotto> lottoList;
    List<Integer> winner;
    Map<Ranking, Integer> result;
    double profitRate;
    boolean cont = true;
    public void run() {
        lottoSetup();
        lottoGeneration(cont);
        winnerSetup(cont);
        bonusSetup(cont);
        result(cont);
    }
    public void lottoSetup() {
        printMsg.printMoneyInputMsg();
        moneyString = Console.readLine();
        try {
            money = view.validateIsNumber(moneyString);
        } catch (IllegalArgumentException e) {
            System.out.println(view.ERROR_INTEGERS);
            cont = false;
            return;
        } try {
            money = view.validateIsDivisible(money);
        } catch (IllegalArgumentException e) {
            System.out.println(view.ERROR_INDIVISIBLE);
            cont = false;
            return;
        }
        money = Integer.parseInt(moneyString);
    }
    public void lottoGeneration(boolean cont) {
        if (!cont) {
            return;
        }
        System.out.println();
        numOfLottos = money/1000;
        printMsg.printNumberOfLottosMsg(numOfLottos);
        lottoList = lottoGenerator.generateLottos(numOfLottos);
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
        System.out.println();
    }
    public void winnerSetup(boolean cont) {
        if (!cont) { return; }
        printMsg.printWinnerInputMsg();
        winner = view.getWinnerInput();
        System.out.println();

    }
    public void bonusSetup(boolean cont) {
        if (!cont) {
            return;
        }
        printMsg.printBonusInputMsg();
        bonus = view.getBonusInput(winner);
        System.out.println();
    }
    public void result(boolean cont) {
        if (!cont) {
            return;
        }
        printMsg.printResultMsg();
        drawLotto = new DrawLotto(lottoList, winner, bonus);
        result = drawLotto.checkListOfLottos();
        printMsg.printResult(result);
        profitRate = drawLotto.calculateProfitRate(money);
        printMsg.printProfitRate(profitRate);
    }
}
