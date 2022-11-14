package lotto.view;

import lotto.dto.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Profit;
import lotto.vo.Score;

import java.text.DecimalFormat;
import java.util.List;

public class OutputViewImpl implements OutputView {

	public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
	public static final String BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
	public static final String SCORE_MESSAGE_PREFIX = "당첨 통계\n" +
			"---";
	public static final String SCORE_MESSAGE_FORMAT = "%s (%s원) - %d개";
	public static final String MONEY_DECIMAL_PATTERN = "###,###";
	public static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.\n";

	@Override
	public void printLottoBuyingInfo(LottoBuyingInfo lottoBuyingInfo) {
		System.out.printf((BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT) + "%n", lottoBuyingInfo.getAmount());
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

	@Override
	public void printScoreMessage(ScoreInfo scoreInfo) {
		System.out.println(SCORE_MESSAGE_PREFIX);
		for (Score score : Score.values()) {
			System.out.println(convertToScoreMessageFormat(scoreInfo, score));
		}
	}

	@Override
	public void printProfitPercentageMessage(Profit profit) {
		System.out.printf(PROFIT_MESSAGE_FORMAT, profit);
	}

	private String convertToScoreMessageFormat(ScoreInfo scoreInfo, Score score) {
		return String.format(SCORE_MESSAGE_FORMAT,
				score.getDescription(),
				convertPriceToMoneyFormat(score.getPrice()),
				scoreInfo.get(score));
	}

	private String convertPriceToMoneyFormat(Integer price) {
		return new DecimalFormat(MONEY_DECIMAL_PATTERN).format(price);
	}
}
