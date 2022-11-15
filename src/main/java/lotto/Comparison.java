package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Comparison {

	public static List<Integer> compareNumbers(List<Integer> winningNumbers, List<List<Integer>> myLottos, Integer bonusNumber) {
		Integer[] numberOfTimes = new Integer[Constant.LOTTO_NUMBERS_LENGTH.value + 2];
		Arrays.fill(numberOfTimes, 0);
		List<Integer> result = new ArrayList<Integer>(Arrays.asList(numberOfTimes));
		for (List<Integer> myLotto : myLottos) {
			int numberOfNumbers = countCorrectNumbers(winningNumbers, myLotto);
			boolean isSecondPlace = numberOfNumbers == Constant.SECOND_PLACE.condition && myLotto.contains(bonusNumber);
			if (isSecondPlace) {
				updateLottoResult(result, Constant.LOTTO_NUMBERS_LENGTH.value + 1);
				continue;
			}
			updateLottoResult(result, numberOfNumbers);
		}
		return result;
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

	public static List<Integer> updateLottoResult(List<Integer> result, int index) {

		Integer numberOfTimes = result.get(index);
		result.set(index, numberOfTimes + 1);
		
		return result;
	}
}
