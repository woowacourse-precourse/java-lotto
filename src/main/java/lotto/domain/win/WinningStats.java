package lotto.domain.win;

import static lotto.util.constant.Constant.ENTER;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoComparator;
import lotto.domain.machine.LottoMachine;
import lotto.domain.person.Person;

public class WinningStats {


	private static final String PRINT_FORMAT = "%d개 일치 (%d원) - %d개" + ENTER;
	private static final String SECOND_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개" + ENTER;
	private static final String TOTAL_EARNING_RATE_MESSAGE = "총 수익률은 %.1f";
	private static final String PRINT_WINNING_HEADER = "당첨 통계" + ENTER + "---";

	Person person;
	LottoMachine lottoMachine;
	LottoComparator lottoComparator;
	WinningInfo winningInfo;

	long winningTotalMoney;


	public WinningStats(Person person, LottoMachine lottoMachine) {
		this.person = person;
		this.lottoMachine = lottoMachine;
		this.lottoComparator = new LottoComparator(lottoMachine);
		this.winningInfo = new WinningInfo();
		updateWinningInfo();
	}

	public void printWinningStats() {
		System.out.println(PRINT_WINNING_HEADER);
		Map<Winning, Integer> winnings = winningInfo.getWinnings();
		for (Winning winning : winnings.keySet()) {
			if (winning == Winning.NOTHING) {
				continue;
			}
			addWinningMoney(winning.getMoney(), winnings.get(winning));
			if (winning == Winning.SECOND) {
				System.out.printf(SECOND_PRINT_FORMAT, winning.getMatchCount(), winning.getMoney(),
						winnings.get(winning));
				continue;
			}
			System.out.printf(PRINT_FORMAT, winning.getMatchCount(), winning.getMoney(),
					winnings.get(winning));
		}
		getRate();
	}

	public void addWinningMoney(long money, int count) {
		winningTotalMoney += (money * count);
	}

	public void getRate() {
		double rate = (winningTotalMoney / (double) person.getMoney()) * 100;
		System.out.printf(TOTAL_EARNING_RATE_MESSAGE, rate);
		System.out.println("%입니다.");
	}

	public void updateWinningInfo() {
		List<Lotto> lottos = person.getLottos();
		for (int i = 0; i < lottos.size(); i++) {
			Lotto lotto = lottos.get(i);
			int matchCount = lottoComparator.getMatchCount(lotto);
			boolean containsBonusNumber = lottoComparator.hasBonusNumber(lotto);
			Winning winning = Winning.getWinning(matchCount, containsBonusNumber);
			winningInfo.update(winning);
		}
	}

}
