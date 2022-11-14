package lotto.condition.lottonumber;

import lotto.Util;
import lotto.condition.Condition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoDuplicateNumberCond implements Condition {

    private static final Condition instance = new NoDuplicateNumberCond();

    private NoDuplicateNumberCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        List<Integer> numbers = Util.getParsedNumbers(input);
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            uniqueNumbers.add(number);
        }

        return numbers.size() == uniqueNumbers.size();
    }
}
