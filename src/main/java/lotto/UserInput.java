package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInput {
    private static final Integer each_lotto = 1000;
    private static Integer lotto_total = 0;
    private static List<Integer> winning = new ArrayList<>();
    private static Integer bouns = 0;

    public static void getAllInput() throws IllegalArgumentException {
        howMuchLotto();
        winningNumber();
        bonusNumber();
    }

    public static List<Lotto> buy() throws IllegalArgumentException {
        List<Lotto> bought = new ArrayList<>();
        for (int i = 0; i < lotto_total / each_lotto; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            bought.add(new Lotto(numbers));
        }
        return bought;
    }

    private static void howMuchLotto() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.matches("\\d+"))
            Err.NUMERIC_ERROR.invalid();
        if (Integer.parseInt(input) % 1000 != 0)
            Err.PAYMENT_NUMBER_ERROR.invalid();
        lotto_total = Integer.parseInt(input);

    }

    private static void winningNumber() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.matches("(\\d,){5}\\d+"))
            Err.LOTTO_FORMAT_ERROR.invalid();
        HashSet<Integer> check = new HashSet<>();
        String[] tmp = input.split(",");
        for (int i = 0; i < 6; ++i) {
            Integer curr = Integer.parseInt(tmp[i]);
            if (curr < 1 || curr > 45)
                Err.RANGE_ERROR.invalid();
            if (check.contains(curr))
                Err.DUPLICATE_ERROR.invalid();
            check.add(curr);
            winning.add(curr);
        }
    }

    private static void bonusNumber() throws IllegalArgumentException {
        String input = Console.readLine();
        if (!input.matches("\\d"))
            Err.NUMERIC_ERROR.invalid();
        bouns = Integer.parseInt(input);
        if (bouns < 1 || bouns > 45)
            Err.RANGE_ERROR.invalid();
        if (winning.contains(bouns))
            Err.DUPLICATE_ERROR.invalid();
    }
}
