package lotto;

import lotto.controller.LottoSystemController;
import lotto.domain.cashier.Cashier;
import lotto.domain.cashier.CashierImpl;
import lotto.domain.lotto.lottocompany.LottoCompany;
import lotto.domain.lotto.lottocompany.LottoCompanyImpl;
import lotto.domain.lotto.lottocompany.LottoMachine;
import lotto.domain.lotto.lottocompany.LottoMachineImpl;
import lotto.view.input.Input;
import lotto.view.input.InputImpl;
import lotto.view.output.Output;
import lotto.view.output.OutputImpl;

public class LottoSystemConfig {

    public LottoSystemController lottoSystemController() {
        return new LottoSystemController(input(), output(), cashier(), lottoCompany());
    }

    public Input input() {
        return new InputImpl();
    }

    public Output output() {
        return new OutputImpl();
    }

    public LottoCompany lottoCompany() {
        return new LottoCompanyImpl(lottoMachine());
    }

    public LottoMachine lottoMachine() {
        return new LottoMachineImpl();
    }

    public Cashier cashier() {
        return new CashierImpl();
    }

}
