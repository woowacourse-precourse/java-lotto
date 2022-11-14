package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class MyView {

	private MyModel model;

	public MyView(MyModel model) {
		this.model = model;
	}

	public void getMoneyRequest() {
		System.out.println(OutMsg.MONEY_REQUEST.getMessage());
		String money = Console.readLine();
		model.addAttribute("money", money);
		System.out.println();
	}

	public void printLottos() {
		List<Lotto> Lottos = (List<Lotto>) model.getAttribute("Lottos");
		int amount = Lottos.size();
		System.out.println(amount + OutMsg.BUY_SUFFIX.getMessage());
		Lottos.stream().map(s->s.toString()).forEach(System.out::println);
		System.out.println();
	}

	public void getCorrectNumbers() {
		System.out.println(OutMsg.ANSWER_REQUEST.getMessage());
		String correctNumbers = Console.readLine();
		model.addAttribute("correctNumbers", correctNumbers);
		System.out.println();
	}

	public void getBonusNumber() {
		System.out.println(OutMsg.BONUS_REQUEST.getMessage());
		String bonus = Console.readLine();
		model.addAttribute("bonusNumber", bonus);
		System.out.println();
	}

	public void printAnalysis() {
		System.out.println(OutMsg.ANALYSIS_PREFIX.getMessage());
		List<Integer> analysis = (List<Integer>)model.getAttribute("analysis");
		System.out.println(OutMsg.THREE_HIT.getMessage() + analysis.get(0) + "개");
		System.out.println(OutMsg.FOUR_HIT.getMessage() + analysis.get(1) + "개");
		System.out.println(OutMsg.FIVE_HIT_WO_BONUS.getMessage() + analysis.get(2) + "개");
		System.out.println(OutMsg.FIVE_HIT_W_BONUS.getMessage() + analysis.get(3) + "개");
		System.out.println(OutMsg.SIX_HIT.getMessage() + analysis.get(4) + "개");
		System.out.println(model.getAttribute("profitMsg"));
	}
}
