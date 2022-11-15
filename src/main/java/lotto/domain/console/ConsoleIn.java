package lotto.domain.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.Util;
import lotto.condition.Condition;
import lotto.condition.ConditionGenerator;
import lotto.message.ErrorMessageGenerator;
import lotto.validator.Validator;

import java.util.List;

public class ConsoleIn {

    private ConsoleIn() {
    }

    public static List<Integer> getLottoNumbers() {
        String input = getInput();
        List<Condition> conditions = ConditionGenerator.getLottoNumberCondition();

        Condition notPassCondition = Validator.getNotPassCondition(conditions, input);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(ErrorMessageGenerator.getErrorMessage(notPassCondition));
        }

        return Util.getParsedNumbers(input);
    }


    public static Integer getMoney() {
        String input = getInput();
        List<Condition> conditions = ConditionGenerator.getMoneyCondition();

        Condition notPassCondition = Validator.getNotPassCondition(conditions, input);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(ErrorMessageGenerator.getErrorMessage(notPassCondition));
        }

        return Integer.parseInt(input);
    }


    public static Integer getBonusNumber(List<Integer> answerNumbers) {
        String input = getInput();
        List<Condition> conditions = ConditionGenerator.getBonusNumberCondition();

        String numbers = Util.getConcatenatedString(answerNumbers) + "," + input;

        Condition notPassCondition = Validator.getNotPassCondition(conditions, numbers);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(ErrorMessageGenerator.getErrorMessage(notPassCondition));
        }

        return Integer.parseInt(input);
    }

    private static String getInput() {
        return Console.readLine();
    }
}