package lotto;

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
	}
}
