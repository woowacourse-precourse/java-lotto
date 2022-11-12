package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
	private static final String NO_WIN = "noWin";
	private final HashMap<String, Integer> prizeResult;
	private final List<List<Integer>> lottoTickets;
	private final List<Integer> winningNumber;
	private final int bonusNumber;
	private long winResult = 0;

	public LottoResult(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
		this.lottoTickets = lottoTickets;
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
		prizeResult = new HashMap<>() {{
			put("winThree", 0);
			put("winFour", 0);
			put("winFive", 0);
			put("winFiveBonus", 0);
			put("winSix", 0);
		}};
	}

	public double calculateRateReturn(int userMoney) {
		calculatePrizeMoney();
		return (double)winResult / userMoney * 100;
	}

	private void calculatePrizeMoney() {
		for (List<Integer> lottoTicket : lottoTickets) {
			int winCount = (int)winningNumber.stream().filter(lottoTicket::contains).count();
			LottoRanking lottoRanking = LottoRanking.findLottoRank(winCount, lottoTicket.contains(bonusNumber));
			winResult += lottoRanking.getPrizeMoney();
			updatePrizeResult(lottoRanking.name());
		}
	}

	private void updatePrizeResult(String prize) {
		if (!prize.equals(NO_WIN)) {
			prizeResult.put(prize, prizeResult.get(prize) + 1);
		}
	}

	public HashMap<String, Integer> getPrizeResult() {
		return prizeResult;
	}
}
