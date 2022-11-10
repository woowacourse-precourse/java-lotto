package lotto.view;

import lotto.Lotto;
import lotto.vo.LottoAmount;

import java.util.List;

public interface OutputView {
	void printLottoAmount(LottoAmount lottoAmount);

	void printLottos(List<Lotto> lottos);

	void printErrorMessage(Exception e);
}
