package lotto.ui.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.function.IntConsumer;

public class WinnerNumberGetter {
    public Map<Integer, Integer> getLotteryWinningNumbersInput() {
        Map<Integer, Integer> numbers = new HashMap<>();

        Arrays.asList(Console.readLine().split(",")).stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt).iterator().forEachRemaining((IntConsumer) i -> numbers.put(i, 1));

        return numbers;
    }

    public int getBonusInput() {
        int bonus = Integer.parseInt(Console.readLine());

        return bonus;
    }
}
