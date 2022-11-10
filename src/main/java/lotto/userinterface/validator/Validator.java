package lotto.userinterface.validator;

import lotto.userinterface.condition.Condition;

import java.util.List;

public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public Integer getNotPassConditionIndex(List<Condition> conditions, String input) {
        for (int index = 0; index < conditions.size(); index++) {
            Condition condition = conditions.get(index);
            if (!condition.isSatisfied(input)) {
                return index;
            }
        }

        return -1;
    }
}
