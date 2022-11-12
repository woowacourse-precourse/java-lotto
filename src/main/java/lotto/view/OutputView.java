package lotto.view;

import lotto.domain.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoAmount;

import java.util.List;

public interface OutputView {
	void printLottoAmount(LottoAmount lottoAmount);

	void printLottos(List<Lotto> lottos);

	void printErrorMessage(Exception e);

	void printScoreMessage(ScoreInfo scoreInfo);
}
