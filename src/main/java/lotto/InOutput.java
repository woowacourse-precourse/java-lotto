package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UserInput {
    private static final Integer each_lotto = 1000;
    public Long cost = 0L;
    public Integer bonus = 0;
    public HashSet<Integer> winning = null;
    public List<Lotto> bought = new ArrayList<>();

    public void getAllInput() throws IllegalArgumentException {
        howMuchLotto();
        Output.printLotto(this);
        winningNumber();
        bonusNumber();
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
        if (!input.matches("\\d+"))
            Err.NUMERIC_ERROR.invalid();
        if (Integer.parseInt(input) % 1000 != 0)
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
}
