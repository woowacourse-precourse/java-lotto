package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {

	private MyModel model;
	private MyView view;
	private
	StringValidator stringValidator = new StringValidator();

	public LottoController(MyModel model, MyView view) {
		this.model = model;
		this.view = view;
	}

	public List<Lotto> generateLottos() {
		int money = getMoney();
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < money/1000; i++) {
			Lotto lotto = generateLotto();
			lottos.add(lotto);
		}
		model.addAttribute("Lottos", lottos);
		view.printLottos();
		return lottos;
	}

	private int getMoney() {
		view.getMoneyRequest();
		String moneyString = (String)model.getAttribute("money");
		stringValidator.validateMoneyString(moneyString);
		return Integer.parseInt(moneyString);
	}

	public Lotto generateLotto() {
		List<Integer> uniqueRandNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		return new Lotto(uniqueRandNumbers);
	}

	public void registerAnswers() {
		registerCorrectLotto();
		registerBonusNumber();
	}

	private void registerCorrectLotto() {
		view.getCorrectNumbers();
		String numbersString = (String)model.getAttribute("correctNumbers");
		List<String> stringList = Arrays.asList(numbersString.split(","));
		// TODO: 숫자와 쉼표로만 구성되었는지 점검 필요
		List<Integer> intList = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
		Lotto lotto = new Lotto(intList);
		model.addAttribute("correctLotto", lotto);
	}

	private void registerBonusNumber() {
		view.getBonusNumber();
		String bonusNumber = (String)model.getAttribute("bonusNumber");
		Lotto correctLotto = (Lotto)model.getAttribute("correctLotto");
		stringValidator.validateBonusString(bonusNumber, correctLotto);
		model.addAttribute("bonusNumber", Integer.parseInt(bonusNumber));
	}

	//
	// private void handleAnalysis(List<Lotto> lottos, List<Integer> answer) {
	//
	// }
}
