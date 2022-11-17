package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Comparison {

	public static List<Integer> compareNumbers(List<Integer> winningNumbers, List<List<Integer>> myLottos, Integer bonusNumber) {

		List<Integer> result = intializeResult();

		for (List<Integer> myLotto : myLottos) {

			int numberOfNumbers = countCorrectNumbers(winningNumbers, myLotto);
			boolean isSecondPlace = numberOfNumbers == Constant.SECOND_PLACE.condition && myLotto.contains(bonusNumber);

			result = updateLottoResult(numberOfNumbers, isSecondPlace, result);
		}
		return result;
	}

	public static List<Integer> intializeResult() {

		int length = Constant.LOTTO_NUMBERS_LENGTH.value + 2;

		Integer[] numberOfTimes = new Integer[length];
		Arrays.fill(numberOfTimes, 0);

		return new ArrayList<Integer>(Arrays.asList(numberOfTimes));
	}

	public static Integer countCorrectNumbers(List<Integer> winningNumbers, List<Integer> myLotto) {

		Integer count = 0;

		for (Integer number : myLotto) {

			boolean isMatch = winningNumbers.contains(number);
			if (isMatch) {
				count++;
			}
		}
		return count;
	}

	public static List<Integer> updateLottoResult(int numberOfNumbers, boolean isSecondPlace, List<Integer> result) {

		if (!isSecondPlace) {
			return increaseNumberOfTimes(result, numberOfNumbers);
		}

		int index = Constant.LOTTO_NUMBERS_LENGTH.value + 1;
		return increaseNumberOfTimes(result, index);
	}

	public static List<Integer> increaseNumberOfTimes(List<Integer> result, int index) {

		Integer numberOfTimes = result.get(index);
		result.set(index, numberOfTimes + 1);
		
		return result;
	}
}
