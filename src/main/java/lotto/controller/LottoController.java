package lotto.controller;

import java.util.List;

import lotto.Lotto;
import lotto.service.LottoService;
import lotto.system.holder.ConverterHolder;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoAmount;

public class LottoController {
	private final InputView inputView;
	private final OutputView outputView;
	private final LottoService lottoService;

	public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoService = lottoService;
	}

	public void runLotto() {
		String money = inputView.getMoney();

		LottoAmount lottoAmount = ConverterHolder.convert(money, LottoAmount.class);
		outputView.printLottoAmount(lottoAmount);

		List<Lotto> lottos = lottoService.createLottos(lottoAmount);
		outputView.printLottos(lottos);
	}
}
