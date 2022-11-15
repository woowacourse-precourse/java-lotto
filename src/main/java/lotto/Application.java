package lotto;

import lotto.controller.LottoSystemController;
import lotto.domain.cashier.CashierImpl;
import lotto.domain.lotto.lottocompany.LottoCompanyImpl;
import lotto.domain.lotto.lottocompany.LottoMachineImpl;
import lotto.view.input.InputImpl;
import lotto.view.output.OutputImpl;

public class Application {

    public static void main(String[] args) {
        LottoSystemController lottoSystemController = new LottoSystemController(new InputImpl(), new OutputImpl(),
                new CashierImpl(),
                new LottoCompanyImpl(new LottoMachineImpl()));

        lottoSystemController.runLottoSystem();
    }
}
