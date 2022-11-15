package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.Util;
import lotto.condition.Condition;
import lotto.condition.ConditionGenerator;
import lotto.message.ErrorMessageGenerator;
import lotto.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleIn {

    private static final Validator validator = Validator.getInstance();

    private ConsoleIn() {
    }

    public static List<Integer> getLottoNumbers() {
        String input = getInput();
        List<Condition> conditions = ConditionGenerator.getLottoNumberCondition();

        Condition notPassCondition = validator.getNotPassCondition(conditions, input);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(ErrorMessageGenerator.getErrorMessage(notPassCondition));
        }

        return Util.getParsedNumbers(input);
    }


    public static Integer getMoney() {
        String input = getInput();
        List<Condition> conditions = ConditionGenerator.getMoneyCondition();

        Condition notPassCondition = validator.getNotPassCondition(conditions, input);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(ErrorMessageGenerator.getErrorMessage(notPassCondition));
        }

        return Integer.parseInt(input);
    }


    public static Integer getBonusNumber(List<Integer> answerNumbers) {
        String input = getInput();
        List<Condition> conditions = ConditionGenerator.getBonusNumberCondition();

        String numbers = getConcatenatedString(answerNumbers, input);

        Condition notPassCondition = validator.getNotPassCondition(conditions, numbers);

        if (notPassCondition != null) {
            throw new IllegalArgumentException(ErrorMessageGenerator.getErrorMessage(notPassCondition));
        }

        return Integer.parseInt(input);
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static String getConcatenatedString(List<Integer> numbers, String input) {
        return String.join(",", numbers.stream().map((Integer number) -> Integer.toString(number)).collect(Collectors.toList())) + "," + input;
    }
}