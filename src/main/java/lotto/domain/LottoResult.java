package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class LottoResult {
	private static final String NO_WIN = "noWin";
	private static final String WIN_THREE = "winThree";
	private static final String WIN_FOUR = "winFour";
	private static final String WIN_FIVE = "winFive";
	private static final String WIN_FIVE_BONUS = "winFiveBonus";
	private static final String WIN_SIX = "winSix";
	private static final int ZERO_NUMBER = 0;
	private static final int UPDATE_ONE = 1;
	private static final int RATE_MULTIPLE_NUMBER = 100;
	private final HashMap<String, Integer> prizeResult;
	private final List<List<Integer>> lottoTickets;
	private final List<Integer> winningNumber;
	private final int bonusNumber;
	private long winResult = 0;

	public static void main(String[] args) {
	}

	public LottoResult(List<List<Integer>> lottoTickets, List<Integer> winningNumber, int bonusNumber) {
		this.lottoTickets = lottoTickets;
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
		prizeResult = new HashMap<>() {{
			put(WIN_THREE, ZERO_NUMBER);
			put(WIN_FOUR, ZERO_NUMBER);
			put(WIN_FIVE, ZERO_NUMBER);
			put(WIN_FIVE_BONUS, ZERO_NUMBER);
			put(WIN_SIX, ZERO_NUMBER);
		}};
	}

	public double calculateRateReturn(int userMoney) {
		calculatePrizeResult();
		return (double)winResult / userMoney * RATE_MULTIPLE_NUMBER;
	}

	private void calculatePrizeResult() {
		for (List<Integer> lottoTicket : lottoTickets) {
			int winCount = (int)winningNumber.stream().filter(lottoTicket::contains).count();
			LottoRanking lottoRanking = LottoRanking.findLottoRank(winCount, lottoTicket.contains(bonusNumber));
			winResult += lottoRanking.getPrizeMoney();
			updatePrizeCount(lottoRanking.name());
		}
	}

	private void updatePrizeCount(String prize) {
		if (!prize.equals(NO_WIN)) {
			prizeResult.put(prize, prizeResult.get(prize) + UPDATE_ONE);
		}
	}

	public HashMap<String, Integer> getPrizeResult() {
		return prizeResult;
	}
}
