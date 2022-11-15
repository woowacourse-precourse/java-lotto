package lotto.controller;

import static lotto.utils.TypeConversion.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicketNumberGenerator {

	public static List<Integer> generate() {
		List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return getSortedIntegers(lottoNumbers);
	}
}
