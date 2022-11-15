package lotto.condition.lottonumber;

import lotto.Utils;
import lotto.condition.Condition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoDuplicateNumberCond implements Condition {

    private static final Condition instance = new NoDuplicateNumberCond();
    private static final String ERROR_MESSAGE = "숫자를 중복하여 입력할 수 없습니다";

    private NoDuplicateNumberCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        List<Integer> numbers = Utils.getParsedNumbers(input);
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            uniqueNumbers.add(number);
        }

        return numbers.size() == uniqueNumbers.size();
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
