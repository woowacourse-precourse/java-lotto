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
		stringValidator.validateCorrectString(numbersString);
		List<String> stringList = Arrays.asList(numbersString.split(","));
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

	public void handleAnalysis() {
		List<Lotto> lottos = (List<Lotto>)model.getAttribute("Lottos");
		Lotto correctLotto = (Lotto)model.getAttribute("correctLotto");
		int bonusNumber = (int)model.getAttribute("bonusNumber");
		List<Integer> analysis = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
		for (Lotto lotto : lottos) {
			int corrections = getCorrections(lotto, correctLotto);
			boolean hasBonus = isThereBonus(lotto, bonusNumber);
			addToAnalysis(analysis, corrections, hasBonus);
		}
		model.addAttribute("analysis", analysis);
		view.printAnalysis();
	}

	public int getCorrections(Lotto lotto, Lotto correctLotto) {
		List<Integer> input = lotto.getLotto();
		List<Integer> target = correctLotto.getLotto();
		return (int)input.stream().filter(i -> target.contains(i)).count();
	}

	public boolean isThereBonus(Lotto lotto, int bonusNumber) {
		List<Integer> input = lotto.getLotto();
		return input.contains(bonusNumber);
	}

	public void addToAnalysis(List<Integer> analysis, int corrections, boolean hasBonus) {
		if (corrections == 3 || corrections == 4 || corrections == 6) {
			analysis.set(corrections-3, analysis.get(corrections-3)+1);
			return;
		}
		if (corrections == 5 || !hasBonus) {
			analysis.set(3, analysis.get(3)+1);
			return;
		}
		if (corrections == 5 || hasBonus) {
			analysis.set(4, analysis.get(4)+1);
		}
	}
}
