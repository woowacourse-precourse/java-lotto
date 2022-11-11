package lotto.service;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.Rank;
import lotto.handler.CheckHandler;
import lotto.handler.InputHandler;
import lotto.repository.LottoRepository;
import lotto.view.WinningStatisticsView;

public class LottoService {

	private static final LottoService instance = new LottoService();

	private LottoService() {
	}

	public static LottoService getInstance() {
		return instance;
	}

	private final LottoRepository lottoRepository = LottoRepository.getInstance();

	public LottoGroup makeLottoGroup(int purchaseQuantity) {
		List<Lotto> lottos = new ArrayList<>();
		for (int purchaseCount = 0; purchaseCount < purchaseQuantity; purchaseCount++) {
			lottos.add(lottoRepository.makeAutoLotto());
		}
		return new LottoGroup(lottos);
	}

	public Lotto makeWinnerLotto() {
		String inputLottoWinningNumber = InputHandler.inputLottoWinningNumber();
		CheckHandler.isLotto(inputLottoWinningNumber);
		List<Integer> lottoNumbers = lottoRepository.makeWinnerLotto(inputLottoWinningNumber);
		return new Lotto(lottoNumbers);
	}

	public int makeWinnerBonusNumber() {
		String bonusNumber = InputHandler.inputLottoWinningBonusNumber();
		CheckHandler.isNumber(bonusNumber);
		CheckHandler.isLottoNumber(bonusNumber);
		return Integer.parseInt(bonusNumber);
	}

	public void sumStatistics(List<Rank> ranks) {
		int[] rankArray = new int[6];
		for (Rank rank : ranks) {
			rankArray[rank.getRank() - 1]++;
		}
		WinningStatisticsView.printStatistics(rankArray);
	}

	public void calculatorYield(List<Rank> ranks, int purchaseLottoCount) {
		long price = 0;
		for (Rank rank : ranks) {
			price += rank.getPrice();
		}
		WinningStatisticsView.printYield(((double)price / (double)(purchaseLottoCount * 1000L)) * 100 - 100);
	}
}
