package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Constant.Message;
import lotto.Constant.Result;
import lotto.Model.Lotto;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printLotto(final List<Lotto> number) {
        printMessage("\n" + number.size() + Message.BUY_AMOUNT.getMessage());
        number.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResult(Map<String, Integer> savedResult) {
        printMessage("\n"+"당첨 통계");
        printMessage("---");
        for(Result key : Result.values()) {
            key.printResult(savedResult.getOrDefault(key.getMatchNumber(), 0));
        }
    }
}
