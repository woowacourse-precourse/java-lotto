package lotto.View;

import java.util.List;
import lotto.Constant.Message;
import lotto.Model.Lotto;

public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    public void printLotto(final List<Lotto> number) {
        printMessage("\n" + number.size() + Message.BUY_AMOUNT.getMessage());
        number.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
