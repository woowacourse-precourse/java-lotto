package lotto.view;

import lotto.vo.Lotto;
import lotto.vo.LottoAmount;

import java.util.List;

public class OutputViewImpl implements OutputView {

	public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
	public static final String BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";

	@Override
	public void printLottoAmount(LottoAmount lottoAmount) {
		System.out.printf((BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT) + "%n", lottoAmount.getAmount());
	}

	@Override
	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.toString());
		}
		System.out.println();
	}

	@Override
	public void printErrorMessage(Exception e) {
		System.out.printf((ERROR_MESSAGE_FORMAT) + "%n", e.getMessage());
	}
}
