package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
	private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + OUTPUT_LOTTO_COUNT_MESSAGE);
	}

	public void printLottoNumbers(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}
}
