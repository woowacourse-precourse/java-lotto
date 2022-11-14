package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InOutput {
    private static final Integer each_lotto = 1000;
    private Long cost = 0L;
    private Integer bonus = 0;
    private HashSet<Integer> winning = new HashSet<>();
    private List<Lotto> bought = new ArrayList<>();
    private double earn_rate = 0.0;

    public void printAll() throws IllegalArgumentException {
        howMuchLotto();
        printLotto();
        winningNumber();
        bonusNumber();
        printWinning();
    }

    public void buy() throws IllegalArgumentException {
        for (int i = 0; i < cost / each_lotto; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            bought.add(new Lotto(numbers));
        }
    }

    private void howMuchLotto() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        // only positive integers are allowed
        if (!input.matches("\\d+"))
            Err.NUMERIC_ERROR.invalid();
        // only multiples of 1000 are allowed
        if (Integer.parseInt(input) % each_lotto != 0 && !input.equals("0"))
            Err.PAYMENT_NUMBER_ERROR.invalid();
        cost = Long.parseLong(input);
        buy();
    }

    private void winningNumber() throws IllegalArgumentException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("(\\d+,){5}\\d+"))
            Err.LOTTO_FORMAT_ERROR.invalid();
        String[] tmp = input.split(",");
        for (int i = 0; i < 6; ++i) {
            Integer curr = Integer.parseInt(tmp[i]);
            if (curr < 1 || curr > 45)
                Err.RANGE_ERROR.invalid();
            if (!winning.add(curr))
                Err.DUPLICATE_ERROR.invalid();
        }
    }

    private void bonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        if (!input.matches("\\d+"))
            Err.NUMERIC_ERROR.invalid();
        bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45)
            Err.RANGE_ERROR.invalid();
        if (winning.contains(bonus))
            Err.DUPLICATE_ERROR.invalid();
    }

    private void printWinning() {
        System.out.print("당첨통계\n---\n");
        for (int i = 0; i < bought.size(); ++i)
            bought.get(i).check(winning, bonus);
        for (Prize p: Prize.values()) {
            p.print();
            earn_rate += p.earn();
        }
        earn_rate = Math.round(earn_rate / cost * 1000.0) / 1000.0;
        System.out.format("총 수익률은 %,.1f%%입니다.\n", earn_rate * 100.0);
    }

    private void printLotto() {
        System.out.format("%d개를 구매했습니다.\n", cost / 1000);
        for (int i = 0; i < bought.size(); ++i)
            bought.get(i).print();
    }
}
