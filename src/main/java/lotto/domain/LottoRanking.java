package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
	noWin(0, 0, false),
	winThree(5000, 3, false),
	winFour(50000, 4, false),
	winFive(1500000, 5, false),
	winFiveBonus(30000000, 5, true),
	winSix(2000000000, 6, false);

	private final int prizeMoney;
	private final int winNumber;
	private final boolean matchBonus;

	LottoRanking(int prizeMoney, int winNumber, boolean matchBonus) {
		this.prizeMoney = prizeMoney;
		this.winNumber = winNumber;
		this.matchBonus = matchBonus;
	}

	public static LottoRanking findLottoRank(int winCount, boolean matchBonusNumber) {
		return Arrays.stream(LottoRanking.values())
			.filter(lottoRanking -> checkLottoRank(lottoRanking, winCount, matchBonusNumber))
			.findAny()
			.orElse(noWin);
	}

	private static boolean checkLottoRank(LottoRanking lottoRanking, int winCount, boolean matchBonusNumber) {
		if (lottoRanking.winNumber != winCount) {
			return false;
		}
		if (winFive.winNumber == winCount) {
			return lottoRanking.matchBonus == matchBonusNumber;
		}
		return true;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}
}
