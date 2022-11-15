package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Grade {
	private List<LottoType> grade;

	public Grade(List<Map<String, Integer>> count) {
		grade = new ArrayList<>();
		for (Map<String, Integer> ticket : count) {
			grade.add(getType(ticket.get("lotto"), ticket.get("bonus")));
		}
	}

	public List<LottoType> getGrade() {
		return this.grade;
	}

	private LottoType getType(int lottoNumber, int bonusNumber) {
		for (LottoType lottoType : LottoType.values()) {
			if (compareLottoNumbers(lottoType, lottoNumber, bonusNumber)) {
				return lottoType;
			}
		}
		return LottoType.FAIL;
	}

	private Boolean compareLottoNumbers(LottoType lottoType, int lottoNumber, int bonusNumber) {
		if (lottoType.getLottoNumber() == lottoNumber) {
			if (lottoType == LottoType.SECOND && bonusNumber == 0) {
				return false;
			}
			return true;
		}
		return false;
	}
}
