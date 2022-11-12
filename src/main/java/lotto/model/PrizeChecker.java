package lotto.model;


import java.util.List;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class PrizeChecker {

	private final Map<LottoRanking, Integer> prizeResult = new EnumMap<>(LottoRanking.class);
	private final int prizeMoney;

	public PrizeChecker(LottoCompany lottoCompany, List<Lotto> lottoBundle) {
		List<Integer> winningNumber = lottoCompany.getWinningNumber();
		int bonusNumber = lottoCompany.getBonusNumber();

		for (Lotto lotto : lottoBundle) {
			List<Integer> lottoNumber = lotto.getNumbers();
			int countMatch = countingMatch(winningNumber, lottoNumber);
			countMatch = checkBonus(countMatch, lottoNumber, bonusNumber);

			LottoRanking lottoRanking = LottoRanking.findByLottoRanking(countMatch);
			prizeResult.put(lottoRanking, prizeResult.getOrDefault(lottoRanking, 0) + 1);
		}
		this.prizeMoney = sumPrize();
	}

	private int countingMatch(List<Integer> lotto, List<Integer> winningNumber) {
		return (int) lotto.stream()
			.filter(number -> winningNumber.stream().anyMatch(Predicate.isEqual(number)))
			.count();
	}

	private int checkBonus(int countMatch, List<Integer> lotto, int bonusNumber) {
		if (countMatch == 5 && hasBonus(lotto, bonusNumber)) {
			return LottoRanking.SECOND_RANKING;
		}
		return countMatch;
	}

	private boolean hasBonus(List<Integer> lotto, int bonusNumber) {
		return lotto.stream().anyMatch(number -> number.equals(bonusNumber));
	}

	private int sumPrize() {
		int totalPrizeMoney = 0;
		for (Entry<LottoRanking, Integer> ranking : prizeResult.entrySet()) {
			totalPrizeMoney += ranking.getKey().getReward() * ranking.getValue();
		}
		return totalPrizeMoney;
	}

	public double calculationYield(int lottocost) {
		return (prizeMoney / (double) lottocost) * 100;
	}

	public Map<LottoRanking, Integer> getPrizeResult() {
		return prizeResult;
	}
}
