package lotto.utils;

import lotto.domain.Lotto;

public enum LottoType {
	FIRST(2_000_000_000, 6, 0),
	SECOND(30_000_000, 5, 1),
	THIRD(1_500_000, 5, 0),
	FOURTH(50_000, 4, 0),
	FIFTH(5_000, 3, 0),
	;

	private final int money;
	private final int lottoNumber;
	private final int bonusNumber;

	private LottoType(int money, int lottoNumber, int bonusNumber) {
		this.money = money;
		this.lottoNumber = lottoNumber;
		this.bonusNumber = bonusNumber;
	}

	public int getMoney() {
		return this.money;
	}

	private int getLottoNumber() {
		return this.lottoNumber;
	}

	public static LottoType getType(int lottoNumber, int bonusNumber) {
		for (LottoType lottoType : LottoType.values()) {
			if (compareLottoNumbers(lottoType, lottoNumber, bonusNumber)) {
				return lottoType;
			}
		}
		return null;
	}

	private static Boolean compareLottoNumbers(LottoType lottoType, int lottoNumber, int bonusNumber) {
		if (lottoType.getLottoNumber() == lottoNumber) {
			if (lottoType == LottoType.SECOND && bonusNumber == 0) {
				return false;
			}
			return true;
		}
		return false;
	}
}
