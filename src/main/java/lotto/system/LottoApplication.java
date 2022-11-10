package lotto.system;

import java.util.List;

import lotto.controller.LottoController;
import lotto.system.converter.StringToLottoAmountConverter;
import lotto.system.holder.ConverterHolder;
import lotto.system.holder.ValidationHolder;
import lotto.system.validator.StringToLottoAmountValidator;
import lotto.view.InputView;
import lotto.view.InputViewImpl;

public class LottoApplication {
	private LottoController lottoController;
	private InputView inputView;

	public void run() {
		doSetting();
		lottoController.runLotto();
		doAfter();
	}

	private void doSetting() {
		inputView = new InputViewImpl();
		lottoController = new LottoController(inputView);
		initializeValidators();
	}

	private void initializeValidators() {
		ValidationHolder.initializeValidators(List.of(new StringToLottoAmountValidator()));
		ConverterHolder.initializeConverters(List.of(new StringToLottoAmountConverter()));
	}

	private void doAfter() {
		ValidationHolder.clearHolder();
		ConverterHolder.clearHolder();
	}
}
