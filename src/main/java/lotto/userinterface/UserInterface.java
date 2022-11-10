package lotto.userinterface;

import camp.nextstep.edu.missionutils.Console;
import lotto.userinterface.condition.Condition;
import lotto.userinterface.condition.MinimumMoneyCond;
import lotto.userinterface.condition.MoneyDivisionCond;
import lotto.userinterface.validator.Validator;

import java.util.List;

public class UserInterface {

    private static final Validator validator = Validator.getInstance();

    private UserInterface() {
    }

    public static Integer getMoney() {
        String input = getInput();

        List<Condition> conditions = List.of(
                MinimumMoneyCond.getInstance(),
                MoneyDivisionCond.getInstance()
        );

        Integer notPassConditionIndex = validator.getNotPassConditionIndex(conditions, input);

        if (notPassConditionIndex != -1) {
            Condition notPassCondition = conditions.get(notPassConditionIndex);
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    private static String getInput() {
        return Console.readLine();
    }
}
