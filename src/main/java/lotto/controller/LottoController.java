package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
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
	private List<Lotto> lottos = new ArrayList<>();
	public void start(){
		NumberValidator cashValidator = new NumberValidator(InputView.buyInput());
		Cash cash = new Cash(Util.toLong(cashValidator.INPUT_VALUE));
		purchase(cash);
		AnswerLotto answerLotto = getAnswerLotto();
		List<Integer> prize = getPrize(answerLotto);

	}

	private void purchase(Cash cash){
		addNewLotto(cash);
		OutputView.printLottos(lottos);
	}

	private void addNewLotto(Cash cash) {
		while (cash.canBuy()) {
			cash.withdraw();
			List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(lottoNums);
			lottos.add(new Lotto(lottoNums));
		}
	}

	private AnswerLotto getAnswerLotto(){
		LottoNumsValidator answerValidator = new LottoNumsValidator(InputView.answerInput());
		List<Integer> numbers = Util.getSplitList(answerValidator.INPUT_VALUE);
		NumberValidator bonus = new NumberValidator(InputView.bonusInput());
		return new AnswerLotto(numbers, Integer.parseInt(bonus.INPUT_VALUE));
	}

	private List<Integer> getPrize(AnswerLotto answerLotto){
		int[] prize = new int[]{0, 0, 0, 0, 0};
		lottos.stream()
				.map(answerLotto::getRank)
				.filter(rank -> rank < 6)
				.forEach(rank -> prize[rank - 1]++);
		return Arrays.stream(prize)
				.boxed()
				.collect(Collectors.toList());
	}

}
