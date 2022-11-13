package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GamController {
    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private void printLotto(User user) {
        System.out.printf("%d개를 구매했습니다.\n", user.getNumberOfLotto());
        for (Lotto lotto: user.getLotto()) {
            System.out.println(lotto.getLottoNum());
        }
    }

    private WinningNumber inputWinningNumAndBonusNum() {
        System.out.println("당첨 번호를 입력해 주세요");
        String input = Console.readLine().replace(" ", "");
        List<Integer> winningNum = new ArrayList<Integer>();
        for (String str : input.split(",")) {
            winningNum.add(Integer.parseInt(str));
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        return new WinningNumber(winningNum, bonusNum);
    }

    private void printWinningStat(Calculator calc) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf(
                "3개 일치 (5,000원) - %d개\n4개 일치 (50,000원) - %d개\n5개 일치 (1,500,000원) - %d개\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n6개 일치 (2,000,000,000원) - %d개\n",
                calc.getCountByRank(5),
                calc.getCountByRank(4),
                calc.getCountByRank(3),
                calc.getCountByRank(2),
                calc.getCountByRank(1));
    }

    private void printYield(Calculator calc) {
        System.out.printf("총 수익률은 %.1f입니다.", calc.getYield());
    }

    public void run() {
        User user  = new User(inputAmount());

        LottoSeller lottoSeller = new LottoSeller();
        user.buyLotto(lottoSeller);
        printLotto(user);

        WinningNumber winningNumber = inputWinningNumAndBonusNum();

        Calculator calc = new Calculator(winningNumber, user);
        printWinningStat(calc);
        printYield(calc);
    }
}
