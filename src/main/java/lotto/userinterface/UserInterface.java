package lotto.userinterface;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.MessageGenerator;
import lotto.condition.Condition;
import lotto.condition.MinimumMoneyCond;
import lotto.condition.MoneyDivisionCond;
import lotto.condition.lottonumber.RightFormatCond;
import lotto.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {

    private static final Validator validator = Validator.getInstance();

    private UserInterface() {
    }

    public static List<Integer> getLottoNumbers() {
        String input = getInput();

        List<Condition> conditions = List.of(
                RightFormatCond.getInstance()
                IsAllNumberCond.getInstance(),
                // NoDuplicateNumberCond.getInstance(),
                // InRangeCond.getInstance()
        );

        Integer notPassConditionIndex = validator.getNotPassConditionIndex(conditions, input);

        if (notPassConditionIndex != -1) {
            Condition notPassCondition = conditions.get(notPassConditionIndex);
            throw new IllegalArgumentException();
        }

        return getParsedNumbers(input);
    }

    private static List<Integer> getParsedNumbers(String input) {
        return Arrays.stream(input.split(",")).map(((String s) -> Integer.parseInt(s))).collect(Collectors.toList());
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

    public static void printLottos(List<Lotto> lottos) {
        String purchaseCountMessage = MessageGenerator.getPurchaseCountMessage(lottos.size());
        System.out.println(purchaseCountMessage);

        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
