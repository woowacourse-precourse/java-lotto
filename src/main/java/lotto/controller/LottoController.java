package lotto.controller;

import java.util.List;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.system.holder.ConverterHolder;
import lotto.view.InputView;
import lotto.vo.LottoAmount;

public class LottoController {
	private final InputView inputView;
	private final LottoService lottoService;

	public LottoController(InputView inputView, LottoService lottoService) {
		this.inputView = inputView;
		this.lottoService = lottoService;
	}

	public void runLotto() {
		String money = inputView.getMoney();
		LottoAmount lottoAmount = ConverterHolder.convert(money, LottoAmount.class);
		List<Lotto> lottos = lottoService.createLottos(lottoAmount);
	}
}
