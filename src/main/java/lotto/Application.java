package lotto;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현

		int payment = User.getPayment();
		int purchaseQuantity = payment / Constant.PAYMENT_UNIT.value;

		List<List<Integer>> myLottos = getMyLottos(purchaseQuantity);
		List<Integer> winningNumbers = User.getWinningNumbers();

		Integer bonusNumber = User.getBonusNumber(winningNumbers);

		showLottoResult(winningNumbers, myLottos);
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

	public static void showLottoResult(List<Integer> winningNumbers, List<List<Integer>> myLottos) {

		List<Integer> result = compareNumbers(winningNumbers, myLottos);
		
		System.out.println(result);
		System.out.println("\n당첨 통계\n---");
		
		int startIndex = Constant.FIFTH_PLACE.condition;
		int endIndex = Constant.FIRST_PLACE.condition;
		for (int numberOfNumbers = startIndex; numberOfNumbers <= endIndex; numberOfNumbers++) {

			Integer numberOfTimes = result.get(numberOfNumbers);
			
			String message = getLottoResultMessage(numberOfNumbers) + numberOfTimes + "개";

			System.out.println(message);
		}
	}

	public static List<Integer> compareNumbers(List<Integer> winningNumbers, List<List<Integer>> myLottos) {

		int length = Constant.LOTTO_NUMBERS_LENGTH.value + 1;
		List<Integer> result = new ArrayList<Integer>(length);
		
		for (int index = 0; index < length; index++) {
			result.add(0);
		}

		for (List<Integer> myLotto : myLottos) {

			int numberOfNumbers = countCorrectNumbers(winningNumbers, myLotto);

			Integer numberOfTimes = result.get(numberOfNumbers);
			result.set(numberOfNumbers, numberOfTimes + 1);

			// ㅜ false
			// System.out.println(winningNumbers == numbers);

			// ㅜ true
			// System.out.println(winningNumbers.equals(numbers));
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
	
	public static String getLottoResultMessage(int numberOfNumbers) {

		if (numberOfNumbers == Constant.FIRST_PLACE.condition) {
			return Constant.FIRST_PLACE.resultMessage;
		}

		if (numberOfNumbers == Constant.SECOND_PLACE.condition) {
			return Constant.SECOND_PLACE.resultMessage;
		}

		if (numberOfNumbers == Constant.THIRD_PLACE.condition) {
			return Constant.THIRD_PLACE.resultMessage;
		}

		if (numberOfNumbers == Constant.FOURTH_PLACE.condition) {
			return Constant.FOURTH_PLACE.resultMessage;
		}

		if (numberOfNumbers == Constant.FIFTH_PLACE.condition) {
			return Constant.FIFTH_PLACE.resultMessage;
		}

		return "";
	}
}