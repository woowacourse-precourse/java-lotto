package lotto.view;

import lotto.service.LottoService;

import static lotto.service.WinningHistory.*;
import static lotto.view.ViewWinningMessage.*;

public class OutputView {
    LottoService lottoService = new LottoService();

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

    public void returnPrint(int quantity) {
        System.out.println("총 수익률은 " + lottoService.getReturn(quantity) + "입니다.");
    }
}
