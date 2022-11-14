package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.view.constant.InputMessage.*;
import static lotto.view.constant.OutputMessage.*;

import java.util.List;

import lotto.domain.Lotto;

public class LottoView {

	public static void displayInputPurchaseAmount() {
		System.out.println(INPUT_PURCHASE_AMOUNT);
	}

	public static void displayPurchasedLottoAmount(int purchasedLottoCount) {
		System.out.printf(OUTPUT_PURCHASE_AMOUNT, purchasedLottoCount);
	}

	public static void displayPurchasedLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getLottoNumbers());
		}
	}

	public static String getUserInput() {
		return readLine();
	}

	public static void displayInputWinningLotto() {
		System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
	}

	public static void displayInputBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER);
	}

}
