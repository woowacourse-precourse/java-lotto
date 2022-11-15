package lotto.validator;

import lotto.condition.Condition;

import java.util.List;

public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public Condition getNotPassCondition(List<Condition> conditions, String input) {
        for (Condition condition : conditions) {
            if (!condition.isSatisfied(input)) {
                return condition;
            }
        }

        return null;
    }
}
