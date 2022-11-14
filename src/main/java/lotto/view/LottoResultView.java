package lotto.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.type.ConstantNumberType;
import lotto.type.LottoResultType;
import lotto.type.MessageType;
import utils.DecimalFormatter;

public class LottoResultView {

    public LottoResultView() {
    }

    public String stringify(HashMap<LottoResultType, Integer> myResult) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(MessageType.RESULT_HEAD.getMessage());
        Arrays.stream(LottoResultType.values())
                .limit(LottoResultType.values().length-1)
                .map(resultType -> getEachResultMessage(myResult, resultType))
                .forEach(stringJoiner::add);
        stringJoiner.add(getYield(myResult));
        return stringJoiner.toString();
    }

    private String getEachResultMessage(HashMap<LottoResultType, Integer> myResult, LottoResultType resultType) {
        int count = myResult.getOrDefault(resultType, 0);
        return String.format(resultType.getViewMessage(), count);
    }

    private String getYield(HashMap<LottoResultType, Integer> myResult) {
        AtomicInteger earned = new AtomicInteger();
        AtomicInteger spent = new AtomicInteger();
        int cost = ConstantNumberType.COST.getValue();
        myResult.forEach((key, value) -> {
            int count = value;
            int money = key.getAmount();
            earned.addAndGet(money * count);
            spent.addAndGet(cost * count);
        });
        String yield = DecimalFormatter.formatNumber((double) earned.get() / spent.get() * 100);
        return String.format(MessageType.RESULT_YIELD.getMessage(), yield);
    }
}
