package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class MyView {

	private MyModel model;

	public MyView(MyModel model) {
		this.model = model;
	}

	public void getMoneyRequest() {
		String message = OutMsg.MONEY_REQUEST.getMessage();
		System.out.println(message);

		int money = Integer.parseInt(Console.readLine());
		model.addAttribute("money", money);
		System.out.println();
	}

	public void printLottos() {
		List<Lotto> Lottos = (List<Lotto>) model.getAttribute("Lottos");
		int amount = Lottos.size();
		String buyMessage = Integer.toString(amount) + OutMsg.BUY_SUFFIX.getMessage();
		System.out.println(buyMessage);
		Lottos.stream().map(s->s.toString()).forEach(System.out::println);
		System.out.println();
	}
}
