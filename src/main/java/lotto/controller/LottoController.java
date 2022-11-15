package lotto.controller;

import lotto.domain.Count;
import lotto.domain.EarningsRate;
import lotto.domain.Grade;
import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import lotto.domain.LottoTickets;
import lotto.domain.Stat;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void run() {
		try {
			LottoTickets lottoTickets = perchaseLottoTickets();
			Lotto lotto = new Lotto(LottoNumbersGenerator.generate(InputView.lottoNumbers()));
			LottoBonus lottoBonus = new LottoBonus(LottoBonusGenerator.generate(InputView.bonusNumber()),
				lotto.getNumbers());

			Stat stat = getStat(lottoTickets, lotto, lottoBonus);
			OutputView.printLottoStat(stat.getStat());

			EarningsRate earningsRate = new EarningsRate(stat.getStat(), lottoTickets.getLottoTickets());
			OutputView.printEarningsRate(earningsRate.getEarningsRate());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Stat getStat(LottoTickets lottoTickets, Lotto lotto, LottoBonus lottoBonus) {
		Count count = new Count(lotto, lottoBonus, lottoTickets);
		Grade grade = new Grade(count.getCount());
		Stat stat = new Stat(grade.getGrade());
		return stat;
	}

	private static LottoTickets perchaseLottoTickets() {
		LottoTickets lottoTickets = new LottoTickets(InputView.purchaseLotto());
		OutputView.printLottoTickets(lottoTickets.getLottoTickets());
		return lottoTickets;
	}
}
