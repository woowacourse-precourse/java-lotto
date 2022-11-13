package lotto.view;

import java.util.List;

public class OutputView {

    public void buyLottoPrint(int lotteryCount) {
        System.out.println(lotteryCount + ViewMessage.OUTPUT_BUY_LOTTO.getMessage());
    }

    public void LottoPrint(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
