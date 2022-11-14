package lotto.controller;

import java.util.List;

import lotto.domain.LottoGroup;
import lotto.domain.Rank;
import lotto.handler.CheckHandler;
import lotto.handler.InputHandler;
import lotto.service.LottoService;

public class LottoController {

	private final LottoService lottoService = LottoService.getInstance();

	public void run() {
		try {
			LottoGroup lottoGroup = makeLottoGroup();
			int purchaseLottoCount = lottoGroup.getLottosSize();
			System.out.println();
			List<Rank> ranks = lottoGroup.winningStatistics(
				lottoService.makeWinnerLotto(InputHandler.inputLottoWinningNumber()),
				lottoService.makeWinnerBonusNumber(InputHandler.inputLottoWinningBonusNumber()));
			lottoService.sumStatistics(ranks);
			lottoService.calculatorYield(ranks, purchaseLottoCount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
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
