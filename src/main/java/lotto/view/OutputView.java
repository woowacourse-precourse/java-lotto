package lotto.view;

import java.util.Map;
import lotto.domian.User;
import lotto.domian.WinningCriteria.WinningCriteriaInfo;
import static lotto.constant.Constant.*;


public class OutputView {
    public void printBuyingPriceQuestion() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
    public void printUserLottoQuantity(long lottoQuantity) {
        System.out.println();
        System.out.println(lottoQuantity + "개를 구매했습니다.");
    }
}
