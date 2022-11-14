package lotto.system;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoApplication {
	protected LottoController lottoController;
	protected LottoService lottoService;
	protected InputView inputView;
	protected OutputView outputView;

	public void run() {
		injectDependencies();
		try {
			lottoController.runLotto();
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
		}
	}

	protected void injectDependencies() {
		inputView = new InputViewImpl();
		outputView = new OutputViewImpl();
		lottoService = new LottoServiceImpl();
		lottoController = new LottoController(inputView, outputView, lottoService);
	}
}
