package lotto.domain;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateNumbers {
	public static int bonusNumber;
	public List<Integer> lottoNumbers;

	public List<Integer> lotto() {
		lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		bonusNumber = Randoms.pickNumberInRange(1, 45);
		while (lottoNumbers.contains(bonusNumber)) {
			bonusNumber = Randoms.pickNumberInRange(1, 45);
		}
		lottoNumbers.add(bonusNumber);
		Collections.sort(lottoNumbers);
		return lottoNumbers;
	}
	
}
