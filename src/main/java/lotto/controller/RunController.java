package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoStatistics;
import lotto.domain.Salesman;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class RunController {

	public void run() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		try {
			int purchaseBudget = inputPurchaseBudget(inputView, outputView);
			List<Lotto> lottos = purchaseLottos(outputView, purchaseBudget);
			WinningNumber winningNumber = inputWinningNumber(inputView, outputView);
			printStatistics(outputView, lottos, winningNumber);
		} catch (IllegalArgumentException error) {
			outputView.printErrorMessage(error.getMessage());
		}
	}

	private int inputPurchaseBudget(InputView inputView, OutputView outputView) {
		int purchaseBudget = inputView.inputBudget();
		outputView.printNewLine();
		return purchaseBudget;
	}

	private List<Lotto> purchaseLottos(OutputView outputView, int purchaseBudget) {
		Salesman salesman = new Salesman();
		int lottoCount = salesman.sellLotto(purchaseBudget);
		List<Lotto> lottos = LotteryMachine.autoGenerate(lottoCount);
		outputView.printLottoCount(lottoCount);
		outputView.printLottoNumbers(lottos);
		outputView.printNewLine();
		return lottos;
	}

	private WinningNumber inputWinningNumber(InputView inputView, OutputView outputView) {
		Lotto winningLotto = getWinningLotto(inputView, outputView);
		BonusNumber bonusNumber = getBonusNumber(inputView, outputView);
		return new WinningNumber(winningLotto, bonusNumber);
	}

	private Lotto getWinningLotto(InputView inputView, OutputView outputView) {
		Lotto winningLotto = new Lotto(inputView.inputWinningNumber());
		outputView.printNewLine();
		return winningLotto;
	}

	private BonusNumber getBonusNumber(InputView inputView, OutputView outputView) {
		BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
		outputView.printNewLine();
		return bonusNumber;
	}

	private void printStatistics(OutputView outputView, List<Lotto> lottos,
		WinningNumber winningNumber) {
		LottoStatistics lottoStatistics = new LottoStatistics(winningNumber);
		Map<LottoRanking, Integer> winningResult = lottoStatistics.getWinningResult(lottos);
		Double yield = lottoStatistics.calculateYield(lottos, winningResult);
		outputView.printStatistics(winningResult, yield);
	}
}
