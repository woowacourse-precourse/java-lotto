package lotto.userinterface;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.MessageGenerator;
import lotto.Util;
import lotto.condition.Condition;
import lotto.condition.lottonumber.IsAllNumberInRangeCond;
import lotto.condition.lottonumber.NoDuplicateNumberCond;
import lotto.condition.lottonumber.RightFormatCond;
import lotto.condition.money.MinimumMoneyCond;
import lotto.condition.money.MoneyDivisionCond;
import lotto.validator.Validator;

import java.util.List;

public class UserInterface {

    private static final Validator validator = Validator.getInstance();

    private UserInterface() {
    }

    public static List<Integer> getLottoNumbers() {
        String input = getInput();

        List<Condition> conditions = List.of(
                RightFormatCond.getInstance(),
                IsAllNumberInRangeCond.getInstance(),
                NoDuplicateNumberCond.getInstance()
        );

        Integer notPassConditionIndex = validator.getNotPassConditionIndex(conditions, input);

        if (notPassConditionIndex != -1) {
            Condition notPassCondition = conditions.get(notPassConditionIndex);
            throw new IllegalArgumentException();
        }

        return Util.getParsedNumbers(input);
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
