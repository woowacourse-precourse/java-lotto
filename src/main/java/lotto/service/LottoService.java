package lotto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Score;
import lotto.vo.WinningInfo;

public class LottoService {
	public List<Lotto> createLottos(LottoBuyingInfo lottoBuyingInfo) {
		List<Lotto> result = new ArrayList<>();
		for (int count = 0; count < lottoBuyingInfo.getAmount(); count++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			result.add(new Lotto(numbers));
		}

		return result;
	}

	public ScoreInfo makeScoreInfoBy(List<Lotto> lottos, WinningInfo winningInfo) {
		ScoreInfo scoreInfo = new ScoreInfo();
		for (Lotto lotto : lottos) {
			calculateRank(lotto, winningInfo, scoreInfo);
		}
		return scoreInfo;
	}

	public Double calculateProfitBy(LottoBuyingInfo lottoBuyingInfo, ScoreInfo scoreInfo) {

		double profit = countSumOfPrice(scoreInfo) / lottoBuyingInfo.getMoney();
		profit = convertToPercentage(profit);
		profit = roundToFirstDigit(profit);
		return profit;
	}

	private double countSumOfPrice(ScoreInfo scoreInfo) {
		return Arrays.stream(Score.values())
				.mapToDouble(score -> score.getPrice() * scoreInfo.get(score))
				.sum();
	}


	public void calculateRank(Lotto lotto, WinningInfo winningInfo, ScoreInfo scoreInfo) {
		int matchCount = getMatchCount(lotto, winningInfo);

		if (matchCount == 6) {
			scoreInfo.addScore(Score.FIRST);
		} else if (matchCount == 5) {
			if (isBonusMatching(lotto, winningInfo)) {
				scoreInfo.addScore(Score.SECOND);
				return;
			}
			scoreInfo.addScore(Score.THIRD);
		} else if (matchCount == 4) {
			scoreInfo.addScore(Score.FORTH);
		} else if (matchCount == 3) {
			scoreInfo.addScore(Score.FIFTH);
		}
	}

	private static int getMatchCount(Lotto lotto, WinningInfo winningInfo) {
		return (int) lotto.getNumbers()
				.stream()
				.filter(number -> winningInfo.contains(number))
				.count();
	}

	private boolean isBonusMatching(Lotto lotto, WinningInfo winningInfo) {
		return lotto.contains(winningInfo.getBonus());
	}

	private double convertToPercentage(double profit) {
		return profit * 100;
	}

	private double roundToFirstDigit(double profit) {
		return Math.round(profit * 10) / 10.0;
	}
}
