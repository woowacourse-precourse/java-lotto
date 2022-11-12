package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.OutputMessage;
import lotto.domain.UserLotto;

public class OutputView {
    public void printQuantity(int quantity) {
        System.out.println(quantity + OutputMessage.PRINT_LOTTO_QUANTITY.toString());
    }
    public void printLottoNumber(UserLotto userLotto) {
        System.out.println(userLotto.toString());
    }
}
