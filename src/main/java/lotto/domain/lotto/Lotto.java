package lotto.domain.lotto;

import lotto.Util;
import lotto.condition.Condition;
import lotto.condition.ConditionGenerator;
import lotto.validator.Validator;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers + "";
    }

    public static Lotto numberOf(List<Integer> numbers) {
        List<Condition> conditions = ConditionGenerator.getLottoCreationCond();
        String number = Util.getConcatenatedString(numbers);

        Condition notPassCondition = Validator.getNotPassCondition(conditions, number);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(notPassCondition.getErrorMessage());
        }

        return new Lotto(numbers);
    }
}
