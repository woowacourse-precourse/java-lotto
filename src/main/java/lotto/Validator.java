package lotto;

import static lotto.Model.Error.Invalid_nbr;
import static lotto.Model.Error.No_boundary;
import static lotto.Model.Error.getErrorMessage;

import static lotto.Model.Error.Dup_nbr;
import static lotto.Model.Error.Invalid_lotto;
import static lotto.Generate.cnt;
import static lotto.Generate.Finish;
import static lotto.Generate.Start;

import static lotto.Model.Error.No_number;
import static lotto.Model.Error.Amount_error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Validator {
    private static final String Bonus_reg = "\\d{1,2}";
    public static void checkSizeNumber(final String bonus) {
        if (!bonus.matches(Bonus_reg)) {
            throw new IllegalArgumentException(getErrorMessage(Invalid_nbr) + bonus);
        }
    }

    public static void checkRange(final String bonus) {
        if (!Lottery_nbr.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(getErrorMessage(No_boundary));
        }
    }
    public static final List<Integer> Lottery_nbr = IntStream.rangeClosed(Start, Finish)
            .boxed().collect(Collectors.toList());

    public static void checkSize(final List<Integer> numbers) {
        if (cnt != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(Invalid_lotto) + numbers.size());
        }
    }

    public static void checkDuplication(final List<Integer> numbers) {
        Set<Integer> check = new HashSet<>();
        Set<Integer> duplications = numbers.stream()
                .filter(number -> !check.add(number))
                .collect(Collectors.toSet());
        if (check.size() != numbers.size()) {
            throw new IllegalArgumentException(getErrorMessage(Dup_nbr, duplications));
        }
    }

    public static void checkRange(final List<Integer> numbers) {
        Set<Integer> outBound = numbers.stream()
                .filter(number -> !Lottery_nbr.contains(number))
                .collect(Collectors.toSet());
        if (outBound.size() != 0) {
            throw new IllegalArgumentException(getErrorMessage(No_boundary, outBound));
        }
    }
    public static final int Min_money = 1000;
    private static final int Min_buy = 0;
    private static final String Member_reg = "[0-9]+";

    public static void checkConsistNumber(final String pay) {
        if (!pay.matches(Member_reg)) {
            throw new IllegalArgumentException(getErrorMessage(No_number) + pay);
        }
    }

    public static void checkReminder(final String pay) {
        if (Min_buy != Integer.parseInt(pay) % Min_money) {
            throw new IllegalArgumentException(getErrorMessage(Amount_error) + pay);
        }
    }
}
