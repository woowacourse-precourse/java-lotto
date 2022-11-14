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

    public void run() {
        Print print = new Print();

        User user = new User(inputAmount());
        LottoSeller lottoSeller = new LottoSeller();
        user.buyLotto(lottoSeller);
        print.Lotto(user);

        WinningNumber winningNumber = inputWinningNumAndBonusNum();

        Calculator calc = new Calculator(winningNumber.getWinningNum(), winningNumber.getBonusNum(), user.getLotto());
        print.WinningStat(calc);
        print.Yield(calc);
    }
}
