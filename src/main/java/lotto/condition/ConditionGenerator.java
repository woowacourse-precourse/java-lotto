package lotto.condition;

import lotto.condition.lottonumber.IsAllNumberInRangeCond;
import lotto.condition.lottonumber.NoDuplicateNumberCond;
import lotto.condition.lottonumber.RightFormatCond;
import lotto.condition.money.IsAllNumberCond;
import lotto.condition.money.MoneyDivisionCond;

import java.util.List;

public class ConditionGenerator {

    public static List<Condition> getMoneyCondition() {
        return List.of(
                IsAllNumberCond.getInstance(),
                MoneyDivisionCond.getInstance()
        );
    }

    public static List<Condition> getLottoNumberCondition() {
        return List.of(
                RightFormatCond.getInstance(),
                IsAllNumberInRangeCond.getInstance(),
                NoDuplicateNumberCond.getInstance()
        );
    }

    public static List<Condition> getBonusNumberCondition() {
        return List.of(
                IsAllNumberInRangeCond.getInstance(),
                NoDuplicateNumberCond.getInstance()
        );
    }
}
