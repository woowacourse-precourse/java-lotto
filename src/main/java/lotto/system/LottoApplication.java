package lotto.system;

import java.util.List;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.system.holder.ValidationHolder;
import lotto.system.validator.IntegerListToLottoValidator;
import lotto.system.validator.IntegerToLottoBuyingInfoValidator;
import lotto.system.validator.StringToLottoBuyingInfoValidator;
import lotto.system.validator.WinningDtoToWinningInfoValidator;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoApplication {
	private LottoController lottoController;
	private LottoService lottoService;
	private InputView inputView;
	private OutputView outputView;

	public void run() {
		doSetting();
		try {
			lottoController.runLotto();
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
		}
		doAfter();
	}

	private void doSetting() {
		inputView = new InputViewImpl();
		outputView = new OutputViewImpl();
		lottoService = new LottoService();
		lottoController = new LottoController(inputView, outputView, lottoService);
		initializeValidators();
	}

	public static void initializeValidators() {
		ValidationHolder.initializeValidators(List.of(
				new StringToLottoBuyingInfoValidator(),
				new IntegerToLottoBuyingInfoValidator(),
				new IntegerListToLottoValidator(),
				new WinningDtoToWinningInfoValidator()
		));
	}

	public static void doAfter() {
		ValidationHolder.clearHolder();
	}
}
