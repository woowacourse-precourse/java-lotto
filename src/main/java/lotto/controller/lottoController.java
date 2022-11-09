package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ExceptionHandler;
import lotto.View.Input;

public class lottoController {

	private static int checkQuantityOfLotto() {
		int quantity;
		int money = Integer.parseInt(Input.buyLotto());

		ExceptionHandler.checkMoney(money);
		quantity = money / 1000;

		return quantity;
	}
	private static void publishLotto(int quantity) {
		List<List<Integer>> candidateLotto = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			candidateLotto.add(pickLottoNumbers());
		}
	}
}
