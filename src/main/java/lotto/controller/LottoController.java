package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.handler.CheckHandler;
import lotto.handler.InputHandler;
import lotto.service.LottoService;

public class LottoController {

	private final LottoService lottoService = LottoService.getInstance();

	public void run() {
		LottoGroup lottoGroup = makeLottoGroup();
		Lotto winnerLotto = makeWinnerLotto();
	}

	private Lotto makeWinnerLotto() {
		return lottoService.makeWinnerLotto();
	}

	private LottoGroup makeLottoGroup() {
		String purchaseQuantity = InputHandler.inputPurchaseQuantity();
		possiblePurchase(purchaseQuantity);
		System.out.println();
		return lottoService.makeLottoGroup(Integer.parseInt(purchaseQuantity) / 1000);
	}

	private void possiblePurchase(String purchaseQuantity) {
		CheckHandler.isNumber(purchaseQuantity);
		CheckHandler.isRest(Integer.parseInt(purchaseQuantity));
	}

}
