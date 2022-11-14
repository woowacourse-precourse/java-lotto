package lotto.condition.lottonumber;

import lotto.condition.Condition;

import java.util.List;

import static lotto.LottoMachine.NUMBER_RANGE_BOT;
import static lotto.LottoMachine.NUMBER_RANGE_TOP;

public class IsAllNumberInRangeCond implements Condition {

    private static final Condition instance = new IsAllNumberInRangeCond();
    private static final Integer SINGLE_DIGIT = 0;

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        String[] chunks = input.split(",");

        for (String chunk : chunks) {
            List<String> numbers = List.of(chunk.split(""));

            if (!isDigit(numbers) || !isInRange(Integer.parseInt(chunk))) {
                return false;
            }
        }

        return true;
    }

    private Boolean isDigit(List<String> digits) {
        return digits.stream().allMatch((String number) -> Character.isDigit(number.charAt(SINGLE_DIGIT)));
    }

    private Boolean isInRange(Integer number) {
        return NUMBER_RANGE_BOT <= number && number <= NUMBER_RANGE_TOP;
    }
}
