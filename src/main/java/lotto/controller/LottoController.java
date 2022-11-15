package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util;
import lotto.enums.Constant;
import lotto.enums.Rank;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
	private final List<Lotto> lottos = new ArrayList<>();
	public void start() {
		Cash cash = inputCash();
		purchase(cash);
		AnswerLotto answerLotto = inputAnswerLotto();
		printResult(getRankCounts(answerLotto));
	}

	private Cash inputCash() {
		InputNumValidator cashValidator = new InputNumValidator(InputView.cashInput());
		return new Cash(Util.toLong(cashValidator.INPUT_VALUE));
	}

	private void purchase(Cash cash) {
		while (cash.canBuy()) {
			cash.withdraw();
			lottos.add(new Lotto(pickSortedUniqueNumbers()));
		}
		OutputView.printLottos(lottos);
	}

	private List<Integer> pickSortedUniqueNumbers() {
		List<Integer> newLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
		Collections.sort(newLotto);
		return newLotto;
	}

	private AnswerLotto inputAnswerLotto() {
		InputNumListValidator answerValidator = new InputNumListValidator(InputView.answerInput());
		List<Integer> basicNumbers = Util.getSplitList(answerValidator.INPUT_VALUE);
		InputNumValidator bonusValidator = new InputNumValidator(InputView.bonusInput());
		return new AnswerLotto(basicNumbers, Integer.parseInt(bonusValidator.INPUT_VALUE));
	}

	private List<Integer> getRankCounts(AnswerLotto answerLotto) {
		int[] rankCounts = new int[]{0, 0, 0, 0, 0, 0};
		initRankCount(answerLotto, rankCounts);
		return Arrays.stream(rankCounts)
				.boxed()
				.collect(Collectors.toList());
	}

	private void initRankCount(AnswerLotto answerLotto, int[] prize) {
		lottos.stream()
				.map(answerLotto::getRank)
				.forEach(rank -> prize[rank - 1]++);
	}

	private void printResult(List<Integer> prize) {
		OutputView.printPrize(prize);
		OutputView.printProfit(getProfit(prize));
	}

	private float getProfit(List<Integer> prizes) {
		Long totalPrizeMoney = getTotalPrize(prizes);
		int totalCount = prizes.stream()
				.reduce(Integer::sum)
				.get();
		return ((float) totalPrizeMoney / (Constant.LOTTO_COST.getValue() * totalCount)) * 100;
	}

	private Long getTotalPrize(List<Integer> prizes) {
		Long totalPrize = 0L;
		for (int rank = Rank.FIRST.getRank(); rank <= Rank.FIFTH.getRank(); rank++) {
			Rank prize = Rank.findByRank(rank);
			int count = prizes.get(rank - 1);
			totalPrize += (long) prize.getMoney() * count;
		}
		return totalPrize;
	}
}
