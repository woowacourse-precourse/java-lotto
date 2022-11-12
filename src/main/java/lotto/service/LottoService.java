package lotto.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoAmount;
import lotto.vo.Winning;

public class LottoService {
	public List<Lotto> createLottos(LottoAmount lottoAmount) {
		List<Lotto> result = new ArrayList<>();
		for (int count = 0; count < lottoAmount.getAmount(); count++) {
			List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			result.add(new Lotto(numbers));
		}

		return result;
	}

	public ScoreInfo makeScoreInfoBy(List<Lotto> lottos, Winning winning) {
		ScoreInfo scoreInfo = new ScoreInfo();
		for (Lotto lotto : lottos) {
			scoreInfo.calculateRank(lotto, winning);
		}
		return scoreInfo;
	}
}
