package lotto.controller;

import lotto.domain.EarningsRate;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoBonusGenerator;
import lotto.domain.LottoNumbersGenerator;
import lotto.domain.LottoTickets;
import lotto.domain.Stat;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void run() {
		try {
			LottoTickets lottoTickets = new LottoTickets(InputView.purchaseLotto());
			OutputView.printLottoTickets(lottoTickets);
			Lotto lotto = new Lotto(LottoNumbersGenerator.generate(InputView.lottoNumbers()));
			LottoBonus lottoBonus = new LottoBonus(LottoBonusGenerator.generate(InputView.bonusNumber()));
			Stat stat = new Stat(lotto, lottoBonus, lottoTickets);
			EarningsRate earningsRate = new EarningsRate(stat.getStat(), lottoTickets.getLottoTickets());
			OutputView.printLottoStat(stat.getStat());
			OutputView.printEarningsRate(earningsRate.getEarningsRate());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
