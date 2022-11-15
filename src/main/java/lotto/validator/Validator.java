package lotto.validator;

import lotto.condition.Condition;

import java.util.List;

public class Validator {

    private Validator() {
    }

    public static Condition getNotPassCondition(List<Condition> conditions, String input) {
        for (Condition condition : conditions) {
            if (!condition.isSatisfied(input)) {
                return condition;
            }
        }

        return null;
    }
}
