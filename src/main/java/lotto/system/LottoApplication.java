package lotto.system;

import java.util.List;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.system.converter.StringToLottoAmountConverter;
import lotto.system.converter.WinningDtoToWinningConverter;
import lotto.system.holder.ConverterHolder;
import lotto.system.holder.ValidationHolder;
import lotto.system.validator.IntegerListToLottoValidator;
import lotto.system.validator.StringToLottoAmountValidator;
import lotto.system.validator.WinningDtoToWinningValidator;
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

	private void initializeValidators() {
		ValidationHolder.initializeValidators(List.of(
				new StringToLottoAmountValidator(),
				new IntegerListToLottoValidator(),
				new WinningDtoToWinningValidator()
		));
		ConverterHolder.initializeConverters(List.of(
				new StringToLottoAmountConverter(),
				new WinningDtoToWinningConverter()
		));
	}

	private void doAfter() {
		ValidationHolder.clearHolder();
		ConverterHolder.clearHolder();
	}
}
