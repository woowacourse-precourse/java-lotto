package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.util.ViewConst;

public class OutputView {

	public void printUserLotto(List<Lotto> userLotto) {
		for (Lotto lotto : userLotto) {
			System.out.println(lotto.getNumbers());
		}
	}

	public void printLottoCount(Integer lottoCount) {
		System.out.println(lottoCount / 1000 + ViewConst.LOTTO_COUNT_OUTPUT);
	}

	public void printUserStatistics(Integer buyPrice) {
		System.out.println(ViewConst.STATISTICS_OUTPUT);
		Arrays.stream(Rank.values())
			.forEach(i -> System.out.println(i.getUserStatisticsResult()));
		System.out.println("총 수익률은 " + Rank.findYield(buyPrice) + "%입니다.");
	}

}
