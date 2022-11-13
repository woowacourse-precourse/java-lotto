package lotto.service;

import static lotto.restrict.RestrictConstants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoRankStatus;
import lotto.domain.WinningLotto;

public class LottoService {

	private int matchCount;
	private int bonusMatchCount;

	public Lotto makeLotto() {
		List<Integer> randomLottoNumbers = new ArrayList<>(makeRandomLottoNumbers());

		Collections.sort(randomLottoNumbers);
		return new Lotto(randomLottoNumbers);
	}

	public LottoRankStatus determineLottoRankStatus(Lotto lotto, WinningLotto winningLotto) {
		if (lotto == null || winningLotto == null) {
			return null;
		}
		List<Integer> winningLottoNumbers = winningLotto.getNumbers();
		List<Integer> winningLottoBonusNumbers = winningLotto.getBonusNumbers();
		matchCount = compare(lotto, winningLottoNumbers);
		bonusMatchCount = compare(lotto, winningLottoBonusNumbers);
		return determineOverFifthRank();
	}

	private List<Integer> makeRandomLottoNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LIMIT_SIZE);
	}

	private LottoRankStatus determineOverFifthRank() {
		if (matchCount == FIFTH_RANK_CONDITION) {
			return LottoRankStatus.FIFTH_RANK;
		}
		if (matchCount == FOURTH_RANK_CONDITION) {
			return LottoRankStatus.FOURTH_RANK;
		}
		if (matchCount == THIRD_RANK_CONDITION && bonusMatchCount != SECOND_RANK_BONUS_CONDITION) {
			return LottoRankStatus.THIRD_RANK;
		}
		return determineOverSecondRank();
	}

	private LottoRankStatus determineOverSecondRank() {
		if (matchCount == SECOND_RANK_CONDITION && bonusMatchCount == SECOND_RANK_BONUS_CONDITION) {
			return LottoRankStatus.SECOND_RANK;
		}
		if (matchCount == FIRST_RANK_CONDITION) {
			return LottoRankStatus.FIRST_RANK;
		}
		return LottoRankStatus.OUT_OF_RANK;
	}

	private int compare(Lotto lotto, List<Integer> numbers) {
		int containCount = 0;
		List<Integer> lottoNumbers = lotto.getNumbers();

		for (int lottoNumber : lottoNumbers) {
			if (numbers.contains(lottoNumber)) {
				containCount += 1;
			}
		}
		return containCount;
	}
}
