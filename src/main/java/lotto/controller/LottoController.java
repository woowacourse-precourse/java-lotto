package lotto.controller;

import lotto.system.holder.ConverterHolder;
import lotto.view.InputView;
import lotto.vo.LottoAmount;

public class LottoController {
	private final InputView inputView;

	public LottoController(InputView inputView) {
		this.inputView = inputView;
	}

	public void runLotto() {
		String money = inputView.getMoney();
		LottoAmount lottoAmount = ConverterHolder.convert(money, LottoAmount.class);
	}
}
