package lotto.view;

import java.util.List;

public class OutputView {

    public void buyLottoPrint(int unit) {
        System.out.println(unit + ViewMessage.OUTPUT_BUY_LOTTO.getMessage());
    }

    public void LottoPrint(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
