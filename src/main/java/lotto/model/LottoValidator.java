package lotto.model;

import lotto.enums.Constant;
import lotto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {

	public static void isCorrectRange(int num) {
		if (!Util.inRangeCheck(num, Constant.START_RANGE.getValue(), Constant.END_RANGE.getValue())) {
			throw new IllegalArgumentException("It is not in correct range");
		}
	}

	public static void isCorrectSize(List<Integer> answer) {
		if (!Util.isCorrectSize(answer, Constant.LOTTO_SIZE.getValue())) {
			throw new IllegalArgumentException("It is not correct size");
		}
	}

	public static void isDistinctNumbers(List<Integer> answer, Integer bonus) {
		List<Integer> joinNums = new ArrayList<>();
		joinNums.addAll(answer);
		joinNums.add(bonus);
		List<Integer> distinctNums = joinNums.stream()
				.distinct()
				.collect(Collectors.toList());
		if (joinNums.size() != distinctNums.size()) {
			throw new IllegalArgumentException("There has overlapping numbers");
		}
	}
}
