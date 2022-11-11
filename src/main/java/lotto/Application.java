package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        AutomaticLottery autoMachine = new AutomaticLottery();
        List<List<Integer>> lotteries = autoMachine.buyLotteries(amount);
        autoMachine.printLotteries(lotteries);

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        List<Integer> winningNumbers = Lotto.sliceWinningNumber(inputWinningNumber);
        Lotto lotto = new Lotto(winningNumbers);
        System.out.println("");

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        Integer bonusNumber = lotto.inputBonusNumber(inputBonusNumber);
        System.out.println("");

        System.out.println("당첨 통계");
        System.out.println("---");
        Draw draw = new Draw();
        draw.saveWinningCase(lotteries, winningNumbers, bonusNumber);
        draw.savePrizeMoney();

        EarningsRate rate = new EarningsRate();
        rate.printStatistics();
        String earningsRate = rate.calculationEarningsRate(amount);
        System.out.println("총 수익률은 " + earningsRate + "%입니다.");
    }
}