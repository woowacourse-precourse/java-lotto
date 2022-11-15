package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Money money = InputMoney();
        List<Lotto> lottos = BuyLotteryTickets(money);

        Win win = InputWinningNumber();
        Bonus bonus = InputBonusNumber(win);

        Winnings winnings = new Winnings(lottos, win, bonus);
        winnings.printResult(money);
    }

    private static Money InputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        Money money = new Money(Console.readLine());
        System.out.println();
        return money;
    }

    private static List<Lotto> BuyLotteryTickets(Money money) {
        int lottoTicketsCount = LotteryTicket.buyTickets(money);
        System.out.println(lottoTicketsCount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketsCount; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(list);
            lottos.add(new Lotto(list));
        }
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
        System.out.println();

        return lottos;
    }

    private static Win InputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        List<Integer> winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Win win = new Win(winningNumber);
        System.out.println();

        return win;
    }

    private static Bonus InputBonusNumber(Win win) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        return new Bonus(win.getNumbers() ,bonusNumber);
    }
}
