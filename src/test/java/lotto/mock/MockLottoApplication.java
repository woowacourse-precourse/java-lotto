package lotto.mock;

import lotto.service.LottoServiceImpl;
import lotto.system.LottoApplication;
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;

public class MockLottoApplication extends LottoApplication {
    @Override
    protected void injectDependencies() {
        inputView = new InputViewImpl();
        outputView = new OutputViewImpl();
        lottoService = new LottoServiceImpl();
        lottoController = new MockLottoController(inputView, outputView, lottoService);
    }
}
