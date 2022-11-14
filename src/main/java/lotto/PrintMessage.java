package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintMessage {
	public void purchasePriceMessage() {
		System.out.println(Constant.PURCHASE_PRICE_MESSAGE_QUESTION);
	}

	public void purchaseMessage(int count) {
		System.out.println(count + Constant.BOUGHT_LOTTO_TICKETS);
	}

	public void printPurchaseLotto(List<List<Integer>> purchaseLotto) {
		for (List<Integer> onePurchaseLotto : purchaseLotto) {
			List<Integer> copyPurchaseLotto = new ArrayList<>();
			copyPurchaseLotto.addAll(onePurchaseLotto);
			Collections.sort(copyPurchaseLotto);
			System.out.println(copyPurchaseLotto);
		}
	}
}
