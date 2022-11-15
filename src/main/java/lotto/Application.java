package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoInput;
import lotto.domain.LottoLogic;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        UI lottoUI = new UI();
        String lottoMoneyInput = UI.LottoInputMoney();

        LottoLogic lottoLogic = new LottoLogic();

        lottoLogic.logic(lottoMoneyInput);

    }
}
