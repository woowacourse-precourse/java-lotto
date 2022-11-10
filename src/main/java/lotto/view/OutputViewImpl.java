package lotto.view;

import lotto.Lotto;
import lotto.vo.LottoAmount;

import java.util.List;

public class OutputViewImpl implements OutputView {

	public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
	public static final String BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";

	@Override
	public void printLottoAmount(LottoAmount lottoAmount) {
		System.out.printf(BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT, lottoAmount.getAmount());
	}

	@Override
	public void printLottos(List<Lotto> lottos) {

	}

	@Override
	public void printErrorMessage(Exception e) {
		System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
	}
}
