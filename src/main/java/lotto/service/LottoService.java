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
			scoreInfo.calculateRank(lotto, winningInfo);
		}
		return scoreInfo;
	}

	public Double calculateProfitBy(LottoBuyingInfo lottoBuyingInfo, ScoreInfo scoreInfo) {
		double sumOfPrice = Arrays.stream(Score.values())
				.mapToDouble(score -> score.getPrice() * scoreInfo.get(score))
				.sum();

		double profit = sumOfPrice / lottoBuyingInfo.getMoney();
		profit = convertToPercentage(profit);
		profit = roundToFirstDigit(profit);
		return profit;
	}

	private double convertToPercentage(double profit) {
		return profit * 100;
	}

	private double roundToFirstDigit(double profit) {
		return Math.round(profit * 10) / 10.0;
	}
}
