package lotto.condition.lottonumber;

import lotto.condition.Condition;

import java.util.List;

import static lotto.Utils.SEPERATOR;
import static lotto.domain.lottomachine.LottoMachine.NUMBER_RANGE_BOT;
import static lotto.domain.lottomachine.LottoMachine.NUMBER_RANGE_TOP;

public class IsAllNumberInRangeCond implements Condition {

    private static final Condition instance = new IsAllNumberInRangeCond();
    private static final String ERROR_MESSAGE = "1이상 45이하의 숫자를 입력해 주세요";
    private static final Integer SINGLE_DIGIT = 0;

    private IsAllNumberInRangeCond() {
    }

    public static Condition getInstance() {
        return instance;
    }

    @Override
    public Boolean isSatisfied(String input) {
        String[] chunks = input.split(SEPERATOR);

        for (String chunk : chunks) {
            List<String> numbers = List.of(chunk.split(""));

            if (!isAllDigit(numbers) || !isInRange(Integer.parseInt(chunk))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }

    private Boolean isAllDigit(List<String> digits) {
        return digits.stream().allMatch((String number) -> Character.isDigit(number.charAt(SINGLE_DIGIT)));
    }

    private Boolean isInRange(Integer number) {
        return NUMBER_RANGE_BOT <= number && number <= NUMBER_RANGE_TOP;
    }
}
