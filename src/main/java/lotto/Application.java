package lotto;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		
		int payment = User.getPayment();
		int purchaseQuantity = payment / Constant.PAYMENT_UNIT.value;

		List<List<Integer>> myLottos = getMyLottos(purchaseQuantity);
		List<Integer> winningNumbers = User.getWinningNumbers();

		Integer bonusNumber = User.getBonusNumber(winningNumbers);

		List<Integer> result = compareNumbers(winningNumbers, myLottos, bonusNumber);

		showLottoResult(result);
		showRateOfReturn(payment, result);
	}

	public static List<List<Integer>> getMyLottos(int purchaseQuantity) {

		System.out.println("\n" + purchaseQuantity + "개를 구매했습니다.");

		List<List<Integer>> myLottos = new ArrayList<List<Integer>>(purchaseQuantity);

		for (int count = 0; count < purchaseQuantity; count++) {

			List<Integer> lotto = Lotto.newLotto().getNumbers();
			System.out.println(lotto);
			myLottos.add(lotto);
		}
		return myLottos;
	}

	public static void showLottoResult(List<Integer> result) {

		System.out.println("\n당첨 통계\n---");

		for (int index = Constant.FIFTH_PLACE.condition; index <= Constant.FIRST_PLACE.condition; index++) {

			Integer numberOfTimes = result.get(index);
			System.out.println(getLottoResultMessage(index, numberOfTimes));

			if (index == Constant.SECOND_PLACE.condition) {

				int _index = result.size() - 1;
				System.out.println(getLottoResultMessage(_index, result.get(_index)));
			}
		}
	}

	public static List<Integer> compareNumbers(List<Integer> winningNumbers, List<List<Integer>> myLottos, Integer bonusNumber) {

		int length = Constant.LOTTO_NUMBERS_LENGTH.value + 2;
		Integer[] numberOfTimes = new Integer[length];
		Arrays.fill(numberOfTimes, 0);

		List<Integer> result = new ArrayList<Integer>(Arrays.asList(numberOfTimes));

		for (List<Integer> myLotto : myLottos) {

			int numberOfNumbers = countCorrectNumbers(winningNumbers, myLotto);

			boolean isSecondPlace = numberOfNumbers == Constant.SECOND_PLACE.condition && myLotto.contains(bonusNumber);
			if (isSecondPlace) {

				updateLottoResult(result, length - 1);
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

	public static String getLottoResultMessage(int index, Integer numberOfTimes) {

		if (index == Constant.FIRST_PLACE.condition)
			return Constant.FIRST_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.LOTTO_NUMBERS_LENGTH.value + 1)
			return Constant.SECOND_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.THIRD_PLACE.condition)
			return Constant.THIRD_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.FOURTH_PLACE.condition)
			return Constant.FOURTH_PLACE.resultMessage + numberOfTimes + "개";

		if (index == Constant.FIFTH_PLACE.condition)
			return Constant.FIFTH_PLACE.resultMessage + numberOfTimes + "개";

		return "";
	}

	public static void showRateOfReturn(int payment, List<Integer> result) {

		int totalPrizeMoney = getTotalPrizeMoney(payment, result);

		double rateOfReturn = (double) totalPrizeMoney / payment * 100;
		
		String message = "총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.";
		System.out.println(message);
	}

	public static int getTotalPrizeMoney(int payment, List<Integer> result) {

		int totalPrizeMoney = 0;
		int startIndex = Constant.FIFTH_PLACE.condition;
		int endIndex = Constant.LOTTO_NUMBERS_LENGTH.value + 1;

		for (int numberOfNumbers = startIndex; numberOfNumbers <= endIndex; numberOfNumbers++) {

			Integer numberOfTimes = result.get(numberOfNumbers);
			if (numberOfTimes == 0)
				continue;

			totalPrizeMoney += numberOfTimes * getPrizeMoney(numberOfNumbers);
		}
		return totalPrizeMoney;
	}

	public static int getPrizeMoney(int index) {

		if (index == Constant.FIRST_PLACE.condition)
			return Constant.FIRST_PLACE.prizeMoney;

		if (index == Constant.LOTTO_NUMBERS_LENGTH.value + 1)
			return Constant.SECOND_PLACE.prizeMoney;

		if (index == Constant.THIRD_PLACE.condition)
			return Constant.THIRD_PLACE.prizeMoney;

		if (index == Constant.FOURTH_PLACE.condition)
			return Constant.FOURTH_PLACE.prizeMoney;

		if (index == Constant.FIFTH_PLACE.condition)
			return Constant.FIFTH_PLACE.prizeMoney;

		return 0;
	}
}