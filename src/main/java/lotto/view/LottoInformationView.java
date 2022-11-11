package lotto.view;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.Lotto;

public class LottoInformationView {

	public static final String MESSAGE_PURCHASE = "개를 구매했습니다.";

	public LottoInformationView(int purchaseCount, List<Lotto> lottoBundle) {
		PurchaseAmount(purchaseCount);
		LottoNumber(lottoBundle);
	}

	public void PurchaseAmount(int purchaseAmount) {
		System.out.println(purchaseAmount + MESSAGE_PURCHASE);
	}

	public void LottoNumber(List<Lotto> lottoBundle) {
		Stream<Lotto> lottoStream = lottoBundle.stream();
		lottoStream.forEach(System.out::println);
	}
}
