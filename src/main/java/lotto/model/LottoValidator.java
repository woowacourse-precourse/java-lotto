package lotto.model;

import lotto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {
	private static final int START_RANGE = 1;
	private static final int END_RANGE = 45;
	private static final int SIZE = 6;

	public static void isCorrectRange(int num) {
		if (!Util.inRangeCheck(num, START_RANGE, END_RANGE)) {
			throw new IllegalArgumentException("It is not in correct range");
		}
	}

	public static void isCorrectSize(List<Integer> answer){
		if (!Util.isCorrectSize(answer, SIZE)) {
			throw new IllegalArgumentException("It is not correct size");
		}
	}

	public static void isDistinctNumbers(List<Integer> answer, Integer bonus){
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
