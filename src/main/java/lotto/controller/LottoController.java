package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Util;
import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.model.NumberValidator;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoController {
	private Cash cash;
	private List<Lotto> lottos = new ArrayList<>();
	public void start(){
		NumberValidator cashValidator = new NumberValidator(InputView.buyInput());
		cash = new Cash(Util.toLong(cashValidator.INPUT_VALUE));
		purchase();
	}

	private void purchase(){
		addNewLotto();
	}

	private void addNewLotto() {
		while (cash.canBuy()) {
			cash.withdraw();
			List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(lottoNums);
			lottos.add(new Lotto(lottoNums));
		}
	}
}
