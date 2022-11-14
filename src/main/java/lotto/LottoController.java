package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {

	private MyModel model;
	private MyView view;

	public LottoController(MyModel model, MyView view) {
		this.model = model;
		this.view = view;
	}

	private List<Lotto> generateLottos() {
		int money = getMoney();
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < money/1000; i++) {
			Lotto lotto = generateLotto();
			lottos.add(lotto);
		}
		return lottos;
	}

	private int getMoney() {
		StringValidator stringValidator = new StringValidator();
		view.getMoneyRequest();
		String moneyString = (String)model.getAttribute("money");
		stringValidator.validateMoneyString(moneyString);
		return Integer.parseInt(moneyString);
	}

	public Lotto generateLotto() {
		List<Integer> uniqueRandNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return new Lotto(uniqueRandNumbers);
	}

	// private List<Integer> registerAnswer() {
	//
	// }
	//
	// private void handleAnalysis(List<Lotto> lottos, List<Integer> answer) {
	//
	// }
}
