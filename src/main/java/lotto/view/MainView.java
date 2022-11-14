package lotto.view;

import java.util.List;

import lotto.domain.Lotto;

public class MainView {

	private static final String INPUT_PURCHASE_QUANTITY = "구입금액을 입력해 주세요.";
	public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
	public static final String INPUT_WINNING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	public static final String PURCHASE_LOTTO_GROUP_SIZE = "개를 구매했습니다.";

	public static void inputPurchaseQuantity() {
		System.out.println(INPUT_PURCHASE_QUANTITY);
	}

	public static void inputWinningNumber() {
		System.out.println(INPUT_WINNING_NUMBER);
	}

	public static void inputWinningBonusNumber() {
		System.out.println(INPUT_WINNING_BONUS_NUMBER);
	}

	public static void purchaseLottoGroup(int lottoSize) {
		System.out.println(lottoSize + PURCHASE_LOTTO_GROUP_SIZE);
	}

	public static void printAllLotto(List<Lotto> lottos) {
		lottos.forEach(Lotto::lottoPrint);
	}
}
