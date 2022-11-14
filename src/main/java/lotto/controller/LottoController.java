package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util;
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
		printResult(calculatePrize(answerLotto));
	}

	private Cash inputCash() {
		InputNumValidator cashValidator = new InputNumValidator(InputView.buyInput());
		return new Cash(Util.toLong(cashValidator.INPUT_VALUE));
	}

	private void purchase(Cash cash) {
		addNewLotto(cash);
		OutputView.printLottos(lottos);
	}

	private void addNewLotto(Cash cash) {
		while (cash.canBuy()) {
			cash.withdraw();
			List<Integer> lottoNums = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			Collections.sort(lottoNums);
			lottos.add(new Lotto(lottoNums));
		}
	}

	private AnswerLotto inputAnswerLotto() {
		InputNumListValidator answerValidator = new InputNumListValidator(InputView.answerInput());
		List<Integer> numbers = Util.getSplitList(answerValidator.INPUT_VALUE);
		InputNumValidator bonus = new InputNumValidator(InputView.bonusInput());
		return new AnswerLotto(numbers, Integer.parseInt(bonus.INPUT_VALUE));
	}

	private List<Integer> calculatePrize(AnswerLotto answerLotto) {
		int[] prize = new int[]{0, 0, 0, 0, 0, 0};
		initRankCount(answerLotto, prize);
		return Arrays.stream(prize)
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
		OutputView.printProfit(prize);
	}
}
