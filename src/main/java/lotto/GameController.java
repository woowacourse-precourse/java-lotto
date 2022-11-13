package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수여야 합니다.");
        }
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
            try {
                winningNum.add(Integer.parseInt(str));
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수여야 합니다.");
            }
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = 0;
        try {
            bonusNum = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
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
        System.out.printf("총 수익률은 %.1f%%입니다.", calc.getYield());
    }

    public void run() {
        try {
            User user  = new User(inputAmount());
            LottoSeller lottoSeller = new LottoSeller();
            user.buyLotto(lottoSeller);
            printLotto(user);

            WinningNumber winningNumber = inputWinningNumAndBonusNum();

            Calculator calc = new Calculator(winningNumber.getWinningNum(), winningNumber.getBonusNum(),user.getLotto());
            printWinningStat(calc);
            printYield(calc);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
