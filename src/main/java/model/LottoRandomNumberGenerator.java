package model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoRandomNumberGenerator {

	public List<Integer> randomUniqueNumbersGenerate() {
		List<Integer> sixLengthRandomUniqueNumbers = pickUniqueNumbersInRange(1, 45, 6);
		return sixLengthRandomUniqueNumbers;
	}
}