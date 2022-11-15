package lotto;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO: 프로그램 구현
		
		try {
			playLotto();
		}
		
		catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static void playLotto() {
	
		int payment = User.getPayment();
		int purchaseQuantity = payment / Constant.PAYMENT_UNIT.value;

		List<List<Integer>> myLottos = getMyLottos(purchaseQuantity);
		List<Integer> winningNumbers = User.getWinningNumbers();

		Integer bonusNumber = User.getBonusNumber(winningNumbers);

		List<Integer> result = Comparison.compareNumbers(winningNumbers, myLottos, bonusNumber);

		showLottoResult(result);
		System.out.println(Result.getRateOfReturn(payment, result));
	}

	public static List<List<Integer>> getMyLottos(int purchaseQuantity) {

		System.out.println("\n" + purchaseQuantity + "개를 구매했습니다.");

		List<List<Integer>> myLottos = new ArrayList<List<Integer>>(purchaseQuantity);

		for (int count = 0; count < purchaseQuantity; count++) {

			Lotto lotto = new Lotto(Lotto.createRandomNumbers());
			System.out.println(lotto.getNumbers());
			myLottos.add(lotto.getNumbers());
		}
		return myLottos;
	}

	public static void showLottoResult(List<Integer> result) {

		System.out.println("\n당첨 통계\n---");

		for (int index = Constant.FIFTH_PLACE.condition; index <= Constant.FIRST_PLACE.condition; index++) {

			Integer numberOfTimes = result.get(index);
			System.out.println(Result.getLottoResultMessage(index, numberOfTimes));

			if (index == Constant.SECOND_PLACE.condition) {

				int _index = result.size() - 1;
				System.out.println(Result.getLottoResultMessage(_index, result.get(_index)));
			}
		}
	}
}