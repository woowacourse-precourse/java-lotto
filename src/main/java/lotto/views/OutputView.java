package lotto.views;

import java.util.List;
import lotto.constants.message.OutputMessage;

public class OutputView {
    private static final int COUNT_OF_LOTTO = 0;
    private static final int BOUGHT_RESULT_MESSAGE = 1;

    public void outputLottoBuyingResult(List<String> resultOfBuyingLotto) {
        System.out.println();
        System.out.println(resultOfBuyingLotto.get(COUNT_OF_LOTTO) + OutputMessage.BOUGHT_MESSAGE);
        System.out.println(resultOfBuyingLotto.get(BOUGHT_RESULT_MESSAGE));
    }
}
