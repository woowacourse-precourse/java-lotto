package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

public class LottoNumbersGenerator {
	private List<Integer> lottoNumbers;

	private void generate() {
		lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstant.MINIMUM_LOTTO_NUMBER,
			LottoConstant.MAXIMUM_LOTTO_NUMBER, LottoConstant.COUNT_OF_LOTTO_NUMBERS);
		lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
	}

	public List<Integer> getLottoNumbers() {
		generate();
		return lottoNumbers;
	}
}
