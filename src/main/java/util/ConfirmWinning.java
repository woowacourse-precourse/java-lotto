package util;

import java.util.List;
import java.util.Map;

import dto.IssueLottoInfo;
import dto.Lotto;
import dto.LottoGameInfo;

public class ConfirmWinning {
	LottoGameInfo lottoGameInfo;

	public ConfirmWinning(LottoGameInfo lottoGameInfo) {
		this.lottoGameInfo = lottoGameInfo;
	}

	public void confirmWinning() {

		List<IssueLottoInfo> issueLottos = lottoGameInfo.getIssueLotto();

		for (IssueLottoInfo lotto : issueLottos) {
			Lotto lottoNumber = lotto.getIssueLottoNumber();
			int sameNum = compaerWinningNumber(lottoNumber);
			if (sameNum < 3) {
				sameNum = 0;
			}
			if (sameNum > 2) {
				sameNum = 8 - sameNum;
			}
			if (sameNum == 2) {
				sameNum = 1;
			}
			if (sameNum == 3) {
				sameNum = checkBonus(lottoNumber);
			}

			lotto.setWinningRanking(sameNum);
		}

		countRank();

	}

	private int compaerWinningNumber(Lotto lottoNumber) {
		List<Integer> winningNumber = lottoGameInfo.getWinningNumber().getNumbers();
		int sameCount = 0;

		for (Integer num : lottoNumber.getNumbers()) {
			if (winningNumber.contains(num)) {
				sameCount++;
			}
		}

		return sameCount;
	}

	private int checkBonus(Lotto lottoNumber) {
		if (lottoNumber.getNumbers().contains(lottoGameInfo.getBonusNumber())) {
			return 2;
		}
		return 3;
	}

	private void countRank() {
		List<IssueLottoInfo> issueLottos = lottoGameInfo.getIssueLotto();
		List<Integer> result = lottoGameInfo.getResult();
		for (IssueLottoInfo lotto : issueLottos) {
			int rank = lotto.getWinningRanking();
			if (rank != 0) {
				int cnt = result.get(rank-1)+1;
				result.set(rank-1, cnt);
			}
		}

	}
}
