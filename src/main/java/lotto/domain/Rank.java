package lotto.domain;

import java.util.List;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private final int hitNumberCount;
	private final int prizeMoney;

	Rank(int hitNumberCount, int prizeMoney) {
		this.hitNumberCount = hitNumberCount;
		this.prizeMoney = prizeMoney;
	}

	public static Rank of(int hitNumberCount, boolean isContainsBonusNumber) {
		if (isSecond(hitNumberCount, isContainsBonusNumber)) {
			return SECOND;
		}

		List<Rank> rankList = List.of(MISS, FIFTH, FOURTH, THIRD, FIRST);
		return rankList.get(convertIndex(hitNumberCount));
	}

	public int getHitNumberCount() {
		return hitNumberCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public String getPrizeMoneyWithComma() {
		String money = Integer.toString(prizeMoney);
		return money.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
	}

	private static boolean isSecond(int hitNumberCount, boolean isContainsBonusNumber) {
		return isContainsBonusNumber && SECOND.hitNumberCount == hitNumberCount;
	}

	private static int convertIndex(int hitNumberCount) {
		if (hitNumberCount < 3) {
			return 0;
		}
		return hitNumberCount - 2;
	}

}
