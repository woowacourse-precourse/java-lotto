package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(Error.WRONG_QUANTITY.message());
        for (Integer number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException(Error.OUT_OF_RANGE.message());
        }
        if (isRedundant(numbers))
            throw new IllegalArgumentException(Error.WRONG_INPUT.message());
    }

    // TODO: 추가 기능 구현
    public static boolean isRedundant(List<Integer> input) {
        if (input == null)
            return false;
        Set<Integer> set = new HashSet<>(input);
        return set.size() < input.size();
    }
    public static String inputLotto() {
        System.out.println(Initialize.LOTTO.message());
        return Console.readLine();
    }

    public static List<Integer> splitNumbers(String lotto) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : lotto.split(",")) {
            winningNumbers.add(Integer.valueOf(s));
        }
        return winningNumbers;
    }
}