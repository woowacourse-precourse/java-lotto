package lotto.view;

import java.util.List;

import static lotto.service.WinningHistory.*;
import static lotto.view.ViewWinningMessage.*;

public class OutputView {

    public void buyLottoPrint(int lotteryCount) {
        System.out.println(lotteryCount + ViewMessage.OUTPUT_BUY_LOTTO.getMessage());
    }

    public void LottoPrint(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void winningHistoryPrint() {
        System.out.println(FIFTH_PLACE_QUANTITY.getMessage(FIFTH_PLACE.getQuantity()));
        System.out.println(FOURTH_PLACE_QUANTITY.getMessage(FOURTH_PLACE.getQuantity()));
        System.out.println(THIRD_PLACE_QUANTITY.getMessage(THIRD_PLACE.getQuantity()));
        System.out.println(SECOND_PLACE_QUANTITY.getMessage(SECOND_PLACE.getQuantity()));
        System.out.println(FIRST_PLACE_QUANTITY.getMessage(FIRST_PLACE.getQuantity()));
    }

    public void lottoQuantityPrint(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void totalLottoNumbersPrint() {
        System.out.println();
    }
}
