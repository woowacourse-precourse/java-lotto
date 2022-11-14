package model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRandomNumberGenerator {

	public List<Integer> randomUniqueNumbersGenerate() {
		List<Integer> sixLengthRandomUniqueNumbers = pickUniqueNumbersInRange(1, 45, 6);
		validate(sixLengthRandomUniqueNumbers);
		return sixLengthRandomUniqueNumbers;
	}

	private void validate(List<Integer> sixLengthRandomUniqueNumbers) {
		validateRange(sixLengthRandomUniqueNumbers);
		validateSize(sixLengthRandomUniqueNumbers);
		validateDuplicate(sixLengthRandomUniqueNumbers);
	}

	private void validateRange(List<Integer> randomNumbers) {
		for (int randomNumber : randomNumbers) {
			if (randomNumber < 1) {
				throw new IllegalArgumentException("[ERROR] 난수 생성 시 최소값(1) 보다 작은 값이 있습니다.");
			}
			if (randomNumber > 45) {
				throw new IllegalArgumentException("[ERROR] 난수 생성 시 최대값(45) 보다 큰 값이 있습니다.");
			}
		}
	}

	private void validateSize(List<Integer> randomNumbers) {
		if (randomNumbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 생성한 난수의 개수가 6개가 아닙니다.");
		}

	}

	private void validateDuplicate(List<Integer> randomNumbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(randomNumbers);
		if (uniqueNumbers.size() != randomNumbers.size()) {
			throw new IllegalArgumentException("[ERROR] 난수 생성 시 중복된 값이 있습니다.");
		}
	}
}