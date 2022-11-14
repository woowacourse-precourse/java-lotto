package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.dto.StatisticsDto;
import lotto.util.ViewConst;

public class OutputView {

	public void printUserLotto(List<Lotto> userLotto) {
		for (Lotto lotto : userLotto) {
			System.out.println(lotto.toString());
		}
	}

	public void printLottoCount(Integer lottoCount) {
		System.out.println(lottoCount + ViewConst.LOTTO_COUNT_OUTPUT);
	}

	public void printUserStatistics(StatisticsDto statisticsDto) {
		System.out.println(ViewConst.STATISTICS_OUTPUT);
		List<String> userTotalRankResult = statisticsDto.getUserTotalRankResult();
		userTotalRankResult.stream().forEach(System.out::println);
		System.out.println("총 수익률은 " + statisticsDto.getYield() + "%입니다.");
	}

	public void printError(String errorMessage) {
		System.out.println(errorMessage);
	}

}
