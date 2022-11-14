package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.SortedMap;

public class MessagePrint {

	public void purchaseLottoPrint() {
		System.out.println(Constants.PURCHASE_PRIZE_MESSAGE);
	}

	public void changeList(List<Integer> list) {
		System.out.println(list);
	}
}
