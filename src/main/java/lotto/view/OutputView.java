package lotto.view;

import lotto.dto.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Profit;

import java.util.List;

public interface OutputView {
	void printLottoBuyingInfo(LottoBuyingInfo lottoBuyingInfo);

	void printLottos(List<Lotto> lottos);

	void printErrorMessage(Exception e);

	void printScoreMessage(ScoreInfo scoreInfo);

    void printProfitPercentageMessage(Profit profit);
}
